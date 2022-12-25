package com.moon;

import com.moon.util.mock.Student1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!".hashCode());
        System.out.println( ((Integer)42).hashCode());
        System.out.println( ((Integer)(-42)).hashCode());
        System.out.println( ((Double)(3.1415926)).hashCode());
        Student1 student1 = new Student1(1, 1, "hh", "jj");
        System.out.println(student1.hashCode());
    }
}