package com.java.improve.IOTest.NIOTest;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by gongchunru on 2016/9/30.
 */
public class MultiplexerTimeServer implements Runnable{

    private Selector selector;

    private ServerSocketChannel servChannel;

    private volatile boolean stop;

    /**
     * 初始化多路复用器，绑定监听端口
     */

    public MultiplexerTimeServer(int port){
        try {
            //创建多路复用器
            selector = Selector.open();
            //1. 打开ServerSocketChannel 用于监听客户端的连接，他是所有客户端连接的父管道。
            servChannel = ServerSocketChannel.open();
            //2. 绑定端口，设置为非阻塞模式
            servChannel.configureBlocking(false);
            servChannel.socket().bind(new InetSocketAddress(port),1024);
            //3. 将ServerSocketChannel 注册到多路复用器selector上，监听accept事件，
            servChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port:"+port);


        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        this.stop = true;
    }




    @Override
    public void run() {
        while (!stop){
            try {
                //休眠时间是一秒，无论是否有读写发生，selector每隔1s都被唤醒一次，
                selector.select(1000);
//                selector.select();//当有就绪状态的channel时，selector就返回就绪状态的channel的SelectionKey 集合。
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()){
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (IOException e) {
                        if (key!=null){
                            key.cancel();
                            if (key.channel()!=null) {
                                key.channel().close();
                            }
                        }
                        e.printStackTrace();
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //多路复用器关闭以后，所有注册在上面的Channel 和Pipe等资源会被自动去注册并关闭，所以不需要释放资源。

        if (selector !=null){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException{
        if (key.isValid()) {
            //处理新接入的请求信息
            if (key.isAcceptable()) {
                ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
                SocketChannel sc = ssc.accept();//连接客户端的请求，相当于完成了TCP的三次握手。
                sc.configureBlocking(false);

                sc.register(selector ,SelectionKey.OP_READ);
            }

            if (key.isReadable()) {
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);//开辟1K的缓冲区，
                int readBytes = sc.read(readBuffer);//读取请求码流。非阻塞的。 返回值等于-1 链路已经关闭，需要关闭SocketChannel 释放资源。=0 没有读取到字节，属于正常场景。

                if (readBytes>0) {
                    readBuffer.flip();// 将当前的limit设置为position，position设置为0， 用于后续对缓冲区的读取操作。
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes,"UTF-8");
                    System.out.println("The time server receive order:"+body);
                    String currenTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
                    doWrite(sc,currenTime);

                }else if (readBytes<0){
                    //对链路关闭
                    key.cancel();
                    sc.close();
                }else{

                }

            }
        }
    }


    private void doWrite(SocketChannel channel,String response) throws IOException{
        if (response !=null && response.trim().length()>0) {
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }

}
