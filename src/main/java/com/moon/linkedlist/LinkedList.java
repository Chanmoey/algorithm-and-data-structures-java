package com.moon.linkedlist;

/**
 * @author Chanmoey
 * @date 2022年11月15日
 */
public class LinkedList<E> {

    /**
     * 虚拟头节点，可以统一添加的逻辑
     */
    private final Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        indexGreaterThanZeroAndLessThanOrEqualSize(index);

        Node prev = dummyHead;

        // prev指向dummyHead，对应数组可以认为从-1开始。
        // 所以向指向index的前一个，需要走index次
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        indexGreaterThanZeroAndLessThanSize(index);

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void indexGreaterThanZeroAndLessThanOrEqualSize(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Can't add element in index " + index);
        }
    }

    public void indexGreaterThanZeroAndLessThanSize(int index) {
        // get或者remove的时候，当然不能获取到索引为size的地方咯
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Can't add element in index " + index);
        }
    }

    public void set(int index, E e) {
        indexGreaterThanZeroAndLessThanSize(index);

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    public E remove(int index) {
        // 删除的index不能大于等于size
        indexGreaterThanZeroAndLessThanSize(index);

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node rem = prev.next;

        // 删除逻辑
        prev.next = rem.next;

        // 帮助垃圾回收
        rem.next = null;

        size--;
        return rem.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
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
