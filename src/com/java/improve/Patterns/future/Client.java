package com.java.improve.Patterns.future;

/**
 * Created by gongchunru on 2016/10/21.
 */
public class Client {
    public Data  request(final String queryStr){
        final FutureData futureData = new FutureData();

        new Thread(){
            public void run(){
                RealData realData = new RealData(queryStr);
                futureData.setResult(realData);
            }
        };
        return futureData;
    }
}
