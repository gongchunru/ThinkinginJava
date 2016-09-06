package com.java.improve.Patterns.StrategyPatternDemo;

/**
 * @author gongchunru
 * @Package com.java.improve.Patterns.StrategyPatternDemo
 * @date 16/9/4 23:06
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1,int num2){
        return strategy.doOperation(num1,num2);
    }
}
