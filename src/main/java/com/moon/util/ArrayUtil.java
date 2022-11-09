package com.moon.util;

/**
 * @author Chanmoey
 */
public class ArrayUtil {

    private ArrayUtil(){}

    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
