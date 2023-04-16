package com.moon.classicalalgorithm.sort.heapsort;

import com.moon.classicalalgorithm.util.ArrayUtil;
import com.moon.classicalalgorithm.heap.MaxHeap;

/**
 * @author Chanmoey
 * @date 2022年12月02日
 */
public class HeapSort {

    private HeapSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        MaxHeap<E> maxHeap = new MaxHeap<>();
        for (E e : arr) {
            maxHeap.add(e);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.remove();
        }
    }

    /**
     * 1. 第一步使用heapify将数组构造成堆
     * 2. 最大值和最后一个元素调换
     * 3. 对第一个元素进行siftDown
     * 4. 重复2、3步骤
     */
    public static <E extends Comparable<E>> void sort1(E[] arr) {

        if (arr.length <= 1) {
            return;
        }

        for (int i = (arr.length - 2) >> 1; i >= 0; i--) {
            siftDown(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            ArrayUtil.swap(arr, 0, i);
            siftDown(arr, 0, i);
        }
    }

    /**
     * 对arr[0, length)所形成的最大堆中的索引k的元素进行siftDown
     */
    private static <E extends Comparable<E>> void siftDown(E[] arr, int k, int length) {

        // 判断是不是叶子节点，叶子节点的左孩子肯定越界的
        while ((k << 1) + 1 < length) {
            // j从左孩子开始看
            int j = (k << 1) + 1;
            // 有右孩子，且右孩子比左孩子大，那么交换对象就只可能是右孩子
            if (j + 1 < length && arr[j + 1].compareTo(arr[j]) > 0) {
                // j现在是右孩子
                j++;
            }

            if (arr[k].compareTo(arr[j]) >= 0) {
                break;
            }

            ArrayUtil.swap(arr, k, j);
            // 继续下沉
            k = j;
        }
    }
}