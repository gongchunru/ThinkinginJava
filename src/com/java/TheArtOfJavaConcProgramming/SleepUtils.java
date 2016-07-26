package com.java.TheArtOfJavaConcProgramming;

import java.util.concurrent.TimeUnit;

/**
 * Created by 龚春如 on 2016/7/21.
 */
public class SleepUtils {
    public static final void second(long seconds){
       try{
           TimeUnit.SECONDS.sleep(seconds);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
    }
}
