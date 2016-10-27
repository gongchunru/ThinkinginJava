package com.java.improve.Patterns.templateMethod.templateMethod2;

/**
 * Created by gongchunru on 2016/10/27.
 */
public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket Game initialize");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket game start");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket game endPlay");
    }
}
