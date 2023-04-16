package com.moon.classicalalgorithm.binarysearch;

/**
 * @author Chanmoey
 * @date 2022年11月22日
 */
public class BinarySearch {

    private BinarySearch() {
        throw new RuntimeException();
    }

    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int l = 0;
        int r = data.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0) {
                return mid;
            } else if (data[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static <E extends Comparable<E>> int searchR(E[] data, E target) {
        return searchR(data, 0, data.length - 1, target);
    }

    private static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (data[mid].compareTo(target) == 0) {
            return mid;
        } else if (data[mid].compareTo(target) > 0) {
            return searchR(data, l, mid - 1, target);

            // data[mid].compareTo(target) < 0
        } else {

            return searchR(data, mid + 1, r, target);
        }
    }

    /**
     * 找出比target大的最小值的索引
     */
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        int l = 0;
        int r = data.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) > 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 查找target，如果存在target，则返回最大索引，否则返回upper
     */
    public static <E extends Comparable<E>> int ceil(E[] data, E target) {
        int up = upper(data, target);
        return up - 1 >= 0 && data[up - 1].compareTo(target) == 0 ? up - 1 : up;
    }

    /**
     * >= target的最小索引
     */
    public static <E extends Comparable<E>> int lowerCeil(E[] data, E target) {
        int l = 0;
        int r = data.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else if (data[mid].compareTo(target) > 0) {
                r = mid;
            } else {
                // data[mid].compareTo(target) == 0
                while (mid - 1 >= 0 && data[mid - 1].compareTo(target) == 0) {
                    mid--;
                }
                return mid;
            }
        }

        return l;
    }

    /**
     * < target 的最大值
     */
    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int l = -1;
        int r = data.length - 1;
        while (l < r) {
            // **重点**，如果lr相邻，原来的方式会计算出mid的值等于l，而l又被赋值为mid，就进入了死循环。
            // 因此让mid的值等于r
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    /**
     * 查找target
     * 如果存在target，返回最小索引
     * 如果不存在，返回lower
     */
    public static <E extends Comparable<E>> int lowerFloor(E[] data, E target) {
        int low = lower(data, target);
        return low + 1 <= data.length - 1 && data[low + 1].compareTo(target) == 0 ? low + 1 : low;
    }

    /**
     * 查找target
     * 如果存在target，返回最da索引
     * 如果不存在，返回lower
     */
    public static <E extends Comparable<E>> int upperFloor(E[] data, E target) {
        int l = -1;
        int r = data.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid;
            } else if (data[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else {
                // data[mid].compareTo(target) == 0
                while (mid < data.length - 1 && data[mid + 1].compareTo(target) == 0) {
                    mid++;
                }
                return mid;
            }
        }
        return l;
    }
}
