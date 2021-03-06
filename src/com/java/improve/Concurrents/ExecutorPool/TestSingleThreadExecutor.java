package com.java.improve.Concurrents.ExecutorPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gongchunru on 2016/9/20.
 */
public class TestSingleThreadExecutor {
    public static void main(String[] args) {
        //
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();

        //将线程放入线程池执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        //关闭线程池
        pool.shutdown();

    }
}
