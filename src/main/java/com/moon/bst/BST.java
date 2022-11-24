package com.moon.bst;

import com.moon.queue.Deque;

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
        } else if (e.compareTo(node.e) > 0) {
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

    /**
     * 向以node为根的二分搜索树插入e
     */
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

    /**
     * 插入元素的非递归实现
     */
    public void addNR(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
            return;
        }

        String d = null;
        Node father = null;
        Node cur = root;
        while (cur != null) {
            if (e.compareTo(cur.e) == 0) {
                // 不添加重复元素，提早return
                return;
            } else if (e.compareTo(cur.e) < 0) {
                d = "left";
                father = cur;
                cur = cur.left;
            } else {
                d = "right";
                father = cur;
                cur = cur.right;
            }
        }

        if ("left".equals(d)) {
            father.left = new Node(e);
        } else {
            father.right = new Node(e);
        }
        size++;
    }

    /**
     * BST是否包含元素e
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 递归，以node为根的BST是否包含e
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return false;
        }

        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历，场景：内存释放
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void preOrderNR() {
        if (root == null) {
            return;
        }
        Deque<Node> stack = new Deque<>();
        stack.addLast(root);

        while (!stack.isEmpty()) {
            Node cur = stack.removeLast();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.addLast(cur.right);
            }
            if (cur.left != null) {
                stack.addLast(cur.left);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root, 0, sb);
        return sb.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            sb.append(generateDepthString(depth)).append("null\n");
            return;
        }

        sb.append(generateDepthString(depth)).append(node.e).append("\n");
        generateBSTString(node.left, depth + 1, sb);
        generateBSTString(node.right, depth + 1, sb);
    }

    private String generateDepthString(int depth) {
        StringBuilder sb = new StringBuilder();
        sb.append("--".repeat(Math.max(0, depth)));
        return sb.toString();
    }
}
