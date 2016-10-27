package com.java.improve.Patterns.templateMethod.templateMethod2;

/**
 * Created by gongchunru on 2016/10/27.
 */
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板
    public void play(){
        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
