package com.moon.classicalalgorithm.set;

import com.moon.classicalalgorithm.avltree.AVLTree;

/**
 * @author Chanmoey
 * @date 2022年12月20日
 */
public class AVLSet<E extends Comparable<E>> implements Set<E>{

    private final AVLTree<E, Object> tree;

    public AVLSet() {
        this.tree = new AVLTree<>();
    }

    @Override
    public void add(E e) {
        tree.add(e, null);
    }

    @Override
    public void remove(E e) {
        tree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return tree.contains(e);
    }

    @Override
    public int getSize() {
        return tree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }
}
