package com.moon.classicalalgorithm.stack;

import com.moon.classicalalgorithm.queue.LoopQueueJustSize;

/**
 * @author Chanmoey
 */
public class StackBaseQueue<E> implements Stack<E> {

    private LoopQueueJustSize<E> inQueue;
    private LoopQueueJustSize<E> tempQueue;

    public StackBaseQueue() {
        this.inQueue = new LoopQueueJustSize<>();
        this.tempQueue = new LoopQueueJustSize<>();
    }

    @Override
    public int getSize() {
        return inQueue.getSize();
    }

    @Override
    public boolean isEmpty() {
        return inQueue.isEmpty();
    }

    @Override
    public void push(E e) {
        inQueue.enqueue(e);
    }

    @Override
    public E pop() {
        inQueue2TempQueue();
        E ret = inQueue.dequeue();

        // 交换两个队列，这样就不需要把tempQueue离的数据再一个一个放回inQueue里面了
        LoopQueueJustSize<E> tempPoint = this.inQueue;
        this.inQueue = this.tempQueue;
        this.tempQueue = tempPoint;

        return ret;
    }

    @Override
    public E peek() {
        inQueue2TempQueue();
        return inQueue.getFront();
    }

    /**
     * 把inQueue中的数据存入tempQueue中，inQueue只需要保留一个即可
     */
    private void inQueue2TempQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Stack is Empty");
        }
        while (inQueue.getSize() > 1) {
            tempQueue.enqueue(inQueue.dequeue());
        }
    }
}
