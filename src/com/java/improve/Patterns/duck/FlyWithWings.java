package com.java.improve.Patterns.duck;

/**
 * @author gongchunru
 * @Package com.java.improve.Patterns.duck
 * @date 16/9/6 08:56
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}
