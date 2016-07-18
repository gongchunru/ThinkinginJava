package com.java.improve.Concurrents;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by 龚春如 on 2016/7/10.
 */
public class SemapDemo implements Runnable {
    final Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try{
            semaphore.acquire();//获得一个许可
//            semaphore.acquire(2);//获得两个许可
            //模拟耗时的操作
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId()+":done!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            semaphore.release();//释放一个许可，将其返回给信号量。
//            semaphore.release(2);//释放两个许可，将其返回给信号量。
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemapDemo demo = new SemapDemo();
        for (int i=0;i<20;i++)
            exec.submit(demo);
        exec.shutdown();
    }
}
