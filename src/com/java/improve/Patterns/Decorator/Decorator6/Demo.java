package com.java.improve.Patterns.Decorator.Decorator6;

/**
 * Created by gongchunru on 2016/10/27.
 */
public class Demo  {
    public static void main(String[] args) {
        TheGreatestSage sage = new Monkey();
        //no.1
        TheGreatestSage bird = new Bird(sage);
        TheGreatestSage fish = new Fish(bird);

        TheGreatestSage bird2 = new Bird(fish);

        fish.move();
    }
}
