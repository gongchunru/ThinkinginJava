package com.java.improve.Patterns.duck;

/**
 * @author gongchunru
 * @Package com.java.improve.Patterns.duck
 * @date 16/9/6 08:57
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm can't fly!");
    }
}
