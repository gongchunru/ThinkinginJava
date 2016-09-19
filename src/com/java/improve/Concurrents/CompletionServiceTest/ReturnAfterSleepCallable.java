package com.java.improve.Concurrents.CompletionServiceTest;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by gongchunru on 2016/9/19.
 */
public class ReturnAfterSleepCallable implements Callable<Integer> {
    private int sleepSeconds;
    private int returnValue;

    public ReturnAfterSleepCallable(int sleepSeconds, int returnValue) {
        this.sleepSeconds = sleepSeconds;
        this.returnValue = returnValue;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("begin to execute");
        TimeUnit.SECONDS.sleep(sleepSeconds);
        return returnValue;
    }
}
