package com.moon.classicalalgorithm.sort.countingsort;

/**
 * @author Chanmoey
 * @date 2022年12月28日
 */
public class CountingSort {

    private CountingSort(){}

    /**
     * 对[l, r]范围的数据进行排序
     *
     * @param data 数据
     * @param l    左边界，包含边界
     * @param r    右边界，包含边界
     */
    public static  void sort(Weight[] data, int l, int r) {
        int n = r - l + 1;
        int[] cnt = new int[n];

        // 计数
        for (Weight e : data) {
            cnt[e.weight() - l]++;
        }

        // index[i]到index[i+1]为cnt[i]的元素最终排序后的位置
        int[] index = new int[n + 1];
        for (int i = 0; i < n; i++) {
            index[i + 1] = index[i] + cnt[i];
        }

        Weight[] temp = new Weight[data.length];
        for (Weight e : data) {
            temp[index[e.weight() - l]] = e;
            index[e.weight() - l]++;
        }

        // 将temp的数据放回data中去
        System.arraycopy(temp, 0, data, 0, data.length);
    }
}
