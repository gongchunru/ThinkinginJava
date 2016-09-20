package com.java.improve.Concurrents.ExecutorPool;

import com.java.improve.Patterns.adapter.ThreePlugIf;

/**
 * Created by gongchunru on 2016/9/20.
 */
public class WorkerThread implements Runnable {

    private String command;

    public WorkerThread(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Start.Command = "+command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+"End");
    }

    private void processCommand(){
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
