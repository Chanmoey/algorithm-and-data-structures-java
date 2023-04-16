package com.moon.classicalalgorithm.queue;

import org.junit.Test;

/**
 * @author Chanmoey
 */
public class LoopQueueTest {

    @Test
    public void LoopQueueBaseTest() {
        LoopQueue<Integer> queue = new LoopQueue<>(10);
        System.out.println(queue);

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
