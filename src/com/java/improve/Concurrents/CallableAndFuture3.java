package com.java.improve.Concurrents;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by gongchunru on 2016/9/19.
 * 执行多个带返回值的任务，并取得多个返回值。
 */
public class CallableAndFuture3 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);
//        for (int i = 0; i < 5; i++) {
//            final int taskID = i;
//            cs.submit(new Callable<Integer>() {
//                @Override
//                public Integer call() throws Exception {
//                    return taskID;
//                }
//            });
//        }

//        for (int i = 0; i < 5; i++) {
//            try{
//                System.out.println(cs.take().get());
//            } catch (InterruptedException e){
//                e.printStackTrace();
//            }catch (ExecutionException e){
//                e.printStackTrace();
//            }
//        }

        List<Future<Integer>> list = new ArrayList<>();
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
        for ( int i = 0; i < 5; i++) {
            final int ID = i;
            Future<Integer> future =  threadPool2.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return ID;
                }
            });
            list.add(future);
        }
        for (Future<Integer> future : list) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
