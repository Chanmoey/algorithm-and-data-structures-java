package com.moon.classicalalgorithm.array;

import com.moon.classicalalgorithm.util.TimeUtil;
import org.junit.Test;

/**
 * @author Chanmoey
 * @date 2023年04月14日
 */
public class ArrayBenchmarkTest {

    @Test
    public void benchmark() {
        int n = 1000000;
        FastArray<Integer> fastArray = new FastArray<>();
        Array<Integer> array = new Array<>();
        addAndRemove(n, fastArray, "FastArray"); // 0.0547998
        addAndRemove(n, array, "Array"); // 233.0801137
    }

    private void addAndRemove(int n, Array<Integer> array, String title) {
        if (array instanceof FastArray<Integer> fastArray) {
            long start = System.nanoTime();
            for (int i = 0; i < n; i++) {
                fastArray.addWithSwitch(0, i);
            }
            for (int i = 0; i < n; i++) {
                fastArray.removeWithSwitch(0);
            }
            long end = System.nanoTime();
            System.out.println(title + ": " +  TimeUtil.nanoSecond2Second(start, end));
        } else {
            long start = System.nanoTime();
            for (int i = 0; i < n; i++) {
                array.addFirst(i);
            }
            for (int i = 0; i < n; i++) {
                array.removeFirst();
            }
            long end = System.nanoTime();
            System.out.println(title + ": " +  TimeUtil.nanoSecond2Second(start, end));
        }


    }
}
