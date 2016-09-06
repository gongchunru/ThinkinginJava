package com.java.improve.Patterns.duck;

/**
 * @author gongchunru
 * @Package com.java.improve.Patterns.duck
 * @date 16/9/6 08:54
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
