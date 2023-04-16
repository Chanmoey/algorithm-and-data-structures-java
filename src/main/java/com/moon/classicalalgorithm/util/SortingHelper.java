package com.moon.classicalalgorithm.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Chanmoey
 */
public class SortingHelper {

    private SortingHelper() {
    }

    public static <E extends Comparable<E>> boolean isSort(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public static boolean isSort(Object[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (((Comparable<Object>)arr[i - 1]).compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public static boolean isReverseSort(Object[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (((Comparable<Object>)arr[i - 1]).compareTo(arr[i]) < 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String clazzPath, String methodName, E[] arr) {
        sortTest(clazzPath, methodName, Comparable[].class, arr);
    }

    public static <E extends Comparable<E>> void sortTest(String clazzPath, String methodName, Class<?> parameterClazz, E[] arr) {
        try {
            Class<?> clazz = Class.forName(clazzPath);
            Method sort = clazz.getDeclaredMethod(methodName, parameterClazz);
            long startTime = System.nanoTime();
            sort.invoke(clazz, (Object) arr);
            long endTime = System.nanoTime();

            if (!isSort(arr)) {
                throw new RuntimeException(clazzPath + "." + methodName + " failed!!!");
            }

            double time = (endTime - startTime) / 1000000000.0;
            System.out.printf("%s, n = %d : %f s%n", clazzPath.substring(clazzPath.lastIndexOf('.') + 1) + "." + methodName, arr.length, time);
            System.out.println();

        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
