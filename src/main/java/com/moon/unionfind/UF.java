package com.moon.unionfind;

/**
 * @author Chanmoey
 * @date 2022年12月13日
 */
public interface UF {

    int getSize();

    /**
     * 两个元素是否有连接
     * @param p 所在并查集中的索引
     * @param q 所在并查集中的索引
     * @return 是否连接
     */
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
