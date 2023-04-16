package com.moon.classicalalgorithm.util;

import java.lang.reflect.Method;

/**
 * @author Chanmoey
 * @date 2022年12月29日
 */
public class StringMatchHelper {

    private StringMatchHelper() {

    }


    public static void matchTest(String clazz, String method, String s, String t) {

        try {
            int pos = -1;
            Class<?> clz = Class.forName(clazz);
            Method mtd = clz.getDeclaredMethod(method, String.class, String.class);

            long startTime = System.nanoTime();
            pos = (int) mtd.invoke(clz, s, t);
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;

            System.out.println(clazz + "." + method + ": res = " + pos + ", time = " + time + "s");

            if (s.indexOf(t) != pos) {
                throw new RuntimeException(clazz + "." + method + "匹配失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
