package com.moon.lsdsort;

import com.moon.sort.lsdsort.LSDSort;
import org.junit.Test;

/**
 * @author Chanmoey
 * @date 2023年01月06日
 */
public class LSDSortTest {

    @Test
    public void test() {
        String[] arr = {"BCA", "CAB", "ACB", "BAC", "ABC", "CBA"};
        LSDSort.sort(arr, 3);
        for(String s: arr)
            System.out.println(s);
    }
}
