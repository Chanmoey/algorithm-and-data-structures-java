package com.moon.classicalalgorithm.bst;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

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

    /**
     * 前序遍历非递归实现
     */
    public void preOrderNR() {
        if (root == null) {
            System.out.println("BST is empty!");
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();
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

    /**
     * 后序遍历非递归实习
     */
    public void inOrderNR() {
        if (root == null) {
            System.out.println("BST is empty!");
            return;
        }

        Deque<Node> stack = new ArrayDeque<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                // 一直将左孩子加入栈中，知道再无左孩子
                stack.addLast(cur);
                cur = cur.left;
            }
            // 现在就是第二次访问了，也就是中序遍历
            cur = stack.removeLast();
            System.out.println(cur.e);

            // 中序之后，就该访问右孩子了
            cur = cur.right;
        }
    }

    /**
     * 后序遍历非递归实现
     */
    public void postOrderNR() {
        if (root == null) {
            System.out.println("BST is empty!");
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = root;
        Node temp;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                // 当前节点不是null，先入栈
                stack.addLast(cur);
                // 访问其左孩子
                cur = cur.left;
            } else {
                // 当前节点为null，看一下栈顶（只是peek，没有pop！！！）
                temp = stack.getLast();
                if (temp.right != null) {
                    // temp有右孩子，先访问右孩
                    cur = temp.right;
                } else {
                    // temp没有右孩，上面已经知道左孩为null，此时右孩也null，该访问temp了
                    stack.removeLast();

                    // 看要访问的temp是不是栈顶的right，如果是，那么访问完temp，就要访问栈顶了
                    while (!stack.isEmpty() && stack.getLast().right == temp) {
                        System.out.println(temp.e);
                        temp = stack.removeLast();
                    }
                    System.out.println(temp.e);
                }
            }
        }
    }

    public void levelOrder() {
        if (root == null) {
            System.out.println("BST is empty!");
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }

        return minimum(root).e;
    }

    /**
     * 返回以Node为根的二叉树的最小值
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public E minimumNR() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.e;
    }

    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public E maximumNR() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.e;
    }

    public E removeMin() {
        E ret = minimum();
        root = removeMIn(root);
        return ret;
    }

    /**
     * 删除以node为根的二叉树的最小节点，并返回删除后的二叉树的根
     */
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

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除以node为根的二叉树的最大节点，并返回删除后的二叉树的根
     */
    private Node removeMax(Node node) {
        // 此时，node应该被删除
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除任意节点
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 在以node为根的BST中删除e，递归算法
     * 返回删除后，新树的根
     */
    private Node remove(Node node, E e) {
        // 及时return，减少if的层级
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
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

    /**
     * 小于或等于e中最大的一个
     */
    public E floor(E e) {
        return floor(root, e);
    }

    private E floor(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) == 0) {
            return node.e;
        }

        if (e.compareTo(node.e) < 0) {
            // node比e大，往左边找
            return floor(node.left, e);
        }

        // 此时e比node大，去node的右边，看能不能找到比e小的
        E temp = floor(node.right, e);
        if (temp != null) {
            return null;
        }
        return node.e;
    }

    /**
     * 大于或等于e中，最小的那个
     */
    public E ceiling(E e) {
        return ceiling(root, e);
    }

    private E ceiling(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) == 0) {
            return node.e;
        }

        if (e.compareTo(node.e) > 0) {
            return ceiling(node.right, e);
        }

        // 此时node比e大，去node的左边看看有没有比node小，比e大的
        E temp = ceiling(node.left, e);
        if (temp != null) {
            return temp;
        }

        return node.e;
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
        return "--".repeat(Math.max(0, depth));
    }
}
