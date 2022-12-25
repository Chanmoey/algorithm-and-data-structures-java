package com.moon.hashtable;

import java.util.TreeMap;

/**
 * @author Chanmoey
 * @date 2022年12月26日
 */
public class HashTable<K, V> {

    // 动态容量参数
    public static final int upperTol = 10;
    public static final int lowerTol = 2;
    public static final int initCapacity = 7;


    private TreeMap<K, V>[] hashTable;

    private int m;

    private int size;

    public HashTable(int m) {
        this.m = m;
        this.size = 0;
        hashTable = new TreeMap[m];

        for (int i = 0; i < m; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(initCapacity);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            // 已包含，更改值
            map.put(key, value);
        } else {
            // 未包含，push并维护size
            map.put(key, value);
            size++;
        }

        if (size >= upperTol * m) {
            resize(m << 1);
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V rel = null;
        if (map.containsKey(key)) {
            rel = map.remove(key);
            size--;
        }

        if (size < lowerTol * m && (m >> 1) >= initCapacity) {
            resize(m >> 1);
        }

        return rel;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("No key in hash table!");
        }
        map.put(key, value);
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

    @SuppressWarnings("unchecked")
    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        int oldM = this.m;
        this.m = newM;

        for (int i = 0; i < oldM; i++) {
            TreeMap<K, V> map = hashTable[i];
            map.forEach((key, value) -> newHashTable[hash(key)].put(key, value));
        }

        this.hashTable = newHashTable;
    }
}
