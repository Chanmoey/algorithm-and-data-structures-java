package com.moon.set;

import com.moon.bst.BST;

/**
 * @author Chanmoey
 * @date 2022年11月29日
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private final BST<E> bst;

    public BSTSet() {
        this.bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
