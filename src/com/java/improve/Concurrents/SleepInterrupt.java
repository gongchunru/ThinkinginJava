package com.java.improve.Concurrents;

/**
 * @author gongchunru
 * @Package com.java.improve.Concurrents
 * @date 16/7/6 19:10
 */
public class SleepInterrupt extends Object implements Runnable {
    @Override
    public void run() {
        System.out.println("in run() - about to sleep for 20 seconds");
        try {
            Thread.sleep(20000);
            System.out.println("in run()-woke up");
        } catch (InterruptedException e) {
            System.out.println("in run() -interrupted while sleeping");
            //处理完方法后,返回到run()方法入口
            //如果没有return,就会打印下面的一句话.
            return;
        }
        System.out.println("in run()-leaving normally");
    }

    public static void main(String[] args) {
        SleepInterrupt si = new SleepInterrupt();
        Thread t  = new Thread(si);
        t.start();
        // 主线程休眠2秒,从而确保刚刚启动的线程有机会执行一段时间.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in main()-interrupting other thread");
        //中断线程
        t.interrupt();
        System.out.println("in main() - leaving");

    }
}
