package com.java.TheArtOfJavaConcProgramming.ch4;

import com.java.TheArtOfJavaConcProgramming.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by gongchunru on 2016/11/4.
 */
public class Interrupted {
    public static void main(String[] args) throws Exception {
        //
        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);
        //
        Thread busyRunner = new Thread(new BusyRunner(),"BusyRunner");
        busyRunner.setDaemon(true);

        sleepThread.start();

        busyRunner.start();

        //休眠10秒，让sleepThread busyRunner 充分运行

        TimeUnit.SECONDS.sleep(5);

        sleepThread.interrupt();
        busyRunner.interrupt();

        System.out.println("sleepThread: "+sleepThread.isInterrupted());
        System.out.println("busyRunner: "+busyRunner.isInterrupted());

        SleepUtils.second(2);

    }


    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while (true){
                SleepUtils.second(10);
            }
        }
    }


    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true){

            }
        }
    }
}
