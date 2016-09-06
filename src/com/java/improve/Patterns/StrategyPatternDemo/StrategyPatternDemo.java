package com.java.improve.Patterns.StrategyPatternDemo;

/**
 * @author gongchunru
 * @Package com.java.improve.Patterns.StrategyPatternDemo
 * @date 16/9/4 23:07
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10+5="+context.executeStrategy(10,5));

        context = new Context(new OperationSubstract());
        System.out.println("10-5="+context.executeStrategy(10,5));

        context = new Context(new OperationMultiply());
        System.out.println("10*5="+context.executeStrategy(10,5));
    }
}
