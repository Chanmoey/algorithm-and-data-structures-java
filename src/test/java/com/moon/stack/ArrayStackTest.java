package com.moon.stack;

import org.junit.Test;

/**
 * @author Chanmoey
 */
public class ArrayStackTest {

    @Test
    public void ArrayStackBaseTest() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        System.out.println(stack);
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
