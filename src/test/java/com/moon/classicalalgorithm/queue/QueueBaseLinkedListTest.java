package com.moon.classicalalgorithm.queue;

import org.junit.Test;

/**
 * @author Chanmoey
 * @date 2022年11月16日
 */
public class QueueBaseLinkedListTest {

    @Test
    public void test() {
        QueueBaseLinkedList<Integer> queue = new QueueBaseLinkedList<>();

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
