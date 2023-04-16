package com.moon.classicalalgorithm.avltree;

import java.util.ArrayList;

/**
 * @author Chanmoey
 * @date 2022年12月17日
 */
public class AVLTree<K extends Comparable<K>, V> {

    private class Node {
        public K key;
        public V value;
        public Node left;
        public Node right;
        public int height;


        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    /**
     * 获取node的高度
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 获得node的平衡因子
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            // key.compareTo(node.key) == 0
            node.value = value;
        }

        // 更新node的高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);

        // 平衡维护
        // 左孩高于右孩 LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            // 右旋转
            return rightRotate(node);
        }

        // 右孩高于左孩 RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        // LR：新节点插入到不平衡阶段的左孩子的右孩子，导致了不平衡
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    /**
     * 对节点y进行向右旋转操作，返回旋转后的新的根节点x
     * y                                 x
     * / \                               / \
     * x   T4      向右旋转 (y)           z    y
     * / \        -------------->       / \   / \
     * z   T3                           T1 T2 T3  T4
     * / \
     * T1  T2
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t3 = x.right;

        // 右旋转
        x.right = y;
        y.left = t3;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    /**
     * 对节点y进行向左旋转操作，返回旋转后的新的根节点x
     * y                                 x
     * / \                               / \
     * T1  x      向左旋转 (y)            y    z
     * / \     -------------->      / \   / \
     * T2  z                        T1 T2 T3  T4
     * / \
     * T1 T2
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node t2 = x.left;

        // 左选择
        x.left = y;
        y.right = t2;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            add(key, newValue);
        } else {
            node.value = newValue;
        }

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否是二分搜索树
     *
     * @return
     */
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);

        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {

        if (node == null) {
            return;
        }

        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    public boolean isBalance() {
        return isBalance(root);
    }

    private boolean isBalance(Node node) {
        if (node == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }

        return isBalance(node.left) && isBalance(node.right);
    }

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        // 及时return，减少if的层级
        if (node == null) {
            return null;
        }

        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else {
            // 此时，e.compareTo(node.e) == 0

            // 把右孩子当成根
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            } else {
                // 左右孩子都不是null，将右孩子树的最小值当成根
                // 这一部分不用size--，removeMIn里--了
                Node rightMin = minimum(node.right);

                // removeMin没有维护平衡，不能再用了

                rightMin.right = remove(node.right, rightMin.key);
                rightMin.left = node.left;
                node.left = node.right = null;
                retNode = rightMin;
            }
        }

        if (retNode == null) {
            return null;
        }

        // 更新node的高度
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);

        // 平衡维护
        // 左孩高于右孩 LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            // 右旋转
            return rightRotate(retNode);
        }

        // 右孩高于左孩 RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            return leftRotate(retNode);
        }

        // LR：新节点插入到不平衡阶段的左孩子的右孩子，导致了不平衡
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }

        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

}
