package com.moon.classicalalgorithm.queue;

import com.moon.classicalalgorithm.util.TimeUtil;
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

        return TimeUtil.nanoSecond2Second(startTime, endTime);
    }

    @Test
    public void benchmark() {
        int count = 1000000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = queueBenchmark(arrayQueue, count);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = queueBenchmark(loopQueue, count);

        QueueBaseLinkedList<Integer> queueBaseLinkedList = new QueueBaseLinkedList<>();
        double time3 = queueBenchmark(loopQueue, count);

        System.out.println("ArrayQueue: " + time1 + "S");
        System.out.println("LoopQueue: " + time2 + "S");
        System.out.println("QueueBaseLinkedList: " + time3 + "S");
    }
}
