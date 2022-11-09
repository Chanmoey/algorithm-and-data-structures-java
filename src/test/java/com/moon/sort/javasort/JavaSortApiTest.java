package com.moon.sort.javasort;

import com.moon.util.ArrayGenerator;
import com.moon.util.SortingHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Chanmoey
 */
public class JavaSortApiTest {

    @Test
    public void testJavaSort() {
        int n = 10000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Arrays.sort(arr);
        SortingHelper.sortTest("java.util.Arrays", "sort",
                Object[].class, arr);
    }
}
