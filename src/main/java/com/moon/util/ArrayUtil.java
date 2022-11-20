package com.moon.util;

import java.util.Random;

/**
 * @author Chanmoey
 */
public class ArrayUtil {

    public static final Random RANDOM = new Random();

    private ArrayUtil(){}

    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
