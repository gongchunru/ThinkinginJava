package com.java.improve.IOTest.AIOTest2;

import sun.util.cldr.CLDRLocaleDataMetaInfo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * Created by gongchunru on 2016/10/12.
 */
public class AsyncTimeClientHandler implements CompletionHandler<Void,AsyncTimeClientHandler>,Runnable {

    private AsynchronousSocketChannel client;

    private String host;

    private int port;

    private CountDownLatch latch;

    public AsyncTimeClientHandler(String host,int port){
        this.host = host;
        this.port = port;
        try {
            client=AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //创建CountDownLatch 进行等等，防止异步操作没有执行完线程就退出。
        latch = new CountDownLatch(1);
        //参数：1.SocketAddress ，
        //2. A attachment  ，用于回调通知时作为入参被传递，调用者可以自定义
        //3. CompletionHandler<Void? super A> handler ：异步操作回调通知接口，由调用者实现。
        client.connect(new InetSocketAddress(host,port),this,this);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //异步连接成功后的方法回调。
    @Override
    public void completed(Void result, AsyncTimeClientHandler attachment) {
        byte[] req = "QUERY TIME ORDER".getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();
        //调用write方法进行异步写
        client.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override//写操作完成后的回调
            public void completed(Integer result, ByteBuffer buffer) {
                if (buffer.hasRemaining()){//如果发送缓冲区仍有尚未发送的字节，将继续异步发送，如果已经发送完成，则执行异步读取操作
                    client.write(buffer,buffer,this);
                }else {
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    //异步读取服务端的响应信息
                    client.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer buffer1) {
                            buffer1.flip();
                            byte[] bytes = new byte[buffer1.remaining()];
                            buffer1.get(bytes);
                            String body;
                            try {
                                body = new String(bytes,"UTF-8");
                                System.out.println("Now is:"+body);
                                latch.countDown();
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer buffer1) {
                            try {
                                client.close();
                                latch.countDown();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    client.close();
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
        exc.printStackTrace();

        try {
            client.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
