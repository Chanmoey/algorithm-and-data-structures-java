package com.moon.classicalalgorithm.util;

import java.util.Random;

/**
 * @author Chanmoey
 */
public class ArrayGenerator {

    private final static Random RANDOM = new Random();

    private ArrayGenerator() {
        throw new RuntimeException("Don't Reflection");
    }

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        return arr;
    }

    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = RANDOM.nextInt(bound);
        }

        return arr;
    }
}
