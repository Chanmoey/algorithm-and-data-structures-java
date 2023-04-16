package com.moon.classicalalgorithm.array;

/**
 * @author Chanmoey
 * @date 2023年04月13日
 */
public class FastArray<E> extends Array<E> {

    /**
     * 如果插入中间位置，则将原来的元素移到尾部，再将e放在idx的位置
     * @param idx idx
     * @param e e
     */
    public void addWithSwitch(int idx, E e) {
        if (idx < 0 || idx > getSize()) {
            throw new IndexOutOfBoundsException("index must >= 0 and index <= " + getSize());
        }
        if (idx == getSize()) {
            addLast(e);
        } else {
            E idxE = get(idx);
            set(idx, e);
            addLast(idxE);
        }
    }

    /**
     * 将待删除元素与末尾元素交换，然后删除末尾元素
     * @param idx idx
     * @return removed value
     */
    public E removeWithSwitch(int idx) {
        checkIndex(idx);
        if (idx != getSize() - 1) {
            E last = getLast();
            set(idx, last);
        }
        return removeLast();
    }

    /**
     * 删除的时候，只是先标记，不会真正删除，等到空间不够了，再进行整理
     * 想象一下：标记清除算法
     * @param idx idx
     * @return remove value
     */
    public E removeWithMark(int idx) {
       throw new RuntimeException("没实现");
    }
}
