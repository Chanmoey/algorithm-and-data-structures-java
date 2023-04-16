package com.moon.classicalalgorithm.util.mock;

/**
 * @author Chanmoey
 * @date 2022年12月25日
 */
public class Student1 {

    private int grade;
    private int cls;
    private String firstName;
    private String lastName;

    public Student1(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int b = 31;
        int hash = 0;
        hash = hash * b + grade;
        hash = hash * b + cls;
        hash = hash * b + firstName.toLowerCase().hashCode();
        hash = hash * b + lastName.toLowerCase().hashCode();
        return hash;
    }


}
