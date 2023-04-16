package com.moon.classicalalgorithm.sort.sleepsort;

import com.moon.classicalalgorithm.sort.sleepSort.SleepSort;
import org.junit.Test;

/**
 * @author Chanmoey
 * @date 2022年11月18日
 */
public class SleepSortTest {

    @Test
    public void test() throws InterruptedException {
        Integer[] arr = {3, 5, 7, 1, 3, 8, 3, 2, 1};
        new Thread(() -> SleepSort.sort(arr)).start();
        Thread.currentThread().join();
    }
}
