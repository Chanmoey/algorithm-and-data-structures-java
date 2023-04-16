package com.moon.classicalalgorithm.array;

import org.junit.Test;

/**
 * @author Chanmoey
 */
public class ArrayTest {

    @Test
    public void arrayBaseTest() {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            System.out.println(array);
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);

        array.addFirst(-1);
        System.out.println(array);

        array.remove(2);
        System.out.println(array);

        array.removeElement(4);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);

        int size = array.getSize();
        for (int i = 0; i < size; i++) {
            array.removeLast();
            System.out.println(array);
        }
    }
}
