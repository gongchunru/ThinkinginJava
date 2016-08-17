package com.java.improve.Patterns.adapter;

/**
 * Created by 龚春如 on 2016/7/29.
 */
public class TwoPlugAdapterExtends extends GBTwoPlug implements ThreePlugIf {
    @Override
    public void powerWithThree() {
        System.out.println("借助继承适配器");
        this.powerWithTwo();
    }
}
