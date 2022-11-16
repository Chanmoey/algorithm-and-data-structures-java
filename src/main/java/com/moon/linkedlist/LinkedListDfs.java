package com.moon.linkedlist;

/**
 * @author Chanmoey
 * @date 2022年11月17日
 */
public class LinkedListDfs<E> {

    /**
     * 虚拟头节点，可以统一添加的逻辑
     */
    private final Node dummyHead;
    private int size;

    public LinkedListDfs() {
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
        addDfs(index, e, -1, dummyHead);
    }

    private void addDfs(int index, E e, int position, Node prev) {
        if (position == index - 1) {
            prev.next = new Node(e, prev.next);
            size++;
            return;
        }
        addDfs(index, e, position + 1, prev.next);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        indexGreaterThanZeroAndLessThanSize(index);
        return getDfs(index, 0, dummyHead.next);
    }

    private E getDfs(int index, int position, Node cur) {
        if (position == index) {
            return cur.e;
        }
        return getDfs(index, position + 1, cur.next);
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
        setDfs(index, e, 0, dummyHead.next);
    }

    private void setDfs(int index, E e, int position, Node cur) {
        if (index == position) {
            cur.e = e;
            return;
        }

        setDfs(index, e, position + 1, cur.next);
    }

    public boolean contains(E e) {
        return containsDfs(e, dummyHead.next);
    }

    private boolean containsDfs(E e, Node cur) {
        if (cur == null) {
            return false;
        }

        if (cur.e.equals(e)) {
            return true;
        }

        return containsDfs(e, cur.next);
    }

    public E remove(int index) {
        // 删除的index不能大于等于size
        indexGreaterThanZeroAndLessThanSize(index);
        return removeDfs(index, -1, dummyHead);
    }

    private E removeDfs(int index, int position, Node prev) {
        if (position == index - 1) {
            Node del = prev.next;
            prev.next = del.next;
            del.next = null;
            size--;
            return del.e;
        }
        return removeDfs(index, position + 1, prev.next);
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        dummyHead.next = removeElement(dummyHead.next, e);
    }

    private Node removeElement(Node cur, E e) {
        if (cur == null) {
            return null;
        }

        // 在当前节点后的链表中删除e，并返回删除后的结果链表
        Node res = removeElement(cur.next, e);

        if (cur.e.equals(e)) {
            return res;
        } else {
            cur.next = res;
            return cur;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringDfs(dummyHead.next, sb);
        return sb.toString();
    }

    private void toStringDfs(Node cur, StringBuilder sb) {
        if (cur == null) {
            sb.append("null");
            return;
        }
        sb.append(cur).append(" -> ");
        toStringDfs(cur.next, sb);
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

