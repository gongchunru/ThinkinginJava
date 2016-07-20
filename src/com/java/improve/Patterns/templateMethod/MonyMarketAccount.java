package com.java.improve.Patterns.templateMethod;

/**
 * Created by 龚春如 on 2016/7/19.
    具体的模板角色类
 */

public class MonyMarketAccount extends Account {
    @Override
    protected String doCalculateAccountType() {
        return "Money Market";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.045;
    }
}
