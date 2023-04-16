package com.moon.classicalalgorithm.queue;

import com.moon.classicalalgorithm.heap.MaxHeap;

/**
 * 优先队列
 *
 * @author Chanmoey
 * @date 2022年12月06日
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private final MaxHeap<E> maxHeap;

    public PriorityQueue(int capacity) {
        this.maxHeap = new MaxHeap<>(capacity);
    }

    public PriorityQueue() {
        this.maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.remove();
    }

    @Override
    public E getFront() {
        return maxHeap.peek();
    }
}
