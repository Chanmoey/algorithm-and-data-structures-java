package com.moon.array;

/**
 * @author Chanmoey
 */
public class Array<E> {

    private Object[] data;
    private int size;

    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};

    public Array() {
        this(0);
    }

    /**
     * 开辟capacity大小的数组
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        if (capacity == 0) {
            this.data = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
        } else {
            this.data = new Object[capacity];
        }
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return this.data.length;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    /**
     * index   0 1 2 3 4
     * element x x x x x
     * size = 5
     *
     * @param index 待插入的位置
     * @param e     元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index must >= 0 and index <= " + size);
        }

        // 数组已满，调用grow()扩容
        if (size == data.length) {
            grow();
        }

        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public void set(int index, E e) {
        checkIndex(index);
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }

        return false;
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    // 只删除第一个
    public void removeElement(E e) {
        int index = indexOf(e);
        if (index != -1) {
            remove(index);
        }
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        checkIndex(index);
        E rem = (E) data[index];

        // 如果是删除最后一个元素，不需要进行额外的处理，是需要size--即可。否则需要将index以后的元素往前移一位。
        if (index < size - 1) {
            System.arraycopy(data, index + 1, data, index, size - index);
        }
        size--;

        // 释放索引，帮助垃圾回收
        data[size] = null;

        // 缩容，懒惰缩容，防止复杂的震荡。但元素个数等于数组容量的0.25倍才锁容，且只缩容一半。
        if (size <= (data.length >> 2) && (data.length >> 1) != 0) {
            grow(data.length >> 1);
        }

        return rem;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index must >= 0 and index < " + size);
        }
    }

    private void grow() {
        grow((size + 1) << 1);
    }

    private void grow(int capacity) {
        Object[] newData = new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);

        this.data = newData;
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        Object temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d \n", size, data.length));
        sb.append("{");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]);
            sb.append(", ");
        }
        if (size > 0) {
            sb.append(data[size - 1]);
        }
        sb.append("}");
        return sb.toString();
    }
}