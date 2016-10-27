package com.java.improve.Patterns.templateMethod.templateMethod3;

/**
 * Created by gongchunru on 2016/10/27.
 */
public class Student extends Person {
    @Override
    protected void dressUp() {
        System.out.println("Student dressUp");
    }

    @Override
    protected void eatBreakFast() {
        System.out.println("Student eatBreakFast");
    }

    @Override
    protected void takeThings() {
        System.out.println("Student takeThings");
    }
}
