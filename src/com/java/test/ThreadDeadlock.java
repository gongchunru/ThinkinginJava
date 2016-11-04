package com.java.test;

import org.junit.runner.RunWith;

/**
 * Created by gongchunru on 2016/11/3.
 */
public class ThreadDeadlock {

    public static void main(String[] args) throws InterruptedException {
        Object object1 = new Object();
        Object object2 = new Object();
        Object object3 = new Object();

        Thread t1 = new Thread(new SyncThread(object1,object2),"t1" );
        Thread t2 = new Thread(new SyncThread(object2,object3),"t2" );
        Thread t3 = new Thread(new SyncThread(object3,object1),"t3" );

        t1.start();
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(5000);
        t3.start();
        Thread.sleep(5000);
    }
}

class SyncThread implements Runnable{

    private Object object1;
    private Object object2;

    public SyncThread(Object object1, Object object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" 请求锁 "+object1);

        synchronized (object1){
            System.out.println(name + " 获得锁 "+object1);
            work();
            System.out.println(name + " 请求锁 "+object2);

            synchronized (object2){
                System.out.println(name + " 获得锁 "+object2);
                work();
            }

            System.out.println(name + " 释放锁 "+object2);
        }

        System.out.println(name+"释放锁"+object1);

        System.out.println(name+" the end");
    }

    public  void work(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
