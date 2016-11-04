package com.java.TheArtOfJavaConcProgramming.ch4;

import java.util.concurrent.TimeUnit;

/**
 * Created by gongchunru on 2016/11/4.
 */
public class Shutdown {
    public static void main(String[] args) throws Exception {
        Runner r = new Runner();
        Thread thread = new Thread(r,"countThread");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();

        Runner two = new Runner();
        thread = new Thread(two,"countThread");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancle();
    }


    private static class Runner implements Runnable{

        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
                while (on && !Thread.currentThread().isInterrupted()){
                    i++;
                 }
            System.out.println("Count i="+i);
        }
        public void cancle(){
            on = false;
        }
    }
}
