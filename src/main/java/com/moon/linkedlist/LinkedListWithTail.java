package com.moon.linkedlist;

/**
 * @author Chanmoey
 * @date 2022年11月16日
 */
public class LinkedListWithTail<E> {

    private Node head;
    private Node tail;

    private int size;

    public LinkedListWithTail() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        if (tail == null) {
            head = tail = new Node(e);
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Collection is Empty!");
        }
        Node del = head;

        head = head.next;
        if (head == null) {
            tail = null;
        }
        del.next = null;
        size--;
        return del.e;
    }

    public E getFist() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Collection is Empty!");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            sb.append(cur).append(" -> ");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
