package com.java.innerclasses;

import org.ietf.jgss.GSSManager;

/**
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/27 18:05
 */

interface Game{boolean move();}
interface GameFactory{Game getGame();}

class Checkers implements Game{
    private Checkers(){}
    private int moves = 0;
    private static final int MOVES = 3;

    @Override
    public boolean move() {
        System.out.println("checkers movers "+moves);
        return ++moves != MOVES;
    }

    public static GameFactory factory = new GameFactory() {
        @Override
        public Game getGame() {
            return new Checkers();
        }
    };
}
class Chess implements Game{
    private Chess(){}
    private int moves = 0;
    private static final int MOVES = 4;
    @Override
    public boolean move() {
        System.out.println("Chess move "+moves);
        return ++moves!=MOVES;
    }
    public static GameFactory factory = new GameFactory() {
        @Override
        public Game getGame() {
            return new Chess();
        }
    };
}

public class Games {
    public static void playGame(GameFactory factory){
        Game s = factory.getGame();
        while (s.move())
            ;
    }

    public static void main(String[] args) {
        playGame(Checkers.factory);
        playGame(Chess.factory);
    }
}
