package com.java.improve;

import java.text.SimpleDateFormat;
import java.util.AbstractQueue;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by gongchunru on 2016/9/6.
 */
public class JavaGCworkload {
    static int ThreadNum = 1;
    static int Duration = 300;

    static int ReferenceSize = 1024*10;
    static int countDownSize = 1000*100;
    static int EachRemoveSize = 1000*50;

    public static void main(String[] args) {
        if (args.length>0){
            Duration = Integer.parseInt(args[0]);
            ThreadNum = Integer.parseInt(args[1]);
        }

        for (int i = 0; i < ThreadNum; i++) {
            LoadThread thread = new LoadThread();
            thread.start();
        }
    }
}

class LoadThread extends Thread{
    long timeZero = System.currentTimeMillis();
    long finishedUnit = 0;
    public LoadThread(){

    }

    @Override
    public void run() {
        //有界阻塞队列
        AbstractQueue<String> q = new ArrayBlockingQueue<String>(JavaGCworkload.countDownSize);
        char[] srcArray = new char[JavaGCworkload.ReferenceSize];
        String emptystr = new String(srcArray);
        finishedUnit=0;
        long prevTime = timeZero;

        for (int i = 0;; i=i+1) {
            if (q.size()>=JavaGCworkload.countDownSize){
                String strHuge_remove = null;
                for (int j = 0; j < JavaGCworkload.EachRemoveSize; j++) {
                    strHuge_remove = q.remove();
                }

                finishedUnit ++;
                // every 1000 removal is counted as 1 unit.
                long curTime = System.currentTimeMillis();
                long timeDiff = curTime - prevTime;
                prevTime = curTime;

                long totalTime = curTime - timeZero;

                if (totalTime> JavaGCworkload.Duration * 1000){
                    System.exit(0);
                }
                Date dNow = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println(ft.format(dNow)+"finished Units(1k)="+finishedUnit);
            }

            srcArray = new char[JavaGCworkload.ReferenceSize];
            emptystr = new String(srcArray);

            String str = emptystr.replace('\0','a');
            q.add(str);
        }


    }
}
