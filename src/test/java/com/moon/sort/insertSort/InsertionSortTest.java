package com.moon.sort.insertSort;

import com.moon.sort.insertionsort.InsertionSort;
import com.moon.util.ArrayGenerator;
import com.moon.util.SortingHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Chanmoey
 */
public class InsertionSortTest {

    @Test
    public void selectionSortTest() {
        Integer[] arr = {1, 4, 2, 3, 6, 5};
        InsertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void selectionSortBenchMark() {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("com.moon.sort.insertionsort.InsertionSort", "sort", arr);
        }
    }

    @Test
    public void selectionSortBetterBenchMark() {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("com.moon.sort.insertionsort.InsertionSort", "sortBetter", arr);
        }
    }

    @Test
    public void twoMethodBenchmark() {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest("com.moon.sort.insertionsort.InsertionSort", "sort", arr);
            SortingHelper.sortTest("com.moon.sort.insertionsort.InsertionSort", "sortBetter", arr2);
        }
    }
}
