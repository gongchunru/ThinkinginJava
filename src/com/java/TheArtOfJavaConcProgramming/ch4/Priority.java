package com.java.TheArtOfJavaConcProgramming.ch4;

import jdk.nashorn.internal.scripts.JO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 4.2
 * Created by 龚春如 on 2016/7/20.
 */
public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws Exception{
        System.out.println("main方法");
        List<Job> jobs = new ArrayList<Job>();
        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "Thread:" + i);
            thread.setPriority(priority);
            thread.start();
        }

        notStart = false;
//        Thread.sleep(3000);
        TimeUnit.SECONDS.sleep(2);

        notEnd = false;
        for (Job job : jobs) {
            System.out.println("Job priority:"+job.priority+",count:"+job.jobCount);
        }
    }

    static class Job implements Runnable{
        private int  priority;
        private long jobCount;

        public Job(int priority) {
            System.out.println("构造方法");
            this.priority = priority;
        }


        @Override
        public void run() {
            System.out.println("run 方法");
            while (notStart){
                Thread.yield();
            }
            while (notEnd){
                Thread.yield();
                jobCount++;
            }
        }
    }

}

