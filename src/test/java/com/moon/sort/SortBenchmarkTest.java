package com.moon.sort;

import com.moon.util.ArrayGenerator;
import com.moon.util.SortingHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Chanmoey
 */
public class SortBenchmarkTest {
    private static final String SELECTION = "com.moon.sort.selectionsort.SelectionSort";
    private static final String INSERTION = "com.moon.sort.insertionsort.InsertionSort";
    private static final String MERGE = "com.moon.sort.mergesort.MergeSort";
    private static final String QUICK = "com.moon.sort.quicksort.QuickSort";
    private static final String JAVA = "java.util.Arrays";

    @Test
    public void twoSortWithOrderArrayBenchmark() {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateOrderedArray(n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("com.moon.sort.selectionsort.SelectionSort", "sort", Comparable[].class, arr);
            SortingHelper.sortTest("com.moon.sort.insertionsort.InsertionSort", "sortBetter", Comparable[].class, arr2);
        }
    }

    @Test
    public void twoSortWithRandomArrayBenchmark() {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            Integer[] arr3 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest(SELECTION, "sort", Comparable[].class, arr);
            SortingHelper.sortTest(INSERTION, "sortBetter", Comparable[].class, arr2);
            SortingHelper.sortTest(MERGE, "sort", Comparable[].class, arr3);
        }
    }

    @Test
    public void nlognSortBenchMark() {
        int[] dataSize = {10000, 100000, 1000000, 10000000, 100000000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr1 = Arrays.copyOf(arr, arr.length);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest(MERGE, "sortBetter", arr);
            SortingHelper.sortTest(QUICK, "sortBetter", arr1);
            SortingHelper.sortTest(JAVA, "sort", Object[].class, arr2);
        }
    }
}
