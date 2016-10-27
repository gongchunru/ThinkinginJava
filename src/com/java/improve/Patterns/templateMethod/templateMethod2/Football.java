package com.java.improve.Patterns.templateMethod.templateMethod2;

/**
 * Created by gongchunru on 2016/10/27.
 */
public class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football Game initialize");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game startPlay");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game endPlay");
    }
}
