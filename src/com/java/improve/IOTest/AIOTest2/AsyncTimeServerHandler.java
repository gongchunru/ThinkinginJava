package com.java.improve.IOTest.AIOTest2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * 异步的时间服务器处理类
 * Created by gongchunru on 2016/10/11.
 */
public class AsyncTimeServerHandler implements Runnable {

    private int port;

    CountDownLatch latch;
    AsynchronousServerSocketChannel asynchronousServerSocketChannel;


    public AsyncTimeServerHandler(int port) {
        this.port = port;
        try {
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("The time server is start in port:"+port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //作用是：完成一组正在操作执行的操作之前，允许当前线程一直阻塞，
        //现在让此线程阻塞，防止服务端执行完成后退出
        latch = new CountDownLatch(1);
        doAccept();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doAccept(){
        //接收客户端的连接，可以传递一个 handler实例接收accept操作成功的通知消息。
        asynchronousServerSocketChannel.accept(this,new AcceptCompletionHandler());
    }
}
