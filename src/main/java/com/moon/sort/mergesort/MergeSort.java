package com.moon.sort.mergesort;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年11月18日
 */
public class MergeSort {

    private MergeSort() {
        throw new RuntimeException();
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

        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }


    /**
     * [l, mid] and [mid, r]
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        E[] copy = Arrays.copyOfRange(arr, l, r + 1);

        int i = l;
        int j = mid + 1;
        int idx = l;
        while (i <= mid && j <= r) {
            if (copy[i - l].compareTo(copy[j - l]) < 0) {
                arr[idx] = copy[i - l];
                i++;
            } else {
                arr[idx] = copy[j - l];
                j++;
            }
            idx++;
        }

        while (i <= mid) {
            arr[idx] = copy[i - l];
            i++;
            idx++;
        }

        while (j <= r) {
            arr[idx] = copy[j - l];
            j++;
            idx++;
        }
//        int i = l;
//        int j = mid + 1;
//        for (int k = l; k <= r; k++) {
//            if (i > mid) {
//                arr[k] = copy[j - l];
//                j++;
//            } else if (j > r) {
//                arr[k] = copy[i - l];
//                i++;
//            } else {
//                if (copy[i - l].compareTo(copy[j - l]) < 0) {
//                    arr[k] = copy[i - l];
//                    i++;
//                } else {
//                    arr[k] = copy[j - l];
//                    j++;
//                }
//            }
//        }
    }

    public static <E extends Comparable<E>> void sortSout(E[] arr, int l, int r, int depth) {
        if (l >= r) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("--".repeat(Math.max(0, depth)));
        System.out.println(String.format(sb + "排序%d到%d", l, r) + Arrays.toString(arr));

        int mid = l + (r - l) / 2;
        sortSout(arr, l, mid, depth + 1);
        System.out.println(String.format(sb + "排序%d到%d", l, mid) + Arrays.toString(arr));
        sortSout(arr, mid + 1, r, depth + 1);
        System.out.println(String.format(sb + "排序%d到%d", mid + 1, r) + Arrays.toString(arr));
        merge(arr, l, mid, r);
        System.out.println(String.format(sb + "排序%d到%d", l, r) + Arrays.toString(arr));
    }
}
