package com.moon.cachereplacement;

/**
 * 单向链表实现LRU Cache
 *
 * @author Chanmoey
 * @date 2023年04月14日
 */
public class LRUJustLinkedList<K extends Comparable<K>, V> {

    private static class Node<K extends Comparable<K>, V> {

        private K key;
        private V value;

        Node<K, V> next;

        public Node(K k, V v) {
            this.key = k;
            this.value = v;
        }

        public Node(K k, V v, Node<K, V> next) {
            this.key = k;
            this.value = v;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private Node<K, V> dummyHeader = new Node<>(null, null);

    private final int cacheSize;

    private int size;

    public LRUJustLinkedList(int cacheSize) {
        this.cacheSize = cacheSize;
        this.size = 0;
    }

    public void put(K key, V value) {
        Node<K, V> cur = dummyHeader.next;
        Node<K, V> prev = dummyHeader;
        while (cur != null) {
            // 已在缓存，直接更新，并移到队头
            if (cur.getKey().equals(key)) {
                cur.setValue(value);
                prev.next = cur.next;
                cur.next = dummyHeader.next;
                dummyHeader = cur;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
        // 插入新缓存，先判断容量
        if (size >= cacheSize) {
            // 删缓存
            removeTail();
        } else {
            size++;
        }
        dummyHeader.next = new Node<>(key, value, dummyHeader.next);
    }

    public V find(K key) {
        Node<K, V> cur = dummyHeader.next;
        while (cur != null) {
            if (cur.getKey().equals(key)) {
                return cur.getValue();
            }
            cur = cur.next;
        }

        return null;
    }

    private void removeTail() {
        Node<K, V> cur = dummyHeader.next;
        Node<K, V> prev = dummyHeader;
        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }
        // 删除队尾
        prev.next = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<K, V> cur = dummyHeader.next;
        sb.append("[");
        while (cur != null) {
            sb.append("(").append("key: ").append(cur.getKey()).append(", ").append("value: ").append(cur.getValue()).append(")").append("->");
            cur = cur.next;
        }

        sb.append("]");
        return sb.toString();
    }
}
