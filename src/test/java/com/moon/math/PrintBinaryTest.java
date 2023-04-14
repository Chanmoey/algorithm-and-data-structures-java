package com.moon.math;

import org.junit.Test;

/**
 * @author Chanmoey
 * @date 2023年04月14日
 */
public class PrintBinaryTest {

    @Test
    public void testPrintInt() {
        PrintBinary.printIntBinary(0);
        PrintBinary.printIntBinary(1);
        PrintBinary.printIntBinary(Integer.MAX_VALUE);
        PrintBinary.printIntBinary(-1);
        PrintBinary.printIntBinary(Integer.MIN_VALUE);
    }
}
