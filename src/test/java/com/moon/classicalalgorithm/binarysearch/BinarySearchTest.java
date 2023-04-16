package com.moon.classicalalgorithm.binarysearch;

import com.moon.classicalalgorithm.util.ArrayGenerator;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chanmoey
 * @date 2022年11月22日
 */
public class BinarySearchTest {

    @Test
    public void searchTest() {
        int n = 100000;
        Integer[] data = ArrayGenerator.generateOrderedArray(n);
        Assert.assertEquals(100, BinarySearch.search(data, 100));
    }

    @Test
    public void searchRTest() {
        int n = 100000;
        Integer[] data = ArrayGenerator.generateOrderedArray(n);
        Assert.assertEquals(100, BinarySearch.searchR(data, 100));
    }

    @Test
    public void upperTest() {
        int n = 100000;
        Integer[] data = ArrayGenerator.generateOrderedArray(n);
        Assert.assertEquals(101, BinarySearch.upper(data, 100));

        data = new Integer[]{1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.upper(data, i) + " ");
        }
        System.out.println();
    }

    @Test
    public void ceilTest() {
        int n = 100000;
        Integer[] data = ArrayGenerator.generateOrderedArray(n);
        Assert.assertEquals(100, BinarySearch.ceil(data, 100));

        data = new Integer[]{1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.ceil(data, i) + " ");
        }
        System.out.println();
    }

    @Test
    public void lowerCeilTest() {
        //                             0  1  2  3  4  5
        Integer[] data = new Integer[]{1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.lowerCeil(data, i) + " ");
        }
        System.out.println();
    }

    @Test
    public void lowerTest() {
        //                             0  1  2  3  4  5
        Integer[] data = new Integer[]{1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.lower(data, i) + " ");
        }
        System.out.println();
    }

    @Test
    public void lowerFloorTest() {
        //                             0  1  2  3  4  5
        Integer[] data = new Integer[]{1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.lowerFloor(data, i) + " ");
        }
        System.out.println();
    }

    @Test
    public void upperFloorTest() {
        //                             0  1  2  3  4  5
        Integer[] data = new Integer[]{1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.upperFloor(data, i) + " ");
        }
        System.out.println();
    }
}
