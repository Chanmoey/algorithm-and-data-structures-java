package com.moon.stack;

import com.moon.linkedlist.LinkedList;
import org.junit.Test;

/**
 * @author Chanmoey
 * @date 2022年11月15日
 */
public class StackBaseLinkedListTest {

    @Test
    public void test() {
        StackBaseLinkedList<Integer> stack = new StackBaseLinkedList<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
