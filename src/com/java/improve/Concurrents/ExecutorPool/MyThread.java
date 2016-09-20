package com.java.improve.Concurrents.ExecutorPool;

/**
 * Created by gongchunru on 2016/9/20.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName()+"正在运行。。");
    }
}
