package com.moon.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chanmoey
 */
public class QueueBaseStackTest {

    @Test
    public void test(){
        QueueBaseStack<Integer> queue = new QueueBaseStack<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals((int) queue.dequeue(), i);
        }
    }
}
