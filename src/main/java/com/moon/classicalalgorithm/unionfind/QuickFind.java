package com.moon.classicalalgorithm.unionfind;

/**
 * Quick Find
 * @author Chanmoey
 * @date 2022年12月14日
 */
public class QuickFind implements UF {

    private final int[] id;

    public QuickFind(int size) {
        this.id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }


    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 返回元素p对应的集合编号
     */
    private int find(int p) {
        checkIndex(p);
        return id[p];
    }

    /**
     * O(1)
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * O(n)
     * 合并p和q，意味着p的集合和q的集合连接在一起了
     */
    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }

        // 全部变成qID
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= id.length) {
            throw new IllegalArgumentException("index is out of bound.");
        }
    }
}
