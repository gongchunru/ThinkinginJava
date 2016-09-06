package com.java.improve.Patterns.StrategyPatternDemo;

/**
 * @author gongchunru
 * @Package com.java.improve.Patterns.StrategyPatternDemo
 * @date 16/9/4 23:04
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1*num2;
    }
}
