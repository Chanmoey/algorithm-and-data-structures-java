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
            SortingHelper.sortTest("com.moon.sort.mergesort.MergeSort",
                    "sort", arr);
            SortingHelper.sortTest("java.util.Arrays", "sort",
                    Object[].class, arr);
        }
    }
}
