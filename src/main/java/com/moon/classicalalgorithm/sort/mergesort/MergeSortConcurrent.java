package com.moon.classicalalgorithm.sort.mergesort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 基于线程池的并行归并排序没做完
 * @author Chanmoey
 * @date 2022年12月17日
 */
public class MergeSortConcurrent implements Callable<Boolean> {

    private int l;
    private int r;
    private int[] arr;

    public MergeSortConcurrent(int[] arr, int l, int r) {
        this.l = l;
        this.r = r;
        this.arr = arr;
    }


    private static final ExecutorService executor = Executors.newFixedThreadPool(32);

    // 对 [l, r)进行排序
    @Override
    public Boolean call() {
        if ((r - l) <= 10) {
            Arrays.sort(arr, l, r);
            System.out.println(Arrays.toString(arr));
            return true;
        }

        int mid = l + (r - l) / 2;
        Future<Boolean> future1 = executor.submit(new MergeSortConcurrent(arr, l, mid));
        Future<Boolean> future2 = executor.submit(new MergeSortConcurrent(arr, mid, r));

        try {
            future1.get();
            future2.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        int[] temp = Arrays.copyOf(arr, arr.length);
        // merge
        System.arraycopy(arr, l, temp, l, r - l);
        int i = l;
        int j = mid;
        int idx = l;
        while (i < mid && j < r) {
            if (arr[i] < arr[j]) {
                arr[idx++] = temp[i++];
            } else {
                arr[idx++] = temp[j++];
            }
        }

        while (i < mid) {
            arr[idx++] = temp[i++];
        }

        while (j < r) {
            arr[idx++] = temp[j++];
        }
        return true;
    }


    public static void isOrdered(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                System.out.println("No Ordered!");
                return;
            }
        }

        System.out.println("Yes, is ordered!");
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int n = 100;
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n);
        }
        System.out.println(Arrays.toString(arr));
        MergeSortConcurrent mergeSort = new MergeSortConcurrent(arr, 0, arr.length);
        long start = System.nanoTime();
        Future<Boolean> future = executor.submit(mergeSort);
        System.out.println(Arrays.toString(arr));
        isOrdered(arr);
        System.out.println(future.get());
        System.out.println((System.nanoTime() - start) / 1000000000.0 + "s");
        System.exit(0);
    }
}
