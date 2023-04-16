package com.moon.classicalalgorithm.queue;


import com.moon.classicalalgorithm.stack.ArrayStack;

/**
 * @author Chanmoey
 */
public class QueueBaseStack<E> implements Queue<E> {

    private final ArrayStack<E> inStack;
    private final ArrayStack<E> outStack;

    public QueueBaseStack() {
        this.inStack = new ArrayStack<>();
        this.outStack = new ArrayStack<>();
    }

    @Override
    public int getSize() {
        return this.inStack.getSize() + this.outStack.getSize();
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public void enqueue(E e) {
        inStack.push(e);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is Empty");
        }
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    @Override
    public E getFront() {
        in2out();
        return outStack.peek();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
