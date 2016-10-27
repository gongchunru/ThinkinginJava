package com.java.improve.Patterns.templateMethod.templateMethod3;

/**
 * Created by gongchunru on 2016/10/27.
 */
public class Demo {
    public static void main(String[] args) {
        Person person1 = new Student();
        person1.prepare();

        System.out.println();

        Person person2 = new Teacher();
        person2.prepare();
    }
}
