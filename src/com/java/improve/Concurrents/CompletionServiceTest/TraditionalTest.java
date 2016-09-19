package com.java.improve.Concurrents.CompletionServiceTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by gongchunru on 2016/9/19.
 */
public class TraditionalTest {
    public static void main(String[] args) {
        int taskSize = 5;
        ExecutorService  executorService = Executors.newFixedThreadPool(taskSize);
        List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();

        for (int i = 0; i < taskSize; i++) {
            int sleep = taskSize-1;
            int value = i;
            //向线程池提交任务
            Future<Integer> future = executorService.submit(new ReturnAfterSleepCallable(sleep,value));
            //保留每个任务的future
            futureList.add(future);
        }

        //轮询，获取完成任务的返回结果
        while (taskSize>0){
            for (Future<Integer> future: futureList) {
                Integer result = null;
                try{
                    result = future.get();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }catch (ExecutionException e){
                    e.printStackTrace();
                }
                //任务已经完成
                if (result !=null){
                    System.out.println("result="+result);
                    //从future列表中删除已经完成的任务
                    futureList.remove(future);
                    taskSize--;
                    break;
                }
            }
        }

        //所有任务已经完成，关闭线程池
        System.out.println("all over");
        executorService.shutdown();

    }
}
