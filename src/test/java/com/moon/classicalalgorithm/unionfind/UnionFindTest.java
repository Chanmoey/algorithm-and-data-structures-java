package com.moon.classicalalgorithm.unionfind;

import com.moon.classicalalgorithm.util.TimeUtil;
import org.junit.Test;

import java.util.Random;

/**
 * @author Chanmoey
 * @date 2022年12月15日
 */
public class UnionFindTest {

    private static double ufBenchmark(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return TimeUtil.nanoSecond2Second(startTime, endTime);
    }

    /**
     * 测试QuickFind和QuickUnion的性能
     */
    @Test
    public void baseTest() {
        int size = 10000000;
        int m = 10000000;

//        QuickFind qf = new QuickFind(size);
//        System.out.println("QuickFind: " + ufBenchmark(qf, m) + "s");
//
//        QuickUnion qu = new QuickUnion(size);
//        System.out.println("QuickUnion: " + ufBenchmark(qu, m) + "s");

        QuickUnion1 qu1 = new QuickUnion1(size);
        System.out.println("QuickUnion1: " + ufBenchmark(qu1, m) + "s");

        QuickUnion2 qu2 = new QuickUnion2(size);
        System.out.println("QuickUnion2: " + ufBenchmark(qu2, m) + "s");

        QuickUnion3 qu3 = new QuickUnion3(size);
        System.out.println("QuickUnion3: " + ufBenchmark(qu3, m) + "s");

        QuickUnion4 qu4 = new QuickUnion4(size);
        System.out.println("QuickUnion4: " + ufBenchmark(qu4, m) + "s");
    }
}
