package com.moon.classicalalgorithm.sort.bubblesort;

import com.moon.classicalalgorithm.util.ArrayGenerator;
import com.moon.classicalalgorithm.util.SortingHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年12月07日
 */
public class BubbleSortTest {

    @Test
    public void baseTest() {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.bubblesort.BubbleSort", "sort", arr);
    }

    @Test
    public void sortOrderArrayTest() {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateOrderedArray(n);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.bubblesort.BubbleSort", "sort", arr);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.bubblesort.BubbleSort", "sort1", arr1);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.bubblesort.BubbleSort", "sort2", arr2);
    }

    @Test
    public void sortRandomArrayTest() {
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.bubblesort.BubbleSort", "sort", arr);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.bubblesort.BubbleSort", "sort1", arr1);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.bubblesort.BubbleSort", "sort2", arr2);
    }

    @Test
    public void sort3Test() {
        int n = 50000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("com.moon.classicalalgorithm.sort.bubblesort.BubbleSort", "sort3", arr);
    }
}
