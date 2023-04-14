package com.moon.math;

import org.junit.Test;

/**
 * @author Chanmoey
 * @date 2023年04月14日
 */
public class MonteCarloTest {

    @Test
    public void getPiTest() {
        double pi = MonteCarlo.getPi(10000000);
        System.out.println(pi);
    }
}
