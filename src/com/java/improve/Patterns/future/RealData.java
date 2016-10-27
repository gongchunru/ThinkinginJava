package com.java.improve.Patterns.future;

/**
 * Created by gongchunru on 2016/10/21.
 */
public class RealData implements Data {

    protected final String result;

    public RealData(String s) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 10; i++) {
            sb.append(s);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("RealData.RealData");
        result = sb.toString();
    }

    @Override
    public String getResult() {
        return null;
    }
}
