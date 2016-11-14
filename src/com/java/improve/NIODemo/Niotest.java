package com.java.improve.NIODemo;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author gongchunru
 * @Package com.java.improve.NIODemo
 * @date 2016/9/25 19:20
 */
public class Niotest {
    public static void main(String[] args) {
        try {

            RandomAccessFile aFile = new RandomAccessFile("","rw");
            FileChannel fileChannel = aFile.getChannel();

            //buffer
            ByteBuffer buf = ByteBuffer.allocate(48);
            while (fileChannel.read(buf) !=-1){
                buf.flip();//写模式切换成读模式
                while (buf.hasRemaining()){
                    System.out.println(buf.get());
                }
                buf.clear();//所有剩余的数据都情况
            }
            aFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
