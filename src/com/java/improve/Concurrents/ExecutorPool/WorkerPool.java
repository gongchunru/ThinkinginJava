package com.java.improve.Concurrents.ExecutorPool;

import java.util.concurrent.*;

/**
 * Created by gongchunru on 2016/9/20.
 * ThreadPoolExecutor线程池的实现示例
 */
public class WorkerPool {
    public static void main(String[] args) throws InterruptedException{
        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2,4,10, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2),threadFactory,rejectionHandler);
        //线程池，休眠时间
        MyMonitorThread monitor = new MyMonitorThread(executorPool,3);
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();

        for (int i = 0; i < 10; i++) {
            executorPool.execute(new WorkerThread("cmd"+i));
        }

        Thread.sleep(30000);

        executorPool.shutdown();

        Thread.sleep(5000);

        monitor.shutdown();

    }
}
