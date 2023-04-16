package com.moon.classicalalgorithm.heap;

import com.moon.classicalalgorithm.array.Array;

/**
 * 1. 二叉堆是一棵完全二叉树
 * 2. 堆中的任意节点，总是不大于其父节点的值（最大堆）（并不是高层的值一定大于底层的值，只保证父节点大于等于子节点的值）
 * 3. 使用数组表示一颗完全二叉树（父节点的index是0）
 *
 * @author Chanmoey
 * @date 2022年12月01日
 */
public class MaxHeap<E extends Comparable<E>> extends Heap<E>{

    public MaxHeap(int capacity) {
        super(capacity);
    }

    public MaxHeap() {
        super();
    }

    public MaxHeap(E[] arr) {
        heapify(arr);
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 对索引为k的元素进行siftUp操作
     * 1. 依次比较其父节点，如果比父节点大(或等)，则交换，递归下去。
     */
    private void siftUp(int k) {

        // 写法1，不断交换，交换过程宏观上有3个操作，比较耗时
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) >= 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }

        // 写法2，字节赋值，比交换性能稍好一点
//        int p = parent(k);
//        E temp = data.get(k);
//        while (k > 0 && data.get(k).compareTo(data.get(p)) >= 0) {
//            data.set(k, data.get(p));
//            k = p;
//            // 重新计算父节点索引
//            if (k == 0) {
//                break;
//            }
//            p = parent(k);
//        }
//        // 最后记得把temp的值写上
//        data.set(k, temp);
    }

    /**
     * 取出最大元素
     * 1. 将数组最后元素和第一个元素交换，删除最后一个元素
     * 2. 执行siftDown
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
     * 1. 比较左右孩子，将自己和左右孩子中最大的值进行交换
     */
    private void siftDown(int k) {

        // 判断是不是叶子节点，叶子节点的左孩子肯定越界的
        while (leftChild(k) < data.getSize()) {
            // j从左孩子开始看
            int j = leftChild(k);
            // 有右孩子，且右孩子比左孩子大，那么交换对象就只可能是右孩子
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                // j现在是右孩子
                j++;
            }

            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(k, j);
            // 继续下沉
            k = j;
        }

    }

    /**
     * 取出最大元素，并添加一个新元素 == 新元素覆盖最大元素并执行siftDown
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
