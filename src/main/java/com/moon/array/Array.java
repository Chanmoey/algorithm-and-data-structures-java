package com.moon.array;

/**
 * @author Chanmoey
 */
public class Array {

    private int[] data;
    private int size;

    private static final int[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};

    public Array() {
        this(16);
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
            this.data = new int[capacity];
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

    public void addFirst(int e) {
        add(0, e);
    }

    public void addLast(int e) {
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
    public void add(int index, int e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index must >= 0 and index <= " + size);
        }

        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    private void grow() {
        if (size < 0) {
            throw new IllegalArgumentException("Size Must bigger than 0");
        }
        if (size == 0) {
            size = 2;
        }
        int[] newData = new int[this.data.length << 2];
        System.arraycopy(data, 0, newData, 0, size);

        this.data = newData;
    }

    public int get(int index) {
        checkIndex(index);
        return data[index];
    }

    public void set(int index, int e) {
        checkIndex(index);
        data[index] = e;
    }

    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }

        return false;
    }

    public int indexOf(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }

        return -1;
    }

    public int removeFirst() {
        return remove(0);
    }

    private int removeLast() {
        return remove(size - 1);
    }

    // 只删除第一个
    public void removeElement(int e) {
        int index = indexOf(e);
        if (index != -1) {
            remove(index);
        }
    }

    public int remove(int index) {
        checkIndex(index);
        int rem = data[index];
        System.arraycopy(data, index + 1, data, index, size - index);
        size--;
        return rem;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index must >= 0 and index < " + size);
        }
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
        sb.append(data[size - 1]);
        sb.append("}");
        return sb.toString();
    }
}
