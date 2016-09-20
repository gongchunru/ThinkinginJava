package com.java.improve.Concurrents.ExecutorPool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by gongchunru on 2016/9/20.
 * ThreadPoolExecutor 提供了一些方法，可以查看执行状态、线程池大小，活动线程数，
 * 此监视器，再固定间隔输出执行信息
 */
public class MyMonitorThread implements Runnable{
    private ThreadPoolExecutor executor;

    private int seconds;

    private boolean run = true;

    public MyMonitorThread(ThreadPoolExecutor executor, int seconds) {
        this.executor = executor;
        this.seconds = seconds;
    }

    public void shutdown(){
        this.run = false;
    }


    @Override
    public void run() {
        while (run){
            System.out.println(
                    String.format("[monitor][%d/%d] Active:%d,completed:%d,Task:%d,isShutdown:%s,isTerminated:%s",
                            this.executor.getPoolSize(),
                            this.executor.getCorePoolSize(),
                            this.executor.getActiveCount(),
                            this.executor.getCompletedTaskCount(),
                            this.executor.getTaskCount(),
                            this.executor.isShutdown(),
                            this.executor.isTerminated())
            );

            try {
                Thread.sleep(seconds*1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
