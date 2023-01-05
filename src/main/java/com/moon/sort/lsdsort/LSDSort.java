package com.moon.sort.lsdsort;

import java.util.Arrays;

/**
 * @author Chanmoey
 * @date 2023年01月06日
 */
public class LSDSort {

    private LSDSort(){}

    public static void sort(String[] arr, int w) {
        for (String s : arr) {
            if (s.length() != w) {
                throw new IllegalArgumentException("all length of string must be equal w");
            }
        }

        int cSize = 256;
        int[] cnt = new int[cSize];
        String[] temp = new String[arr.length];
        int[] index = new int[cSize + 1];
        for(int r = w - 1; r >= 0; r --){

            // O(n)
            Arrays.fill(cnt, 0);
            for(String s: arr)
                cnt[s.charAt(r)] ++;

            // O(cSize)
            for(int i = 0; i < cSize; i ++)
                index[i + 1] = index[i] + cnt[i];

            // O(n)
            for(String s: arr){
                temp[index[s.charAt(r)]] = s;
                index[s.charAt(r)] ++;
            }

            // O(n)
            System.arraycopy(temp, 0, arr, 0, arr.length);
        }
    }
}
