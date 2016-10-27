package com.java.improve.IOTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by gongchunru on 2016/9/28.
 * 客户端通过socket可创建，发送查询时间服务器"QUERY TIME ORDER"指令，读取客户端的响应并打印出来，随后关闭连接，释放资源。
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8099;
        if (args !=null && args.length>0){
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            socket = new Socket("127.0.0.1",port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println("QUERY TIME ORDER");
            System.out.println("Send order 2 server succeed");
            String resp = in.readLine();
            System.out.println("now is :"+resp);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out!=null) {
                out.close();
                out=null;
            }
            if (in!=null) {
                try {
                    in.close();
                    in = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }

    }



}
