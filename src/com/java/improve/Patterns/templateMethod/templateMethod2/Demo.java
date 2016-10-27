package com.java.improve.Patterns.templateMethod.templateMethod2;

/**
 * Created by gongchunru on 2016/10/27.
 */
public class Demo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();

        System.out.println();
        game = new Football();
        game.play();

    }
}
