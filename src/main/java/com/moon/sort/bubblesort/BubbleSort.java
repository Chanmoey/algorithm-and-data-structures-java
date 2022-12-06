package com.moon.sort.bubblesort;

import com.moon.util.ArrayUtil;

/**
 * @author Chanmoey
 * @date 2022年12月07日
 */
public class BubbleSort {

    private BubbleSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 循环不变量，循环开始arr[n-i, n)已经排好序
            // 循环结束arr[n-i-1, n)已经排好序
            // j < arr.length - i - 1 => j要往前看一个元素
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    ArrayUtil.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static <E extends Comparable<E>> void sort1(E[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    ArrayUtil.swap(arr, j, j + 1);
                    isSwapped = true;
                }
            }

            // 没交换过元素，已经有序
            if (!isSwapped) {

                return;
            }
        }
    }

    /**
     * 优化2，记录最后发送交换的位置，那么该位置以后的元素就是有序的了
     */
    public static <E extends Comparable<E>> void sort2(E[] arr) {
        for (int i = 0; i < arr.length - 1; ) {
            int lastSwappedIndex = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    ArrayUtil.swap(arr, j, j + 1);
                    lastSwappedIndex = j + 1;
                }
            }

            // i表示有多少个元素已经排好序了
            i = arr.length - lastSwappedIndex;
        }
    }

    /**
     * 第三版冒泡排序，从后向前看
     */
    public static <E extends Comparable<E>> void sort3(E[] arr) {
        // 循环不变量，i表示已经排好序的元素数量 => arr[0, i)已经有序
        for (int i = 0; i < arr.length; ) {
            int lastSwappedIndex = arr.length;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    ArrayUtil.swap(arr, j - 1, j);
                    lastSwappedIndex = j;
                }
            }

            // i表示有多少个元素已经排好序了
            i = lastSwappedIndex;
        }
    }
}
