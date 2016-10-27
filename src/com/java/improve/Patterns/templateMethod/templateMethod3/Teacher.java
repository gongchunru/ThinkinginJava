package com.java.improve.Patterns.templateMethod.templateMethod3;

/**
 * Created by gongchunru on 2016/10/27.
 */
public class Teacher extends Person {
    @Override
    protected void dressUp() {
        System.out.println("Teacher dressUp");
    }

    @Override
    protected void eatBreakFast() {
        System.out.println("Teacher eatBreakFast");
    }

    @Override
    protected void takeThings() {
        System.out.println("Teacher takeThings");
    }
}
