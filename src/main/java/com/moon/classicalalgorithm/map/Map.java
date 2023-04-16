package com.moon.classicalalgorithm.map;

/**
 * @author Chanmoey
 * @date 2022年11月30日
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();
}
