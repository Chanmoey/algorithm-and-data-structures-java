package com.moon.sort.shellsort;

import com.moon.util.ArrayGenerator;
import com.moon.util.SortingHelper;
import org.junit.Test;

/**
 * @author Chanmoey
 * @date 2022年12月07日
 */
public class ShellSortTest {

    @Test
    public void test() {
        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("com.moon.sort.shellsort.ShellSort", "sort", arr);
    }
}
