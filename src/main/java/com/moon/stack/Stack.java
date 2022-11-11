package com.moon.stack;

/**
 * @author Chanmoey
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
