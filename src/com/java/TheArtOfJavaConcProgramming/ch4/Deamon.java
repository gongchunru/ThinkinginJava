package com.java.TheArtOfJavaConcProgramming.ch4;

import com.java.TheArtOfJavaConcProgramming.SleepUtils;

/**
 * @author gongchunru
 * @Package com.java.TheArtOfJavaConcProgramming.ch4
 * @date 2016/11/15 00:42
 */
public class Deamon {

    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }


    static class DaemonRunner implements Runnable{
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            }finally {
                System.out.println("finally");
            }
        }
    }

}
