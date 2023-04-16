package com.moon.classicalalgorithm.stack;

import org.junit.Test;

import java.util.Random;

/**
 * @author Chanmoey
 * @date 2022年11月15日
 */
public class BenchmarkTest {

    private static final Random RANDOM = new Random();

    private static double benchmark(Stack<Integer> stack, int count) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            stack.push(random.nextInt(count));
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void test() {

        int count = 10000000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = benchmark(arrayStack, count);
        System.out.println("ArrayStack: " + time1 + "s");

        StackBaseLinkedList<Integer> stackBaseLinkedList = new StackBaseLinkedList<>();
        double time2 = benchmark(stackBaseLinkedList, count);
        System.out.println("StackBaseLinkedStack: " + time2 + "s");

        /*
         * My Benchmark Result
         * ArrayStack: 0.859374s
         * StackBaseLinkedStack: 2.7112246s
         */
    }
}
