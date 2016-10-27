package com.java.improve.Patterns.future;

/**
 * Created by gongchunru on 2016/10/21.
 */
public class FutureData implements Data {

    protected RealData realData = null;

    protected boolean isReady = false;

    public synchronized void setResult(RealData realData){
        if (isReady){
            return;
        }
        System.out.println("FutureData.setResult");
        this.realData=realData;
        isReady=true;
        notifyAll();
    }

    @Override
    public synchronized String getResult() {
        while (!isReady){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("FutureData.getResult");
        return realData.result;
    }
}
