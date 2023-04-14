package com.moon.linkedlist;

/**
 * @author Chanmoey
 * @date 2023年04月14日
 */
public class DoubleLinkedList<E> {

    public class Node {
        private E value;

        private Node prev;
        private Node next;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private final Node dummyHead;

    private Node tail;

    private int size;

    public DoubleLinkedList() {
        this.dummyHead = new Node(null);
        tail = dummyHead;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int idx, E e) {
        checkAddIdx(idx);
        Node pre = dummyHead;
        for (int i = 0; i < idx; i++) {
            pre = pre.next;
        }
        Node newNode = new Node(e, pre, pre.next);

        if (pre == tail) {
            tail = newNode;
        } else {
            pre.next.prev = newNode;
        }
        pre.next = newNode;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(getSize(), e);
    }

    public E get(int idx) {
        checkAddIdx(idx);
        return getNode(idx).value;
    }

    public Node getNode(int idx) {
        Node cur = dummyHead.next;
        for (int i = 0; i < idx; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(getSize() - 1);
    }

    public void set(int idx, E e) {
        checkAddIdx(idx);
        Node node = getNode(idx);
        node.value = e;
    }

    public Node getNode(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.value.equals(e)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    public boolean contains(E e) {
        return getNode(e) != null;
    }

    public void remove(int idx) {
        checkRemoveIdx(idx);
        Node cur = dummyHead.next;
        for (int i = 0; i < idx; i++) {
            cur = cur.next;
        }

        remove(cur);
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(getSize() - 1);
    }

    public void removeElement(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.value.equals(e)) {
                break;
            }
            cur = cur.next;
        }
        if (cur == null) {
            return;
        }
        remove(cur);
    }

    public void remove(Node node) {
        size--;
        if (node == tail) {
            tail = node.prev;
            // 断开连接 Help GC
            node.prev = null;
            tail.next = null;
            return;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

        // Help GC
        node.prev = null;
        node.next = null;
    }

    private void checkRemoveIdx(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException(idx + " is out of bound in [0, " + (size - 1) + "]");
        }
    }

    private void checkAddIdx(int idx) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException(idx + " is out of bound in [0, " + size + "]");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur).append(" <-> ");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
