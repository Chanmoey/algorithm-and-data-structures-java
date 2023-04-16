package com.moon.classicalalgorithm.heap;

import com.moon.classicalalgorithm.array.Array;

/**
 * @author Chanmoey
 * @date 2022年12月02日
 */
public class MinHeap<E extends Comparable<E>> extends Heap<E> {

    public MinHeap(int capacity) {
        super(capacity);
    }

    public MinHeap() {
        super();
    }

    public MinHeap(E[] arr) {
        heapify(arr);
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 对索引k的元素进行siftUp操作
     * 1. 依次比较父节点，如果元素k比父节点小，则与父节点进行交换，k <- 父节点位置
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) <= 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 取出最大元素
     * 1. 将数组最后元素放置到首位，然后删除最后一个元素。
     * 2. 对首位元素不断执行siftDown
     */
    public E remove() {
        E del = peek();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return del;
    }

    /**
     * siftDown过程
     * 1. 比较左右孩子，将自己和左右孩子中最小的值进行交换
     */
    private void siftDown(int k) {
        // 判断是否为叶子节点
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) < 0) {
                j++;
            }

            // 已经比左右孩子都小了，满足最小堆的定义
            if (data.get(k).compareTo(data.get(j)) <= 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出最小元素，并添加一个新元素 ==> 新元素覆盖最小元素，然后执行siftDown
     */
    public E replace(E e) {
        E ret = peek();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    /**
     * 把一个数组改造成堆，O(n)
     * 1. 找到最后一个非叶子节点(最后一个叶子节点的parent)
     * 2. 依次将所有非叶子节点进行siftDown
     */
    public void heapify(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }
}
