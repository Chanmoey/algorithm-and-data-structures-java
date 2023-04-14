package com.moon.math;

/**
 * @author Chanmoey
 * @date 2023年04月14日
 */
public class MonteCarlo {

    private MonteCarlo() {}

    /**
     * random生成01之间随机数，求pi
     */
    public static double getPi(long randomNum) {
        double inCircle = 0L;
        for (long i = 0L; i < randomNum; i++) {
            double x = Math.random();
            double y = Math.random();
            double l = Math.sqrt(x*x + y*y);
            if (l < 1.0) {
                inCircle ++;
            }
        }

        return (inCircle / randomNum) * 4;
    }
}
