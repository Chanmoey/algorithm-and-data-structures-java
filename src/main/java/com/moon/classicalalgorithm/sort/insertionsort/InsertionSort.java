package com.moon.classicalalgorithm.sort.insertionsort;

import com.moon.classicalalgorithm.util.ArrayUtil;

/**
 * 插入排序的特殊性质：内层循环可以提前终止。
 *
 * @author Chanmoey
 */
public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                ArrayUtil.swap(arr, j, j - 1);
            }
        }
    }

    public static <E extends Comparable<E>> void sortBetter(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E save = arr[i];
            int j = i;
            for (; j > 0 && save.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = save;
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {

        // 循环不变量：每轮循环后arr[0, i)未排序，arr[i, n）已排序
        for (int i = arr.length - 1; i >= 0; i--) {
            E save = arr[i];
            int j = i;
            for (; j < arr.length - 1 && save.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = save;
        }
    }

    /**
     * 对[l, r]进行排序
     */
    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        for (int i = l; i <= r; i++) {
            E save = arr[i];
            int j = i;
            for (; j > l && save.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = save;
        }
    }
}
