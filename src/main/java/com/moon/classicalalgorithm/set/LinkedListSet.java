package com.moon.classicalalgorithm.set;

import com.moon.classicalalgorithm.linkedlist.LinkedList;

/**
 * @author Chanmoey
 * @date 2022年11月29日
 */
public class LinkedListSet<E> implements Set<E> {

    private final LinkedList<E> list;

    public LinkedListSet() {
        this.list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
