package com.java.improve.socket.demo2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gongchunru
 * @Package com.java.improve.socket.demo2
 * @date 16/6/19 14:29
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务端即将启动,等待客户端的连接...");

            int count = 0;
            while (true){
                Socket socket = serverSocket.accept();
                //创建一个新的线程
                ServerThread serverThread = new ServerThread(socket);

                serverThread.start();
                count++;
                System.out.println("客户端的数量为:"+count);
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("客户端的IP为:"+inetAddress);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
