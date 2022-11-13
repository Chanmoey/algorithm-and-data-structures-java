package com.moon.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chanmoey
 */
public class LoopQueueJustSizeTest {
    @Test
    public void LoopQueueBaseTest() {
        LoopQueueJustSize<Integer> queue = new LoopQueueJustSize<>(10);
        System.out.println(queue);

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    @Test
    public void test() {
        String justSizeRes = "Queue: size = 0, capacity = 10 front {} tail\n" +
                "Queue: size = 1, capacity = 10 front {0} tail\n" +
                "Queue: size = 2, capacity = 10 front {0, 1} tail\n" +
                "Queue: size = 3, capacity = 10 front {0, 1, 2} tail\n" +
                "Queue: size = 2, capacity = 5 front {1, 2} tail\n" +
                "Queue: size = 3, capacity = 5 front {1, 2, 3} tail\n" +
                "Queue: size = 4, capacity = 5 front {1, 2, 3, 4} tail\n" +
                "Queue: size = 5, capacity = 5 front {1, 2, 3, 4, 5} tail\n" +
                "Queue: size = 4, capacity = 5 front {2, 3, 4, 5} tail\n" +
                "Queue: size = 5, capacity = 5 front {2, 3, 4, 5, 6} tail\n" +
                "Queue: size = 6, capacity = 10 front {2, 3, 4, 5, 6, 7} tail\n" +
                "Queue: size = 7, capacity = 10 front {2, 3, 4, 5, 6, 7, 8} tail\n" +
                "Queue: size = 6, capacity = 10 front {3, 4, 5, 6, 7, 8} tail\n" +
                "Queue: size = 7, capacity = 10 front {3, 4, 5, 6, 7, 8, 9} tail";
        String loopQueueRes = "Queue: size = 0, capacity = 10 front {} tail\n" +
                "Queue: size = 1, capacity = 10 front {0} tail\n" +
                "Queue: size = 2, capacity = 10 front {0, 1} tail\n" +
                "Queue: size = 3, capacity = 10 front {0, 1, 2} tail\n" +
                "Queue: size = 2, capacity = 5 front {1, 2} tail\n" +
                "Queue: size = 3, capacity = 5 front {1, 2, 3} tail\n" +
                "Queue: size = 4, capacity = 5 front {1, 2, 3, 4} tail\n" +
                "Queue: size = 5, capacity = 5 front {1, 2, 3, 4, 5} tail\n" +
                "Queue: size = 4, capacity = 5 front {2, 3, 4, 5} tail\n" +
                "Queue: size = 5, capacity = 5 front {2, 3, 4, 5, 6} tail\n" +
                "Queue: size = 6, capacity = 10 front {2, 3, 4, 5, 6, 7} tail\n" +
                "Queue: size = 7, capacity = 10 front {2, 3, 4, 5, 6, 7, 8} tail\n" +
                "Queue: size = 6, capacity = 10 front {3, 4, 5, 6, 7, 8} tail\n" +
                "Queue: size = 7, capacity = 10 front {3, 4, 5, 6, 7, 8, 9} tail";

        Assert.assertEquals(justSizeRes, loopQueueRes);
    }

}
