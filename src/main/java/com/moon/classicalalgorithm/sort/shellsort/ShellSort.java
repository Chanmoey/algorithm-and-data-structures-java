package com.moon.classicalalgorithm.sort.shellsort;

/**
 * @author Chanmoey
 * @date 2022年12月07日
 */
public class ShellSort {

    private ShellSort() {

    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        int h = arr.length / 2;
        while (h >= 1) {
            // 遍历每一个子数组
            // start为每个子数组的开始位置
            for (int start = 0; start < h; start++) {
                // 对 arr[start, start+h, start+2h,...]进行插入排序
                for (int i = start + h; i < arr.length; i += h) {
                    E t = arr[i];
                    int j;
                    for (j = i; j - h >= 0 && t.compareTo(arr[j - h]) < 0; j -= h) {
                        arr[j] = arr[j - h];
                    }
                    arr[j] = t;
                }
            }

            h /= 2;
        }
    }

    /**
     * 优化循环的层次，性能不变，只是循环层数少了
     */
    public static <E extends Comparable<E>> void sort1(E[] arr) {
        int h = arr.length / 2;
        while (h >= 1) {
            for (int i = h; i < arr.length; i += 1) {
                E t = arr[i];
                int j;
                for (j = i; j - h >= 0 && t.compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = t;
            }

            h /= 2;
        }
    }

    /**
     * 步长序列: 1, 4, 13
     */
    public static <E extends Comparable<E>> void sort2(E[] arr) {

        int h = 1;
        while (h < arr.length) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < arr.length; i += 1) {
                E t = arr[i];
                int j;
                for (j = i; j - h >= 0 && t.compareTo(arr[j - h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = t;
            }

            h /= 3;
        }
    }
}
