package com.moon.classicalalgorithm.queue;

/**
 * @author Chanmoey
 */
public class Deque<E> {

    private Object[] data;
    private int front;
    private int tail;
    private int size;

    public Deque(int capacity) {
        this.data = new Object[capacity];
        this.front = 0;
        this.tail = 0;
        size = 0;
    }

    public Deque() {
        this(1 << 4);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public void addLast(E e) {
        if (getSize() == getCapacity()) {
            grow(getCapacity() << 1);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public void addFirst(E e) {
        if (getSize() == getCapacity()) {
            grow(getCapacity() << 1);
        }

        front = front == 0 ? data.length - 1 : front - 1;
        data[front] = e;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Deque is Empty.");
        }

        E ret = (E) data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (getSize() == (getCapacity() << 2) && (getCapacity() << 1) != 0)
            grow(getCapacity() >> 1);
        return ret;
    }

    @SuppressWarnings("unchecked")
    public E removeLast() {

        if (isEmpty()) {
            throw new IllegalArgumentException("Deque is Empty.");
        }

        tail = tail == 0 ? data.length - 1 : tail - 1;
        E ret = (E) data[tail];
        data[tail] = null;
        size--;
        if (getSize() == (getCapacity() << 2) && (getCapacity() << 1) != 0)
            grow(getCapacity() >> 1);
        return ret;
    }

    @SuppressWarnings("unchecked")
    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Deque is Empty.");
        }
        return (E) data[front];
    }

    @SuppressWarnings("unchecked")
    public E getLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Deque is Empty.");
        }
        // 因为 tail 指向的是队尾元素的下一个位置，我们需要计算一下真正队尾元素的索引
        int last = tail == 0 ? data.length - 1 : tail - 1;
        return (E) data[last];
    }

    private void grow(int newCapacity) {
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front {");
        for(int i = 0 ; i < size ; i ++){
            res.append(data[(i + front) % data.length]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append("} tail");
        return res.toString();
    }
}
