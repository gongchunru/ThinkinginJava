package com.java.improve.Concurrents;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 龚春如 on 2016/7/10.
 */
public class ReentrantLock1 implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;
    @Override
    public void run() {
        for (int j=0;j<1000000;j++){
            lock.lock();
            lock.lock();
            try{
                i++;
            }finally {
                lock.unlock();
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock1 rl = new ReentrantLock1();
        Thread t1 = new Thread(rl);
        Thread t2 = new Thread(rl);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }

}
