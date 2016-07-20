package com.java.improve.Patterns.templateMethod;

/**
 * Created by 龚春如 on 2016/7/19.
 */
public class Client  {
    public static void main(String[] args) {
        Account account = new MonyMarketAccount();
        System.out.println("货币市场账号的利息总额是："+account.calculateInterest());
        account = new CDAccount();
        System.out.println("定期账号的利息数额为:"+account.calculateInterest());
    }
}
