package com.moon.segmenttree;

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
}
