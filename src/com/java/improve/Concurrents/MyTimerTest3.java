package com.java.improve.Concurrents;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by gongchunru on 2016/9/22.
 */
public class MyTimerTest3 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        MyTask myTask1 = new MyTask();
        MyTask myTask2 = new MyTask();
        myTask2.setInfo("myTask-info-2");

        timer.schedule(myTask1,1000,2000);
        timer.scheduleAtFixedRate(myTask2,2000,3000);//任务2，2秒后开始进行重复的固定频率的执行（3秒中一次）

        while (true){
            try{
                byte[] info = new  byte[1024];
                int len = System.in.read();

                String strInfo = new String(info,0,len,"GBK");
                if (strInfo.charAt(strInfo.length()-1) == ' '){
                    strInfo = strInfo.substring(0,strInfo.length()-2);
                }

                if (strInfo.startsWith("Cancel-1")){
                    myTask1.cancel();
                }else if (strInfo.startsWith("Cancel-2")){
                    myTask2.cancel();
                }else if (strInfo.startsWith("Cancel-All")){
                    timer.cancel();
                    break;
                }else {
                    myTask1.setInfo(strInfo);
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    static class MyTask extends TimerTask{
        String info = "INFO";

        @Override
        public void run() {
            System.out.println(new Date()+"    "+info);
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
}
