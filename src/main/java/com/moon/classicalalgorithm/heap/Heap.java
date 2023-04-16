package com.moon.classicalalgorithm.heap;

import com.moon.classicalalgorithm.array.Array;

/**
 * @author Chanmoey
 * @date 2022年12月06日
 */
public abstract class Heap <E extends Comparable<E>> {

    protected Array<E> data;

    public Heap(int capacity) {
        data = new Array<>(capacity);
    }

    public Heap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回index所在节点的父节点的索引
     */
    protected int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) >>> 1;
    }

    /**
     * 返回index节点的左孩子的索引
     */
    protected int leftChild(int index) {
        return (index << 1) + 1;
    }

    /**
     * 返回index节点的右孩子的索引
     */
    protected int rightChild(int index) {
        return (index << 1) + 2;
    }

    /**
     * 查看堆顶
     */
    public E peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("MaxHeap is empty!");
        }

        return data.get(0);
    }
}
