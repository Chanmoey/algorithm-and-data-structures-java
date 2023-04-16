package com.moon.classicalalgorithm.cachereplacement;

import org.junit.Test;

/**
 * @author Chanmoey
 * @date 2023年04月14日
 */
public class LRUJustLinkedListTest {

    @Test
    public void test() {
        LRUJustLinkedList<Integer, Integer> lruCache = new LRUJustLinkedList<>(4);

        lruCache.put(1, 1);
        System.out.println(lruCache);
        lruCache.put(2, 2);
        System.out.println(lruCache.find(3));
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(lruCache);
        lruCache.put(5, 5);
        System.out.println(lruCache);
    }
}
