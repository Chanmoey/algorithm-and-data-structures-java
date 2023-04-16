package com.moon.classicalalgorithm.queue;

import com.moon.classicalalgorithm.array.Array;

/**
 * @author Chanmoey
 */
public class ArrayQueue<E> implements Queue<E> {

    private final Array<E> array;

    public ArrayQueue(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayQueue() {
        this(0);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ");
        sb.append("front {");
        for (int i = 0; i < array.getSize() - 1; i++) {
            sb.append(array.get(i));
            sb.append(", ");
        }
        if (array.getSize() > 0) {
            sb.append(array.get(array.getSize() - 1));
        }
        sb.append("} tail");
        return sb.toString();
    }
}
