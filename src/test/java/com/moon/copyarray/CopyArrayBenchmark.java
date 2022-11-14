package com.moon.copyarray;

import com.moon.constant.Constant;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年11月15日
 */
public class CopyArrayBenchmark {

    public static double copyByFor(int count) {
        int[] arr = new int[count];
        Arrays.fill(arr, count);
        int[] copyArr = new int[count];

        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            copyArr[i] = arr[i];
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / Constant.NANOSECOND2SECOND;
    }

    public static double copyByJavaNative(int count) {
        int[] arr = new int[count];
        Arrays.fill(arr, count);
        int[] copyArr = new int[count];

        long startTime = System.nanoTime();
        System.arraycopy(arr, 0, copyArr, 0, count);
        long endTime = System.nanoTime();

        return (endTime - startTime) / Constant.NANOSECOND2SECOND;
    }

    @Test
    public void test() {
        int count = 100000000;
        double time1 = copyByFor(count);
        double time2 = copyByJavaNative(count);
        System.out.println("CopyByFor: " + time1 + 's');
        System.out.println("CopyByJavaNative: " + time2 + 's');

        // 两者性能差不多。
    }
}