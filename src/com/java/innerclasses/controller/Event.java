package com.java.innerclasses.controller;

/**
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/29 10:58
 */
public abstract class Event{
    private long eventTime;
    protected final long delayTime;
    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start(){
        eventTime = System.nanoTime()+delayTime;
    }

    public boolean ready(){
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();
}
