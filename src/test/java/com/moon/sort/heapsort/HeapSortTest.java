package com.moon.sort.heapsort;

import com.moon.util.ArrayGenerator;
import com.moon.util.SortingHelper;
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

        SortingHelper.sortTest("com.moon.sort.heapsort.HeapSort", "sort", arr);
        SortingHelper.sortTest("com.moon.sort.quicksort.QuickSort", "sort2ways", arr1);
        SortingHelper.sortTest("com.moon.sort.quicksort.QuickSort", "sort3ways", arr2);
        SortingHelper.sortTest("com.moon.sort.mergesort.MergeSort", "sortBetter", arr3);
    }
}
