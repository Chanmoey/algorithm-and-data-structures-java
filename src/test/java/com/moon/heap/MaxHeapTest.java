package com.moon.heap;

import com.moon.util.ArrayGenerator;
import com.moon.util.TimeUtil;
import org.junit.Test;

import java.util.Random;

/**
 * @author Chanmoey
 * @date 2022年12月01日
 */
public class MaxHeapTest {

    @Test
    public void maxHeapTest() {
        int n = 1000000;

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.remove();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("No Order");
            }
        }

        System.out.println("Yes, it is sorted arr");
    }

    private static double makeHeapTest(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> heap;
        if (isHeapify) {
            heap = new MaxHeap<>(testData);
        } else {
            heap = new MaxHeap<>();
            for (Integer i : testData) {
                heap.add(i);
            }
        }
        long endTime = System.nanoTime();

        int n = testData.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = heap.remove();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException("No Order!!!");
            }
        }

        System.out.println("Yes, it is sorted arr!");

        return TimeUtil.nanoSecond2Second(startTime, endTime);
    }

    @Test
    public void testHeapify() {
        int n = 1000000;
        Integer[] testData = ArrayGenerator.generateRandomArray(n, Integer.MAX_VALUE);

        double time1 = makeHeapTest(testData, false);
        System.out.println("Without Heapify: " + time1 + "s");

        double time2 = makeHeapTest(testData, true);
        System.out.println("With Heapify: " + time2 + "s");
    }
}
