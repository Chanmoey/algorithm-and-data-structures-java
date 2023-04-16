package com.moon.classicalalgorithm.queue;

/**
 * @author Chanmoey
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
