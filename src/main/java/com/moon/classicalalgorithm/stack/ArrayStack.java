package com.moon.classicalalgorithm.stack;

import com.moon.classicalalgorithm.array.Array;

/**
 * @author Chanmoey
 */
public class ArrayStack<E> implements Stack<E> {

    private final Array<E> array;

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    public ArrayStack() {
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
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: {");
        for (int i = 0; i < array.getSize() - 1; i++) {
            sb.append(i).append(", ");
        }
        if (array.getSize() != 0) {
            sb.append(array.getLast());
        }
        sb.append("}").append(" top");
        return sb.toString();
    }

    public int getCapacity() {
        return array.getCapacity();
    }
}
