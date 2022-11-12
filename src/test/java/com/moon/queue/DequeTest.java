package com.moon.queue;

import org.junit.Test;

/**
 * @author Chanmoey
 */
public class DequeTest {

    @Test
    public void dequeTest() {
        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                deque.addLast(i);
            } else {
                deque.addFirst(i);
            }
            System.out.println(deque);
        }

        System.out.println();

        for (int i = 0; !deque.isEmpty(); i++) {
            if (i % 2 == 0) {
                deque.removeFirst();
            } else {
                deque.removeLast();
            }
            System.out.println(deque);
        }
    }
}
