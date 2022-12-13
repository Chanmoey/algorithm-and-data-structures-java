package com.moon.unionfind;

/**
 * 构造一棵树，子节点指向父节点。整体的QuickUnion是一个森林
 * <p>
 * 使用数组转载这棵树，数组的索引，代表了元素本身，数组的值表示这个节点指向的父节点
 *
 * @author Chanmoey
 * @date 2022年12月14日
 */
public class QuickUnion implements UF {

    private int[] parent;

    public QuickUnion(int size) {
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p) {
        checkIndex(p);
        while (p != parent[p]) {
            p = parent[p];
        }

        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        // parent[pRoot]代表了p所在集合的整个集合的根
        parent[pRoot] = qRoot;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= parent.length) {
            throw new IllegalArgumentException("index is out of bound.");
        }
    }
}
