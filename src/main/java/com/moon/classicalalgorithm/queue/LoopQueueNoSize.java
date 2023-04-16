package com.moon.classicalalgorithm.queue;

/**
 * @author Chanmoey
 */
public class LoopQueueNoSize<E> implements Queue<E> {

    private Object[] data;

    /**
     * front指向队首
     */
    private int front;

    /**
     * front指向队尾的下一个位置
     */
    private int tail;

    /**
     * 本循环数组的实现，会浪费一个空间，所以要把开辟capacity+1的空间。
     *
     * @param capacity 容量
     */
    public LoopQueueNoSize(int capacity) {
        this.data = new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
    }

    public LoopQueueNoSize() {
        this(1 << 4);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        if (front <= tail) {
            return tail - front;
        } else {
            // 整个数组空间 - 没有元素的空间
            return data.length - (front - tail);
        }
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            grow(getCapacity() << 1);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    private void grow(int newCapacity) {

        Object[] newData = new Object[newCapacity + 1];
        // 提前把size保存起来。
        int size = getSize();
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
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
        data[front] = null;
        front = (front + 1) % data.length;

        if (getSize() <= (getCapacity() >> 2) && (getCapacity() >> 1) != 0) {
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
        sb.append(String.format("Queue: size = %d, capacity = %d front {", getSize(), getCapacity()));
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(", ");
            }
        }
        sb.append("} tail");
        return sb.toString();
    }
}
