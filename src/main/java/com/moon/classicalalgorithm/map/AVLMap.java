package com.moon.classicalalgorithm.map;

import com.moon.classicalalgorithm.avltree.AVLTree;

/**
 * @author Chanmoey
 * @date 2022年12月20日
 */
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V>{

    private final AVLTree<K, V> tree;

    public AVLMap() {
        this.tree = new AVLTree<>();
    }

    @Override
    public void add(K key, V value) {
        tree.add(key, value);
    }

    @Override
    public V remove(K key) {
        return tree.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return tree.contains(key);
    }

    @Override
    public V get(K key) {
        return tree.get(key);
    }

    @Override
    public void set(K key, V newValue) {
        tree.set(key, newValue);
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
