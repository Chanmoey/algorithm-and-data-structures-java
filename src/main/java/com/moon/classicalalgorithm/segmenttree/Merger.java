package com.moon.classicalalgorithm.segmenttree;

/**
 * 融合器，对于线段树区间内的数据要做合作处理，通过merge方法来实现。
 *
 * @author Chanmoey
 * @date 2022年12月09日
 */
public interface Merger<E> {
    E merge(E a, E b);
}
