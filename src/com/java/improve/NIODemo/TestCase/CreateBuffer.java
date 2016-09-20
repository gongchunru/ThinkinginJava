package com.java.improve.NIODemo.TestCase;

import java.nio.ByteBuffer;

/**
 * Created by gongchunru on 2016/9/20.
 */
public class CreateBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put((byte) 'a');
        buffer.put((byte) 'b');
        buffer.put((byte) 'c');
        /*
        反转缓冲区，
        首先将限制设置为当前位置，然后将位置设置为 0
        通常情况下，在准备从缓冲区中读取数据时调用flip方法。
         */
        buffer.flip();

        System.out.println((char)buffer.get());
        System.out.println((char) buffer.get());
        System.out.println((char)buffer.get());
//        System.out.println(buffer.get());
//        System.out.println(buffer.toString());
    }
}
