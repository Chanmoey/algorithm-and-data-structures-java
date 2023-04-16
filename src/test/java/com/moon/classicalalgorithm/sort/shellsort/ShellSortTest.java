package com.moon.classicalalgorithm.sort.shellsort;

import com.moon.classicalalgorithm.util.ArrayGenerator;
import com.moon.classicalalgorithm.util.SortingHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年12月07日
 */
public class ShellSortTest {

    @Test
    public void test() {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.shellsort.ShellSort", "sort", arr);
    }

    @Test
    public void test1() {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.shellsort.ShellSort", "sort1", arr);
    }

    @Test
    public void benchmark() {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.shellsort.ShellSort", "sort", arr);
//        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.insertionsort.InsertionSort", "sort", arr1);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.mergesort.MergeSort", "sort", arr2);
    }

    @Test
    public void twoStepbenchmark() {
        int n = 5000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.shellsort.ShellSort", "sort", arr);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.shellsort.ShellSort", "sort2", arr1);
    }
}
