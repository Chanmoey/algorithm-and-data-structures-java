package com.moon.classicalalgorithm.sort.quicksort;

import com.moon.classicalalgorithm.sort.insertionsort.InsertionSort;
import com.moon.classicalalgorithm.util.ArrayUtil;
import com.moon.classicalalgorithm.util.RandomUtil;

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
        sort1(arr, l, p - 1);
        sort1(arr, p + 1, r);
    }

    public static <E extends Comparable<E>> void sort2ways(E[] arr) {
        sort2ways(arr, 0, arr.length - 1);
    }

    /**
     * [l, r]
     */
    private static <E extends Comparable<E>> void sort2ways(E[] arr, int l, int r) {
        if (r - l <= 15) {
            // 改进1：少量数据用插入排序
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition2ways(arr, l, r);
        sort2ways(arr, l, p - 1);
        sort2ways(arr, p + 1, r);
    }

    private static <E extends Comparable<E>> int partition2ways(E[] arr, int l, int r) {

        int rIdx = RandomUtil.getRandomInt(l, r);
        ArrayUtil.swap(arr, l, rIdx);

        // 循环不变量 arr[l+1...i-1] <= v  arr[j+1...r] >= v
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0) {
                i++;
            }

            while (j >= i && arr[j].compareTo(arr[l]) > 0) {
                j--;
            }

            if (i >= j) {
                break;
            }

            ArrayUtil.swap(arr, i, j);
            i++;
            j--;
        }

        ArrayUtil.swap(arr, l, j);
        return j;
    }

    public static <E extends Comparable<E>> void sort3ways(E[] arr) {
        sort3ways(arr, 0, arr.length - 1);
    }

    /**
     * [l, r]
     */
    private static <E extends Comparable<E>> void sort3ways(E[] arr, int l, int r) {
        if (r - l <= 15) {
            // 改进1：少量数据用插入排序
            InsertionSort.sort(arr, l, r);
            return;
        }

        int[] p = partition3ways(arr, l, r);
        sort3ways(arr, l, p[0]);
        sort3ways(arr, p[1], r);
    }

    private static <E extends Comparable<E>> int[] partition3ways(E[] arr, int l, int r) {

        int rIdx = RandomUtil.getRandomInt(l, r);
        ArrayUtil.swap(arr, l, rIdx);

        // 循环不变量 arr[l+1...it] < v  arr[gt...r] > v  arr[lt+1...i-1] == v
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while (i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                ArrayUtil.swap(arr, lt, i);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                ArrayUtil.swap(arr, gt, i);
            } else {
                i++;
            }

        }

        ArrayUtil.swap(arr, l, lt);

        // 频繁开空间，更加耗时
        return new int[]{lt - 1, gt};
    }

    public static <E extends Comparable<E>> void sortBetter(E[] arr) {
        sort2ways(arr);
    }
}
