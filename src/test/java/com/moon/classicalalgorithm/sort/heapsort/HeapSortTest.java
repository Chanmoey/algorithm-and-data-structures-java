package com.moon.classicalalgorithm.sort.heapsort;

import com.moon.classicalalgorithm.util.ArrayGenerator;
import com.moon.classicalalgorithm.util.SortingHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年12月02日
 */
public class HeapSortTest {

    @Test
    public void test() {
        int n = 1000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.heapsort.HeapSort", "sort", arr);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort", "sort2ways", arr1);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort", "sort3ways", arr2);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.mergesort.MergeSort", "sortBetter", arr3);
    }

    @Test
    public void test1() {
        int n = 1000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.heapsort.HeapSort", "sort", arr);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.heapsort.HeapSort", "sort1", arr4);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort", "sort2ways", arr1);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.quicksort.QuickSort", "sort3ways", arr2);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.mergesort.MergeSort", "sortBetter", arr3);
    }
}
