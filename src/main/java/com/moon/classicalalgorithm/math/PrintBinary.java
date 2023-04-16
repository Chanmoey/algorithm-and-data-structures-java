package com.moon.classicalalgorithm.math;

/**
 * @author Chanmoey
 * @date 2023年04月14日
 */
public class PrintBinary {

    private PrintBinary(){}

    public static void printIntBinary(int num) {
        System.out.print(num + ": ");
        for (int i = 31; i >= 0; i--) {
            System.out.print((num >> i) & 1);
        }
        System.out.println();
    }
}
