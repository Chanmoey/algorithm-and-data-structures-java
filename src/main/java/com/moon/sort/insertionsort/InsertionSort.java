package com.moon.sort.insertionsort;

import com.moon.util.ArrayUtil;

/**
 * @author Chanmoey
 */
public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
                ArrayUtil.swap(arr, j, j-1);
            }
        }
    }

    public static <E extends Comparable<E>> void sortBetter(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E save = arr[i];
            int j = i;
            for (; j > 0 && save.compareTo(arr[j-1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = save;
        }

    }
}
