package com.java.improve.Patterns.AdapterPattern;

/**
 * @author gongchunru
 * @Package com.java.improve.Patterns.AdapterPattern
 * @date 16/9/7 20:38
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }

    @Override
    public void playVlc(String fileName) {

        System.out.println("playing vlc file. Name"+fileName);

    }
}
