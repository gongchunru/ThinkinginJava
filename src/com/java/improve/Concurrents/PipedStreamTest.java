package com.java.improve.Concurrents;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 两个线程,一个操作PipedInputStream 一个操作PipedOutputStream ,PipedOutputStream写入的数据先缓存
 * 在Buffer中,如果Buffer满,此线程wait.PipedInputStream 读出Buffer中的数据,如果Buffer没有数据,此线程wait.
 * @author gongchunru
 * @Package com.java.improve.Concurrents
 * @date 16/6/13 13:14
 */
public class PipedStreamTest {
    public static void main(String[] args) {
        PipedOutputStream ops = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream();
        try {
            ops.connect(pis);//实现管道连接
            Producer p = new Producer(ops);
            new Thread(p).start();
            Consumer c = new Consumer(pis);
            new Thread(c).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//生产者
class Producer implements Runnable {
    private PipedOutputStream ops;
    public Producer(PipedOutputStream ops) {
        this.ops = ops;
    }

    @Override
    public void run() {
        try {
            for (;;) {
                ops.write("hell,spell".getBytes());
                ops.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    private PipedInputStream pis;
    public Consumer(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            for (;;){
                byte[] bu = new byte[100];
                int len = pis.read(bu);
                System.out.println(new String(bu,0,len));
                pis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

