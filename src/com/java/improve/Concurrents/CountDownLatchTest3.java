package com.java.improve.Concurrents;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 龚春如 on 2016/7/10.
 */
public class CountDownLatchTest3 implements Runnable {
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchTest3 test = new CountDownLatchTest3();
    @Override
    public void run() {
        try{
            //模拟检查任务
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println(Thread.currentThread().getName()+" check complete!");
            end.countDown();//执行完毕减一操作。
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i=0;i<10;i++){
            exec.submit(test);
        }
        //等待检查
        end.await();
        System.out.println("Fire!");
        exec.shutdown();
    }
}
