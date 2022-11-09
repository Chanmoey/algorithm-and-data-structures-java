package com.moon.sort.selectionsort;

import com.moon.util.ArrayGenerator;
import com.moon.util.SortingHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Chanmoey
 */
public class SelectionSortTest {

    @Test
    public void selectionSortTest() {
        Integer[] arr = {1, 4, 2, 3, 6, 5};
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void selectionSortBenchMark() {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("com.moon.sort.selectionsort.SelectionSort", "sort", arr);
        }
    }

    @Test
    public void selectionSortBenchMark2() {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("com.moon.sort.selectionsort.SelectionSort", "sort2", arr);
        }
    }

    @Test
    public void selectionSortBenchMark3() {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("com.moon.sort.selectionsort.SelectionSort", "sort3", arr);
        }
    }
}
