package com.java.improve.Patterns.templateMethod;

/**
 * Created by 龚春如 on 2016/7/19.
 *   具体的模板角色类
 */
public class CDAccount extends Account {
    @Override
    protected String doCalculateAccountType() {
        return "Certificate of Deposite";
    }

    @Override
    protected double doCalculateInterestRate() {
        return 0.06;
    }
}
