package com.java.TheArtOfJavaConcProgramming.ch4;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gongchunru
 * @Package com.java.TheArtOfJavaConcProgramming.ch4
 * @date 2016/11/15 00:43
 */
public class WaitNotify {
    static boolean floag = true;
    static Object lock = new Object();

    public static void main(String[] args) {

    }

    private static class Wait implements Runnable{
        @Override
        public void run() {
            //加锁拥有lock的Monitor
            synchronized (lock){
                //当条件不满足的时候,继续wait,同时释放了lock的锁
                while (floag){
                    try {
                        System.out.println(Thread.currentThread()+"flag is true, wait"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();//会释放对象的 锁,
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread()+"flag is false .running "+new SimpleDateFormat("HH:mm:ss").format(new Date()));

            }
        }
    }

    static class notify implements Runnable{
        @Override
        public void run() {

        }
    }
}
