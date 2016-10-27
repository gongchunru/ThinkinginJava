package com.java.improve.IOTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Created by gongchunru on 2016/9/28.
 * 为构造函数的参数创建一个新的客户端线程处理这条socket链路
 */
public class TimeServerHandler implements Runnable {
    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(),true);
            String currentTime = null;
            String body = null;
            while (true){
                body = in.readLine();
                if (body==null){//如果读取到输入流的尾部，则返回值为null，退出循环。
                    break;
                }
                System.out.println("The time server receiver order :"+body);
                currentTime  = "QUERY TIME ORDER".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
                //发送给客户端，
                out.println(currentTime);
            }
        }catch (IOException e){// 释放输入流、输出流、和socket套接字句柄资源。
            if (in != null){
                try {
                    in.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
            if (out!=null){
                out.close();
                out = null;
            }

            if (this.socket != null){
                try{
                    this.socket.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
                this.socket = null;
            }
            e.printStackTrace();
        }
    }
}
