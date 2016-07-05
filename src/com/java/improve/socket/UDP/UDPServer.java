package com.java.improve.socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author gongchunru
 * @Package com.java.improve.socket.UDP
 * @date 16/6/19 16:26
 */
public class UDPServer {


    public static void main(String[] args) throws IOException{
        // 1.创建DatagramSocket
        DatagramSocket datagramSocket = new DatagramSocket(8800);
        // 2.创建数据报
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data,data.length);
        // 3.接收客户端发送的数据
        System.out.println("服务器正在启动,等待接收客户端发送信息...");
        datagramSocket.receive(packet);//此方法会阻塞
        // 4.读取数据
        String info = new String(data,0,packet.getLength());
        System.out.println("我是服务器,客户端说:"+info);

        /*
        向客户端响应数据
         */

        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] data2 = "欢迎您".getBytes();
        //2. 创建数据报包含响应的信息
        DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);

        //3. 响应客户端
        datagramSocket.send(packet2);
        //4. 关闭socket
        datagramSocket.close();


    }
}
