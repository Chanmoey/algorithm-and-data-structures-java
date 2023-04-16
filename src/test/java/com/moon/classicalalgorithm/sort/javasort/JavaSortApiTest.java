package com.moon.classicalalgorithm.sort.javasort;

import com.moon.classicalalgorithm.util.ArrayGenerator;
import com.moon.classicalalgorithm.util.SortingHelper;
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
