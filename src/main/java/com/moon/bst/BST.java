package com.moon.bst;

/**
 * @author Chanmoey
 * @date 2022年11月24日
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }

        return node;
    }

    public void add1(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
            return;
        }
        add1(root, e);
    }

    // 向以node为根的二分搜索树插入e
    private void add1(Node node, E e) {

        if (e.compareTo(node.e) == 0) {
            return;
        }

        if (e.compareTo(node.e) < 0) {
            if (node.left == null) {
                node.left = new Node(e);
                size++;
            } else {
                add1(node.left, e);
            }
        } else { // e.compareTo(node.e) > 0
            if (node.right == null) {
                node.right = new Node(e);
                size++;
            } else {
                add1(node.right, e);
            }
        }
    }
}
