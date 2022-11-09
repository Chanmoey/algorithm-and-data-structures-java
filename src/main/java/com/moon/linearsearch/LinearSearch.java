package com.moon.linearsearch;

/**
 * @author Chanmoey
 */
public class LinearSearch {

    private LinearSearch() throws Exception {
        throw new Exception();
    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }
}
