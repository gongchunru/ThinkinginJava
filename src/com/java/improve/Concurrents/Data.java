package com.java.improve.Concurrents;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by gongchunru on 2016/9/21.
 */
public class Data {
    private int data;
    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public void set (int data) {
        rwl.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"准备写入数据");
            try{
                Thread.sleep(20);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            this.data = data;
            System.out.println(Thread.currentThread().getName()+"写入"+this.data);
        }finally {
            rwl.writeLock().unlock();
        }
    }

    public void get(int data){
        rwl.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"准备读取数据");
            try{
                Thread.sleep(20);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"读取"+this.data);
        }finally {
            rwl.readLock().unlock();
        }


    }

}
