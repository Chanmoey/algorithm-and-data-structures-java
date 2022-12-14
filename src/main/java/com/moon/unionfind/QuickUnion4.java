package com.moon.unionfind;

/**
 * QuickUnion的第四版优化，基于递归的路径压缩
 * 递归的性能在大部分语言下，都不如循环，所以第三版实际上性能更好
 * <p>
 * 构造一棵树，子节点指向父节点。整体的QuickUnion是一个森林
 * <p>
 * 使用数组转载这棵树，数组的索引，代表了元素本身，数组的值表示这个节点指向的父节点
 *
 * @author Chanmoey
 * @date 2022年12月14日
 */
public class QuickUnion4 implements UF {

    private final int[] parent;
    private final int[] rank;

    public QuickUnion4(int size) {
        parent = new int[size];

        // 初始时，每一棵的sz都是1
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p) {
        checkIndex(p);
        if (p != parent[p]) {
            // find的宏观语义是返回p节点所在子树的根节点
            // 所以回溯回来，让p指向其根节点即可
            parent[p] = find(parent[p]);
        }
        return parent[p];
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
        if (rank[pRoot] < rank[qRoot]) {
            // 深度小的指向深度高的，那么合并后，树的深度不会改变
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= parent.length) {
            throw new IllegalArgumentException("index is out of bound.");
        }
    }
}
