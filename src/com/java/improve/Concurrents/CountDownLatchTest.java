package com.java.improve.Concurrents;

import java.util.concurrent.CountDownLatch;

/**
 * @author gongchunru
 * @Package com.java.improve.Concurrents
 * @date 16/6/13 20:09
 */
//启动线程,然后等到线程结束.即常用的主线程等所有子线程结束后再执行
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        final int count = 10;
        final CountDownLatch completeLatch = new CountDownLatch(count);//定义了门插销

        for (int i = 0; i < count; i++) {
            Thread thread = new Thread("worker thread"+i){
                @Override
                public void run() {
                    completeLatch.countDown();//减少一根门插销
                }
            };
            thread.start();
        }
        completeLatch.await();//如果插销还没有减完则等待.
    }
}
