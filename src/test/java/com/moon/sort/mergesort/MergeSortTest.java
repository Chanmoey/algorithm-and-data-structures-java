package com.moon.sort.mergesort;

import com.moon.util.ArrayGenerator;
import com.moon.util.SortingHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年11月18日
 */
public class MergeSortTest {

    @Test
    public void baseTest() {
        Integer[] arr = {1, 4, 2, 3, 6, 5};
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void baseSoutTest() {
        Integer[] arr = {1, 4, 2, 3, 6, 5};
        MergeSort.sortSout(arr, 0, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void mergeSortBenchMark() {
        int[] dataSize = {10000, 100000, 1000000, 10000000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr1 = Arrays.copyOf(arr, arr.length);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            Integer[] arr3 = Arrays.copyOf(arr, arr.length);
            Integer[] arr4 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("com.moon.sort.mergesort.MergeSort",
                    "sort", arr);
            SortingHelper.sortTest("com.moon.sort.mergesort.MergeSort",
                    "sort1", arr1);
            SortingHelper.sortTest("com.moon.sort.mergesort.MergeSort",
                    "sort2", arr2);
            SortingHelper.sortTest("com.moon.sort.mergesort.MergeSort",
                    "sort3", arr3);
            SortingHelper.sortTest("com.moon.sort.mergesort.MergeSort",
                    "sortBU", arr4);
        }
    }
}
