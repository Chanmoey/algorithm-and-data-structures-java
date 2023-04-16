package com.moon.classicalalgorithm.set;

/**
 * @author Chanmoey
 * @date 2022年11月29日
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
