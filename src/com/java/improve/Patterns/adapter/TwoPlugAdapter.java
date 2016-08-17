package com.java.improve.Patterns.adapter;

/**
 * Created by 龚春如 on 2016/7/29.
 */
public class TwoPlugAdapter implements ThreePlugIf{
    private GBTwoPlug plug;

    public TwoPlugAdapter(GBTwoPlug plug) {
        this.plug = plug;
    }

    @Override
    public void powerWithThree() {
        System.out.println("通过转换");
        plug.powerWithTwo();
    }
}
