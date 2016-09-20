package com.java.improve.Concurrents.ExecutorPool;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by gongchunru on 2016/9/20.
 */
public class TestScheduledThreadPoolExecutor  {
    public static void main(String[] args) {
        ScheduledExecutorService exec = new ScheduledThreadPoolExecutor(1);
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("====");
            }
        },1000,5000, TimeUnit.MILLISECONDS);

        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.nanoTime());
            }
        },1000,2000,TimeUnit.MILLISECONDS);
    }
}
