package com.java.improve.Patterns.Decorator;

/**
 * Created by 龚春如 on 2016/7/14.
 */
public class DecoratorMain {
    public static void main(String[] args) {
        Face girFriendFace = new GirlFriend();
        Decorator fenDiFace = new FenDiDecorator();
        Decorator yanXianFace = new YanXianDecorator();
        Decorator otherFace = new OtherDecorator();

        fenDiFace.setFace(girFriendFace);
        yanXianFace.setFace(fenDiFace);
        otherFace.setFace(yanXianFace);

        otherFace.show();
    }
}
