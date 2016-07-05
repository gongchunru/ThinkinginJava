package com.java.improve.Concurrents;

import java.util.concurrent.CyclicBarrier;

/**
 * @author gongchunru
 * @Package com.java.improve.Concurrents
 * @date 16/6/13 20:20
 */
//等所有线程都达到一个起跑线后才能开始运行
    //这简化了传统的用计数器+wait/notifyAll 来实现该功能的方式
public class CycliBarrierTest implements Runnable{
    private CyclicBarrier barrier;

    public CycliBarrierTest(CyclicBarrier barrier){
        this.barrier = barrier;
    }

    @Override
    public void run() {
        //do xxxx;
        try {
            //线程运行至此会检查是否其他线程都到齐了,没到齐就继续等待
            this.barrier.await();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        //参数2代表两个线程都达到起跑线才开始一起继续往下执行
        CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                //do something
            }
        });
        Thread t1 = new Thread(new CycliBarrierTest(barrier));
        Thread t2 = new Thread(new CycliBarrierTest(barrier));
        t1.start();
        t2.start();

    }
}
