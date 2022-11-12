package com.moon.queue;

import org.junit.Test;

import java.util.Random;

/**
 * @author Chanmoey
 */
public class QueueBenchmarkTest {

    private static final Random RANDOM = new Random();

    private static double queueBenchmark(Queue<Integer> queue, int count) {
        long startTime = System.nanoTime();

        for (int i = 0; i < count; i++) {
            queue.enqueue(RANDOM.nextInt(count));
        }

        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void benchmark() {
        int count = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = queueBenchmark(arrayQueue, count);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = queueBenchmark(loopQueue, count);

        System.out.println("ArrayQueue: " + time1 + "S");
        System.out.println("LoopQueue: " + time2 + "S");
    }
}
