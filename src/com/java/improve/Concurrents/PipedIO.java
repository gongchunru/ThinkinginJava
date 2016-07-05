package com.java.improve.Concurrents;

import java.io.*;

/**
 * @author gongchunru
 * @Package com.java.improve.Concurrents
 * @date 16/6/13 19:45
 */
//启动程序后将sendFile文件的内容拷贝到receiverFile文件中
public class PipedIO {
    public static void main(String[] args) {
        try {//构造读写的管道流对象
            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream();
            //实现关联
            pos.connect(pis);
            //构造两个线程,并且启动
            new Sender(pos,"/Users/gongchunru/text2.txt").start();
            new Receiver(pis,"/Users/gongchunru/text3.txt").start();

        } catch (IOException e) {
            System.out.println("Pipe Error"+e);
        }


    }
}

class Sender extends Thread{
    PipedOutputStream pos;
    File file;
    //
    Sender(PipedOutputStream pos ,String fileName){
        this.pos = pos;
        file = new File(fileName);
    }

    @Override
    public void run() {
        try {
            //读文件内容
            FileInputStream fs = new FileInputStream(file);
            int data;
            while ((data=fs.read())!=-1){
                //写入管道始端
                pos.write(data);
            }
            pos.close();
        } catch (IOException e) {
            System.out.println("Sender Error"+e);
        }
    }
}

class Receiver extends Thread{
    PipedInputStream pis;
    File file;
    Receiver(PipedInputStream pis,String fileName){
        this.pis = pis;
        file = new File(fileName);
    }

    public void run(){
        try {
            FileOutputStream fs = new FileOutputStream(file);
            int data;
            //从管道末端读
            while ((data=pis.read())!=-1){
                //写入本地文件
                fs.write(data);
            }
            pis.close();
        } catch (IOException e) {
            System.out.println("Receiver Error"+e);
        }
    }
}

