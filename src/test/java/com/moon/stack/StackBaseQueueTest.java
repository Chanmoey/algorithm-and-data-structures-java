package com.moon.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chanmoey
 */
public class StackBaseQueueTest {

    StackBaseQueue<Integer> stack = new StackBaseQueue<>();

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            System.out.println(stack.peek());
        }

        for (int i = 9; i >= 0; i--) {
            Assert.assertEquals((int) stack.pop(), i);
        }
    }
}
