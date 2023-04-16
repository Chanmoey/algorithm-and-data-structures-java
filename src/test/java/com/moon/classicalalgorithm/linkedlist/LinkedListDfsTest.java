package com.moon.classicalalgorithm.linkedlist;

import org.junit.Test;

/**
 * @author Chanmoey
 * @date 2022年11月15日
 */
public class LinkedListDfsTest {

    @Test
    public void test() {
        LinkedListDfs<Integer> linkedList = new LinkedListDfs<>();
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

        linkedList.addFirst(2);
        System.out.println(linkedList);

        linkedList.removeElement(2);
        System.out.println(linkedList);

    }
}
