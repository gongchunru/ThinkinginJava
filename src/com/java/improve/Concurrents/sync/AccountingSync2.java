package com.java.improve.Concurrents.sync;

/**
 * @author gongchunru
 * @Package com.java.improve.Concurrents.sync
 * @date 16/7/4 17:21
 */
public class AccountingSync2 implements Runnable{
    static AccountingSync2 instance = new AccountingSync2();
    static int i = 0;
    public synchronized void increase(){
        i++;
    }

    @Override
    public void run() {
        for (int j=0;j<10000;j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(new AccountingSync2());
//        Thread t2 = new Thread(new AccountingSync2()); 这个会导致数据出问题.不是对同一个对象加锁.

        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
}
