package com.moon.rbt;

import com.moon.map.Map;

/**
 * 红黑树
 *
 * @author Chanmoey
 * @date 2022年12月24日
 */
public class RBTree<K extends Comparable<K>, V> implements Map<K, V> {

    public static final boolean RED = true;
    public static final boolean BLACK = false;

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;
        private boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;

            // 2-3树中，添加一个节点，默认和叶子节点进行融合，在红黑树中就是红节点
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree() {
        this.root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);

        // 根节点为黑节点
        root.color = BLACK;
    }

    /**
     * 左旋转过程，参考AVL树的过程
     */
    private Node leftRote(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;

        // 颜色变换
        x.color = node.color;
        node.color = RED;
        return x;
    }

    /**
     * 右旋转
     */
    private Node rightRotate(Node node) {
        Node x = node.left;

        // 右旋转
        node.left = x.right;
        x.right = node;

        // 颜色翻转
        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * 颜色翻转
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
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

        return node;
    }

    @Override
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

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            add(key, newValue);
        } else {
            node.value = newValue;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            // 3节点才有红节点，所以空节点肯定是黑节点
            return BLACK;
        }

        return node.color;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        throw new IllegalArgumentException(key + " doesn't exist");
    }

    private Node remove(Node node, K key) {
        // 及时return，减少if的层级
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        }
        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        }

        // 此时，e.compareTo(node.e) == 0
        if (node.right == null && node.left == null) {
            return null;
        }

        // 把右孩子当成根
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        // 左右孩子都不是null，将右孩子树的最小值当成根
        // 这一部分不用size--，removeMIn里--了
        Node rightMin = minimum(node.right);
        rightMin.right = removeMIn(node.right);
        rightMin.left = node.left;
        node.left = node.right = null;
        return rightMin;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private Node removeMIn(Node node) {
        // 此时，node应该被删除
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMIn(node.left);
        return node;
    }
}
