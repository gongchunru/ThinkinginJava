package com.java.improve.NIODemo.ch8;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.*;

/**
 * Created by 龚春如 on 2016/7/20.
 */
public class MultiThreadNIOEchoServer {
    public static Map<Socket,Long> geym_time_stat = new HashMap<Socket, Long>(10240);
    class EchoClient{
        private LinkedList<ByteBuffer>  outq;

        EchoClient(){
            outq = new LinkedList<ByteBuffer>();
        }

        public LinkedList<ByteBuffer> getOutputQueue(){
            return outq;
        }

        public void enqueue(ByteBuffer bb){
            outq.addFirst(bb);
        }
    }
    class HandleMsg implements Runnable{
        SelectionKey sk;
        ByteBuffer bb;
        public HandleMsg(SelectionKey sk,ByteBuffer bb){
            this.sk = sk;
            this.bb = bb;
        }
        @Override
        public void run() {
            EchoClient echoClient = (EchoClient) sk.attachment();
            echoClient.enqueue(bb);
            sk.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
           //强迫selector立即返回
            selector.wakeup();
        }
    }
    private Selector selector;

    private void doWrite(SelectionKey sk){
        SocketChannel channel = (SocketChannel) sk.channel();
        EchoClient echoClient = (EchoClient)sk.attachment();
        LinkedList<ByteBuffer> outq = echoClient.getOutputQueue();

        ByteBuffer bb = outq.getLast();
        try {
            int len = channel.write(bb);
            if (len == -1){
                //disconnect(sk)
                return;
            }
            //如果此缓冲区中剩余元素数 为0
            if (bb.remaining() == 0){
                outq.removeLast();
            }

        } catch (Exception e){
            System.out.println("Failed to write to client.");
            e.printStackTrace();
            //disconnect(sk);
        }
        // if　there is no more data to be written ,remove interst in OP_WRITE
        if (outq.size()==0){
            sk.interestOps(SelectionKey.OP_READ);
        }
    }

    private void disconnect(SelectionKey sk){

    }

    private void doRead(SelectionKey sk){
        SocketChannel channel = (SocketChannel)sk.channel();
        ByteBuffer bb = ByteBuffer.allocate(8192);
        int len;

        try{
            len = channel.read(bb);
            if (len < 0){
                disconnect(sk);
                return;
            }
        }catch (IOException e){
            System.out.println("Failed to read from client");
            e.printStackTrace();
            disconnect(sk);
            return;
        }
        bb.flip();
        tp.execute(new HandleMsg(sk,bb));
    }

    public static void main(String[] args) {
        MultiThreadNIOEchoServer echoServer = new MultiThreadNIOEchoServer();
        try{
//            echoServer.echoServer
        }catch (Exception e){
            System.out.println("Exception e");
            e.printStackTrace();
        }
    }

    private void startServer() throws Exception{
        selector = SelectorProvider.provider().openSelector();

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);

        InetSocketAddress isa = new InetSocketAddress(8000);
        ssc.socket().bind(isa);
        //Register the socket for select events
        SelectionKey acceptKey = ssc.register(selector,SelectionKey.OP_ACCEPT);

        for (;;){
            Set readyKeys = selector.selectedKeys();
            Iterator i = readyKeys.iterator();
            long e = 0;
            while (i.hasNext()){
                SelectionKey sk = (SelectionKey)i.next();
                i.remove();

                if (sk.isAcceptable()){
//                    doAccept(sk);
                }else if (sk.isValid() && sk.isReadable()){
                    if (!geym_time_stat.containsKey(((SocketChannel)sk.channel()).socket())){
                        geym_time_stat.put(((SocketChannel)sk.channel()).socket(),System.currentTimeMillis());
                        doRead(sk);
                    }
                } else if (sk.isValid() && sk.isWritable()){
                    doWrite(sk);
                    e=System.currentTimeMillis();
                    long b = geym_time_stat.remove(((SocketChannel)sk.channel()).socket());
                    System.out.println("spend:"+(e-b)+"ms");
                }
            }
        }
    }



}
