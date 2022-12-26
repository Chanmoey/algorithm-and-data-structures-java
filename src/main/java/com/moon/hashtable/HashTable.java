package com.moon.hashtable;

import java.util.TreeMap;

/**
 * 哈希表得到了性能，但是丢失了数据的顺序性。
 *
 * @author Chanmoey
 * @date 2022年12月26日
 */
public class HashTable<K, V> {

    // 动态容量参数
    public static final int UPPER_TOL = 10;
    public static final int LOWER_TOL = 2;

    // 哈希容量
    private final int[] capacity = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593, 49157, 98317, 196613, 393241,
            786433, 1572869, 3145739, 6291469, 12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457,
    };
    private int capacityIndex = 0;

    private TreeMap<K, V>[] table;

    private int m;

    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int m) {
        this.m = capacity[capacityIndex];
        this.size = 0;
        table = new TreeMap[m];

        for (int i = 0; i < m; i++) {
            table[i] = new TreeMap<>();
        }
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = table[hash(key)];
        if (map.containsKey(key)) {
            // 已包含，更改值
            map.put(key, value);
        } else {
            // 未包含，push并维护size
            map.put(key, value);
            size++;
        }

        if (size >= UPPER_TOL * m && capacityIndex + 1 < capacity.length) {
            capacityIndex++;
            resize(capacity[capacityIndex]);
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = table[hash(key)];
        V rel = null;
        if (map.containsKey(key)) {
            rel = map.remove(key);
            size--;
        }

        if (size < LOWER_TOL * m && capacityIndex - 1 >= 0) {
            capacityIndex--;
            resize(capacity[capacityIndex]);
        }

        return rel;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = table[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("No key in hash table!");
        }
        map.put(key, value);
    }

    public boolean contains(K key) {
        return table[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return table[hash(key)].get(key);
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
            TreeMap<K, V> map = table[i];
            map.forEach((key, value) -> newHashTable[hash(key)].put(key, value));
        }

        this.table = newHashTable;
    }
}
