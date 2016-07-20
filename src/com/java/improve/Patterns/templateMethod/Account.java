package com.java.improve.Patterns.templateMethod;

/**
 * Created by 龚春如 on 2016/7/19.
 */
public abstract class Account {
    /**
     * 模板方法模式，计算利息数额
     */

    public final double calculateInterest(){
        double interestRate = doCalculateInterestRate();
        String accountType = doCalculateAccountType();
        double amount = calculateAmount(accountType);

        return amount * interestRate;
    }

    protected abstract String doCalculateAccountType();

    protected abstract double doCalculateInterestRate();

    private double calculateAmount(String accountType){
        return  343.23;
    }
}
