package com.moon.sort.sleepSort;

/**
 * @author Chanmoey
 * @date 2022年11月18日
 */
public class SleepSort {

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (E e : arr) {
            new Thread(() -> {
                try {
                    Thread.sleep((Integer) e);
                    System.out.println(e);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }).start();
        }
    }
}
