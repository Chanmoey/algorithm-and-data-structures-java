package com.moon.classicalalgorithm.sort.quicksort;

import com.moon.classicalalgorithm.util.ArrayGenerator;
import com.moon.classicalalgorithm.util.SortingHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年11月21日
 */
public class QuickSortTest {

    @Test
    public void test() {
        Integer[] arr = {1, 4, 2, 3, 6, 5, 4};
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test1() {
        int[] dataSize = {10000, 100000, 1000000, 10000000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr1 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort",
                    "sort", arr);
            SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort",
                    "sort1", arr1);
        }
        System.out.println("-------------------------------------------------");
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateOrderedArray(n);
            Integer[] arr1 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort",
                    "sort", arr);
            SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort",
                    "sort1", arr1);
        }
    }

    @Test
    public void testSort2Way() {
        int[] dataSize = {10000, 100000, 1000000, 10000000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort",
                    "sort2ways", arr);
        }
        Integer[] arr = ArrayGenerator.generateRandomArray(1000000, 1);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort",
                "sort2ways", arr);
    }

    @Test
    public void testSort3Way() {
        int[] dataSize = {10000, 100000, 1000000, 10000000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr1 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort",
                    "sort3ways", arr);
            SortingHelper.sortTest("java.util.Arrays",
                    "sort", Object[].class, arr1);
        }
        Integer[] arr = ArrayGenerator.generateRandomArray(1000000, 1);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort",
                "sort3ways", arr);
        SortingHelper.sortTest("java.util.Arrays",
                "sort", Object[].class, arr);
    }

    @Test
    public void quickSortBenchmark() {
        int[] dataSize = {10000, 100000, 1000000, 10000000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr1 = Arrays.copyOf(arr, arr.length);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            Integer[] arr3 = Arrays.copyOf(arr, arr.length);
            Integer[] arr4 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort",
                    "sort", arr);
            SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort",
                    "sort1", arr1);
            SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort",
                    "sort2ways", arr2);
            SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort",
                    "sort3ways", arr3);
            SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort",
                    "sort3ways1", arr4);
        }
    }

    @Test
    public void quickSortSameElementBenchmark() {
        int[] dataSize = {10000, 100000, 1000000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, 1);
            SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort",
                    "sort2ways", arr);
            SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort",
                    "sort3ways", arr);
            SortingHelper.sortTest("java.util.Arrays",
                    "sort", Object[].class, arr);
        }
    }
}
