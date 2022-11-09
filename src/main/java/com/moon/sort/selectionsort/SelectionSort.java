package com.moon.sort.selectionsort;

import com.moon.util.ArrayUtil;

/**
 * @author Chanmoey
 */
public class SelectionSort {

    private SelectionSort() {
        throw new RuntimeException();
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        // 循环不变量[0, i)是排好序的，[i, n)是未排好序的
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIdx]) < 0) {
                    minIdx = j;
                }
            }

            ArrayUtil.swap(arr, i, minIdx);
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {

        // 循环不变量: 循环开始arr[i, n)已排好序，arr[0, i)未排好序
        for (int i = arr.length; i > 0; i--) {
            int maxIdx = i - 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j].compareTo(arr[maxIdx]) > 0) {
                    maxIdx = j;
                }
            }

            ArrayUtil.swap(arr, i - 1, maxIdx);
        }
    }

    public static <E extends Comparable<E>> void sort3(E[] arr) {

        // 循环不变量: 循环结束后arr[i, n)已排好序，arr[0, i)未排好序
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIdx = i;
            for (int j = i; j >= 0; j--) {
                if (arr[j].compareTo(arr[maxIdx]) > 0) {
                    maxIdx = j;
                }
            }

            ArrayUtil.swap(arr, i, maxIdx);
        }
    }
}
