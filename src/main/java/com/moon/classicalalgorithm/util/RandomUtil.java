package com.moon.classicalalgorithm.util;

import java.util.Random;

/**
 * @author Chanmoey
 */
public class RandomUtil {

    public static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    /**
     * 生成[l, r]之间的随机数
     *
     * @param l 左边界，包含
     * @param r 有边界，包含
     * @return 随机数
     */
    public static int getRandomInt(int l, int r) {
        if (l > r) {
            throw new  IllegalArgumentException("are you kidding?");
        }
        return l + RANDOM.nextInt(r - l + 1);
    }
}
