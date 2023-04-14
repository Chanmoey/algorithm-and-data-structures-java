package com.moon.linkedlist;

import org.junit.Test;

/**
 * @author Chanmoey
 * @date 2023年04月15日
 */
public class DoubleLinkedListTest {

    @Test
    public void test() {
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

    }
}
