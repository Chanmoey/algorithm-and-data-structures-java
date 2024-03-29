package com.moon.classicalalgorithm.segmenttree;

import org.junit.Test;

/**
 * @author Chanmoey
 * @date 2022年12月09日
 */
public class SegmentTreeTest {

    @Test
    public void mergeTest() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, Integer::sum);
        System.out.println(segmentTree);;
    }

    @Test
    public void queryTest() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, Integer::sum);
        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(2, 5));
        System.out.println(segmentTree.query(0, 5));
    }
}
