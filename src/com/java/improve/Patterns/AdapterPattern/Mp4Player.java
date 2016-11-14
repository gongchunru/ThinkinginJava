package com.java.improve.Patterns.AdapterPattern;

/**
 * @author gongchunru
 * @Package com.java.improve.Patterns.AdapterPattern
 * @date 16/9/7 20:39
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name:"+fileName);
    }

    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }
}
