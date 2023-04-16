package com.moon.classicalalgorithm.util;

/**
 * @author Chanmoey
 * @date 2022年11月16日
 */
public class TimeUtil {

    public static final double NANOSECOND2SECOND = 1000000000.0;

    public static double nanoSecond2Second(long startTime, long endTime) {
        return (endTime - startTime) / NANOSECOND2SECOND;
    }
}
