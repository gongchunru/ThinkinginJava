package com.java.improve.Concurrents;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by gongchunru on 2016/9/19.
 */
public class CallableAndFuture2 {
    public static void main(String[] args) {
        ExecutorService threadPool =  Executors.newSingleThreadExecutor();
        Future<Integer> future = threadPool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        });
            try {
                Thread.sleep(5000);
                System.out.println();
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e){
                e.printStackTrace();
            }
    }
}
