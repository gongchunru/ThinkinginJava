package com.java.improve.Concurrents;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by gongchunru on 2016/9/22.
 */
public class MyTimerTask2 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(),1000L, 2000L);
        //在1秒后执行此任务,每次间隔2秒执行一次,如果传递一个Data参数,就可以在某个固定的时间执行这个任务.

        while (true){
            try {
                int in = System.in.read();
                if (in == 's'){
                    timer.cancel();
                    break;
                }else {
                    System.out.println("重新输入"+in);//会输出两条，因为回车也是的
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }


    static class MyTask extends TimerTask{
        @Override
        public void run() {
            System.out.println("--------------");
        }
    }
}
