package com.moon.sort.countingsort;

import com.moon.util.mock.MyCharacter;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2022年12月28日
 */
public class CountingSortTest {

    @Test
    public void test() {
        MyCharacter[] data = {new MyCharacter('c'), new MyCharacter('d'),
                new MyCharacter('b'), new MyCharacter('a')};

        // a == 97, d == 100
        CountingSort.sort(data, 97, 100);
        System.out.println(Arrays.toString(data));
    }
}
