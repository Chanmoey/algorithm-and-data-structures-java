package com.moon.heap;

import org.junit.Test;

import java.util.Random;

/**
 * @author Chanmoey
 * @date 2022年12月01日
 */
public class MaxHeapTest {

    @Test
    public void maxHeapTest() {
        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.remove();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i-1] < arr[i]) {
                throw new IllegalArgumentException("No Order");
            }
        }

        System.out.println("Yes, it is sorted arr");
    }
}
