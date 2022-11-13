package com.moon.queue;

/**
 * @author Chanmoey
 */
public class LoopQueueJustSize<E> implements Queue<E>{

    private Object[] data;

    /**
     * front指向队首
     */
    private int front;

    /**
     * front指向队尾的下一个位置
     */
    private int tail;

    private int size;

    /**
     * 通过size判断队列空或者队列不空
     *
     * @param capacity 容量
     */
    public LoopQueueJustSize(int capacity) {
        this.data = new Object[capacity];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueueJustSize() {
        this(1 << 4);
    }

    public int getCapacity() {
        return data.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (getSize() == getCapacity()) {
            grow(getCapacity() << 1);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void grow(int newCapacity) {
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(i + front) % getCapacity()];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is Empty!");
        }

        E ret = (E) data[front];

        // 帮助垃圾回收
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size <= (getCapacity() >> 2) && (getCapacity() >> 1) != 0) {
            grow(getCapacity() >> 1);
        }
        return ret;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is Empty!");
        }
        return (E) data[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d, capacity = %d front {", size, getCapacity()));
        for (int i = 0; i < getSize(); i ++) {
            sb.append(data[(i + front) % getCapacity()]);
            if (i != getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append("} tail");
        return sb.toString();
    }
}
