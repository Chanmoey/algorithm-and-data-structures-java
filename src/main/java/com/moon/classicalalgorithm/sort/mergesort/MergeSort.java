package com.moon.classicalalgorithm.sort.mergesort;

import com.moon.classicalalgorithm.sort.insertionsort.InsertionSort;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年11月18日
 */
public class MergeSort {

    private static final int MIN_SPLIT = 15;

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

    public static <E extends Comparable<E>> void sort1(E[] arr) {
        sort1(arr, 0, arr.length - 1);
    }


    /**
     * [l, r]
     */
    private static <E extends Comparable<E>> void sort1(E[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        sort1(arr, l, mid);
        sort1(arr, mid + 1, r);

        // 优化1
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }

    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        sort2(arr, 0, arr.length - 1);
    }


    /**
     * [l, r]
     */
    private static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {
        if (r - l <= MIN_SPLIT) {
            // 优化2，对于小规模的数据，可以使用插入排序。
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = l + (r - l) / 2;
        sort2(arr, l, mid);
        sort2(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
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

    public static <E extends Comparable<E>> void sort3(E[] arr) {
        // 优化3避免重复开空间
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort3(arr, 0, arr.length - 1, temp);
    }


    /**
     * [l, r]
     */
    private static <E extends Comparable<E>> void sort3(E[] arr, int l, int r, E[] temp) {
        if (r - l <= MIN_SPLIT) {
            // 优化2，对于小规模的数据，可以使用插入排序。
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = l + (r - l) / 2;
        sort3(arr, l, mid, temp);
        sort3(arr, mid + 1, r, temp);
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge3(arr, l, mid, r, temp);
        }
    }


    /**
     * [l, mid] and [mid+1, r]
     */
    private static <E extends Comparable<E>> void merge3(E[] arr, int l, int mid, int r, E[] temp) {

        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l;
        int j = mid + 1;
        int idx = l;
        while (i <= mid && j <= r) {
            if (temp[i].compareTo(temp[j]) < 0) {
                arr[idx++] = temp[i++];
            } else {
                arr[idx++] = temp[j++];
            }
        }

        while (i <= mid) {
            arr[idx++] = temp[i++];
        }

        while (j <= r) {
            arr[idx++] = temp[j++];
        }
    }

    public static <E extends Comparable<E>> void sortBetter(E[] arr) {
        sort3(arr);
    }

    /**
     * 查看递归的过程
     */
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

    /**
     * 自底向上的归并排序
     */
    public static <E extends Comparable<E>> void sortBU(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        int n = arr.length;

        for (int i = 0; i < n; i += 16) {
            InsertionSort.sort(arr, i, Math.min(n - 1, i + 15));
        }

        // 遍历合并区间的长度
        for (int sz = 16; sz < n; sz += sz) {

            // 遍历合并的两个区间的其实位置i
            // 合并[i, i + sz -1]和[i + sz, i + sz + sz -1]
            for (int i = 0; i + sz < n; i += sz + sz) {

                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0) {
                    merge3(arr, i, i + sz - 1, Math.min(n - 1, i + sz + sz - 1), temp);
                }

            }
        }
    }
}
