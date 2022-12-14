package com.moon.unionfind;

/**
 * 对QuickUnion的第一版优化
 * <p>
 * 构造一棵树，子节点指向父节点。整体的QuickUnion是一个森林
 * <p>
 * 使用数组转载这棵树，数组的索引，代表了元素本身，数组的值表示这个节点指向的父节点
 *
 * @author Chanmoey
 * @date 2022年12月14日
 */
public class QuickUnion1 implements UF {

    private final int[] parent;
    private final int[] sz;

    public QuickUnion1(int size) {
        parent = new int[size];

        // 初始时，每一棵的sz都是1
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
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

        // 深度小的树指向深度大的树
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= parent.length) {
            throw new IllegalArgumentException("index is out of bound.");
        }
    }
}
