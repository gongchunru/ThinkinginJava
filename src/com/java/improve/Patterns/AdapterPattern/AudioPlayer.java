package com.java.improve.Patterns.AdapterPattern;

/**
 * @author gongchunru
 * @Package com.java.improve.Patterns.AdapterPattern
 * @date 16/9/7 23:26
 */
public class AudioPlayer implements MediaPlayer {

    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        //播放mp3 音乐文件的内置支持
        if (audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file. Name :"+fileName);
            //mediaAdapter 提供了播放其它文件格式的支持
        }else if (audioType.equalsIgnoreCase("vlc")||audioType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType,fileName);
        }else {
            System.out.println("Invalid media. "+audioType+" format not supported");
        }

    }
}
