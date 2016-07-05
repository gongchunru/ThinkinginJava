package com.java.improve.NIODemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * 服务端用单个线程监控一组信道
 * @author gongchunru
 * @Package com.java.improve.NIODemo
 * @date 16/6/14 16:09
 */
public class TCPServerSelector {
    //缓冲区的长度
    private static final  int BUFSIZE = 256;
    //select方法等待信道准备好的最长时间
    private static final int TIMEOUT = 3000;

    public static void main(String[] args) throws IOException{
        if (args.length<1){
            throw new IllegalArgumentException("Parameter(s):<Port>...");
        }
        //创建一个选择器
        Selector selector = Selector.open();
        for (String arg:args){
            //实例化一个信道
            ServerSocketChannel listnChannel = ServerSocketChannel.open();
            //将该信道绑定到指定端口
            listnChannel.socket().bind(new InetSocketAddress(Integer.parseInt(arg)));
            //配置信道为非阻塞模式
            listnChannel.configureBlocking(false);
            //将选择器注册到各个信道
            listnChannel.register(selector, SelectionKey.OP_ACCEPT);
        }
        //创建了一个实现了协议接口的对象
        TCPProtocol protocol = new EchoSelectorProtocol(BUFSIZE);
        //不断轮询select方法,获取准备好的信道所关联的key集
        while (true){
            //一直等待,直到有信道准备好了I/O操作
            if (selector.select(TIMEOUT)==0){
                //在等待信道准备的同时,也可以一步地执行其他任务,
                //这里只简单的打印"."
                System.out.println(".");
                continue;
            }
            //获取准备好的信道所关联的key集合的iterator实例
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            //循环取得集合的每个键值
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                //如果服务端信道感兴趣的I/O操作为accept
                if (key.isAcceptable()){
                    protocol.handleAccept(key);
                }
                //如果客户端信道感兴趣的I/O操作为read
                if (key.isReadable()){
                    protocol.handleRead(key);
                }
                //如果该键值有效,并且其对应的客户端信道感兴趣的I/O操作为write
                if (key.isValid() && key.isWritable()){
                    protocol.handleWrite(key);
                }

                //这里需要手动从键中移动当前的key
                keyIterator.remove();
            }


        }

    }
}
