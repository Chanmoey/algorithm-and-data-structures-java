package com.moon.classicalalgorithm.queue;

import com.moon.classicalalgorithm.linkedlist.LinkedListWithTail;

/**
 * @author Chanmoey
 * @date 2022年11月16日
 */
public class QueueBaseLinkedList<E> implements Queue<E>{

    private final LinkedListWithTail<E> list;

    public QueueBaseLinkedList() {
        this.list = new LinkedListWithTail<>();
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
    public void enqueue(E e) {
        list.addLast(e);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public E getFront() {
        return list.getFist();
    }

    @Override
    public String toString() {
        return "Queue: front " + list + " tail";
    }
}
