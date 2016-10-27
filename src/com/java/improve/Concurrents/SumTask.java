package com.java.improve.Concurrents;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by gongchunru on 2016/9/21.
 */
public class SumTask extends RecursiveTask{

    private static final long serivalVersionUID = -6196480027075657316L;

    public static final int THRESHOLD = 500000;

    private long[] array;

    private int low;

    private int hight;

    public SumTask(long[] array, int low, int hight) {
        this.array = array;
        this.low = low;
        this.hight = hight;
    }


    @Override
    protected Object compute() {
        int sum = 0;
        if (hight-low<=THRESHOLD){
            //小于阈值则直接计算
            for (int i = low; i < hight; i++) {
                sum+=array[i];
            }
        }else {
            //1. 一个大任务分割成两个小任务
            int mid = (low + hight) >>> 1;
            SumTask left = new SumTask(array,low,mid);
            SumTask right = new SumTask(array,mid+1,hight);

            //2,分别计算
            left.fork();
            right.fork();

            //3.合并结果
            sum = (Integer) left.join() + (Integer) right.join();

        }
        return sum;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long[] array = genArray(100000);
        System.out.println(Arrays.toString(array));

        //1.创建任务
        SumTask sumTask = new SumTask(array,2,array.length-1);

        long begin = System.currentTimeMillis();

        //2,创建线程池
        ForkJoinPool  forkJoinPool = new ForkJoinPool();

        //3.提交任务到线程池
        forkJoinPool.submit(sumTask);
        //4,获取结果
        Integer result = (Integer)sumTask.get();

        long end = System.currentTimeMillis();

        System.out.println(String.format("结果 %s  耗时 %sms",result,end-begin));


    }

    private static long[] genArray(int size){
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = new Random().nextLong();
        }
        return array;
    }
}
