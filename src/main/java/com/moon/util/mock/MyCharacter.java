package com.moon.util.mock;

import com.moon.sort.countingsort.Weight;

/**
 * @author Chanmoey
 * @date 2022年12月28日
 */
public class MyCharacter implements Weight {

    private final char c;

    public MyCharacter(char c) {
        this.c = c;
    }

    @Override
    public int weight() {
        return c;
    }

    @Override
    public String toString() {
        return String.valueOf(c);
    }
}
