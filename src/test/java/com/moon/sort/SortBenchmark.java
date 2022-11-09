package com.moon.sort;

import com.moon.util.ArrayGenerator;
import com.moon.util.SortingHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Chanmoey
 */
public class SortBenchmark {

    @Test
    public void twoSortWithOrderArrayBenchmark() {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateOrderedArray(n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("com.moon.sort.selectionsort.SelectionSort",
                    "sort", Comparable[].class, arr);
            SortingHelper.sortTest("com.moon.sort.insertionsort.InsertionSort",
                    "sortBetter", Comparable[].class, arr2);
        }
    }

    @Test
    public void twoSortWithRandomArrayBenchmark() {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("com.moon.sort.selectionsort.SelectionSort",
                    "sort", Comparable[].class, arr);
            SortingHelper.sortTest("com.moon.sort.insertionsort.InsertionSort",
                    "sortBetter", Comparable[].class, arr2);
        }
    }
}
