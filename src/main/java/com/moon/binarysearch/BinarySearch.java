package com.moon.binarysearch;

/**
 * @author Chanmoey
 * @date 2022年11月22日
 */
public class BinarySearch {

    private BinarySearch() {
        throw new RuntimeException();
    }

    public static <E extends Comparable<E>> int search(E[] data, E target) {
        return search(data, 0, data.length - 1, target);
    }

    private static <E extends Comparable<E>> int search(E[] data, int l, int r, E target) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (data[mid].compareTo(target) == 0) {
            return mid;
        } else if (data[mid].compareTo(target) > 0) {
            return search(data, l, mid - 1, target);

          // data[mid].compareTo(target) < 0
        } else {

            return search(data, mid + 1, r, target);
        }
    }
}
