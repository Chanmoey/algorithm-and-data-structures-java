package com.moon.sort.quicksort;

import com.moon.sort.insertionsort.InsertionSort;
import com.moon.util.ArrayUtil;
import com.moon.util.RandomUtil;

/**
 * @author Chanmoey
 * @date 2022年11月21日
 */
public class QuickSort {

    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * [l, r]
     */
    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {

        int rIdx = RandomUtil.getRandomInt(l, r);
        ArrayUtil.swap(arr, l, rIdx);

        // 循环不变量 arr[l+1...j] < v  arr[j+1...i-1] >= v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                ArrayUtil.swap(arr, i, j);
            }
        }
        ArrayUtil.swap(arr, l, j);
        return j;
    }

    public static <E extends Comparable<E>> void sort1(E[] arr) {
        sort1(arr, 0, arr.length - 1);
    }

    /**
     * [l, r]
     */
    private static <E extends Comparable<E>> void sort1(E[] arr, int l, int r) {
        if (r - l <= 15) {
            // 改进1：少量数据用插入排序
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }
}
