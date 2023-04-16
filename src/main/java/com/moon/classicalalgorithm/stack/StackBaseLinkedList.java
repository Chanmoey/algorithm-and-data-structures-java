package com.moon.classicalalgorithm.stack;

import com.moon.classicalalgorithm.linkedlist.LinkedList;

/**
 * @author Chanmoey
 * @date 2022年11月15日
 */
public class StackBaseLinkedList<E> implements Stack<E>{

    private final LinkedList<E> list;

    public StackBaseLinkedList() {
        this.list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        return "Stack: top " + list;
    }
}
