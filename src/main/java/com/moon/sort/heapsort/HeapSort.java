package com.moon.sort.heapsort;

import com.moon.heap.MaxHeap;

/**
 * @author Chanmoey
 * @date 2022年12月02日
 */
public class HeapSort {

    private HeapSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e : arr) {
            maxHeap.add(e);
        }

        for (int i = arr.length-1; i >= 0; i--) {
            arr[i] = maxHeap.remove();
        }
    }
}
