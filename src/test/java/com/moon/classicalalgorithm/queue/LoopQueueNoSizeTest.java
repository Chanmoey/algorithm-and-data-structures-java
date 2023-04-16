package com.moon.classicalalgorithm.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chanmoey
 */
public class LoopQueueNoSizeTest {
    @Test
    public void LoopQueueBaseTest() {
        LoopQueueNoSize<Integer> queue = new LoopQueueNoSize<>(10);
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
        String NoSizeRes = """
                Queue: size = 0, capacity = 10 front {} tail
                Queue: size = 1, capacity = 10 front {0} tail
                Queue: size = 2, capacity = 10 front {0, 1} tail
                Queue: size = 3, capacity = 10 front {0, 1, 2} tail
                Queue: size = 2, capacity = 5 front {1, 2} tail
                Queue: size = 3, capacity = 5 front {1, 2, 3} tail
                Queue: size = 4, capacity = 5 front {1, 2, 3, 4} tail
                Queue: size = 5, capacity = 5 front {1, 2, 3, 4, 5} tail
                Queue: size = 4, capacity = 5 front {2, 3, 4, 5} tail
                Queue: size = 5, capacity = 5 front {2, 3, 4, 5, 6} tail
                Queue: size = 6, capacity = 10 front {2, 3, 4, 5, 6, 7} tail
                Queue: size = 7, capacity = 10 front {2, 3, 4, 5, 6, 7, 8} tail
                Queue: size = 6, capacity = 10 front {3, 4, 5, 6, 7, 8} tail
                Queue: size = 7, capacity = 10 front {3, 4, 5, 6, 7, 8, 9} tail""";

        String loopQueueRes = """
                Queue: size = 0, capacity = 10 front {} tail
                Queue: size = 1, capacity = 10 front {0} tail
                Queue: size = 2, capacity = 10 front {0, 1} tail
                Queue: size = 3, capacity = 10 front {0, 1, 2} tail
                Queue: size = 2, capacity = 5 front {1, 2} tail
                Queue: size = 3, capacity = 5 front {1, 2, 3} tail
                Queue: size = 4, capacity = 5 front {1, 2, 3, 4} tail
                Queue: size = 5, capacity = 5 front {1, 2, 3, 4, 5} tail
                Queue: size = 4, capacity = 5 front {2, 3, 4, 5} tail
                Queue: size = 5, capacity = 5 front {2, 3, 4, 5, 6} tail
                Queue: size = 6, capacity = 10 front {2, 3, 4, 5, 6, 7} tail
                Queue: size = 7, capacity = 10 front {2, 3, 4, 5, 6, 7, 8} tail
                Queue: size = 6, capacity = 10 front {3, 4, 5, 6, 7, 8} tail
                Queue: size = 7, capacity = 10 front {3, 4, 5, 6, 7, 8, 9} tail""";

        Assert.assertEquals(NoSizeRes, loopQueueRes);
    }

}
