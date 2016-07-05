package com.java.improve.socket;

import com.java.chapter14.net.mindview.util.Print;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gongchunru
 * @Package com.java.improve.socket
 * @date 16/6/18 22:13
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务端准备接受信息...");
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String info  = null;
            while ((info=br.readLine())!=null){
                System.out.println("我是服务器:客户端说:"+info);
            }
            //关闭输入流
            socket.shutdownInput();

            //获取输出流:响应客户端请求
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("欢迎");
            pw.flush();

            pw.close();


            br.close();
            isr.close();
            is.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
