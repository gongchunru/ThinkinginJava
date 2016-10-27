package com.java.improve.Concurrents;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by gongchunru on 2016/9/22.
 */
public class MyTimerTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("Timer task started at:"+new Date());
        completeTask();
        System.out.println("Timer task finished at:"+new Date());
    }

    private void completeTask(){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TimerTask timerTask = new MyTimerTask();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        // 安排指定的任务在指定的时间开始进行重复的固定速率执行。
        timer.scheduleAtFixedRate(timerTask,0,10*1000);
        System.out.println("TimerTask started");

        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timer.cancel();
        System.out.println("cancelled");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
