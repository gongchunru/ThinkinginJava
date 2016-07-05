package com.java.improve.Concurrents;

import java.util.concurrent.CountDownLatch;

/**
 * @author gongchunru
 * @Package com.java.improve.Concurrents
 * @date 16/6/13 20:16
 */
//启动很多线程,等待通知才能开始
public class CountDownLatchTest2 {
    public static void main(String[] args) {
        final CountDownLatch startLatch = new CountDownLatch(1);//定义了一根门插销

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread("worker Thread"+i){
                @Override
                public void run() {
                    try {
                        startLatch.await();
                    } catch (Exception e) {

                    }
                    //do something
                }
            };
            thread.start();
        }
        startLatch.countDown();//减少一根门插销
    }
}
