package com.moon.queue;

import org.junit.Test;

/**
 * @author Chanmoey
 */
public class ArrayQueueTest {

    @Test
    public void ArrayQueueBaseTest() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
