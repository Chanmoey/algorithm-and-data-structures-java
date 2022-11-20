package com.moon.sort.quicksort;

import com.moon.sort.mergesort.MergeSort;
import com.moon.util.ArrayGenerator;
import com.moon.util.SortingHelper;
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
            SortingHelper.sortTest("com.moon.sort.quicksort.QuickSort",
                    "sort", arr);
            SortingHelper.sortTest("com.moon.sort.quicksort.QuickSort",
                    "sort1", arr1);
        }
        System.out.println("-------------------------------------------------");
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateOrderedArray(n);
            Integer[] arr1 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("com.moon.sort.quicksort.QuickSort",
                    "sort", arr);
            SortingHelper.sortTest("com.moon.sort.quicksort.QuickSort",
                    "sort1", arr1);
        }
    }
}
