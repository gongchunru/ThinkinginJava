package com.java.improve.Patterns.duck;

/**
 * @author gongchunru
 * @Package com.java.improve.Patterns.duck
 * @date 16/9/6 08:55
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Silence");
    }
}
