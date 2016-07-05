package com.java.improve.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author gongchunru
 * @Package com.java.improve.socket
 * @date 16/6/18 22:13
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8888);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名:tom,密码:456");
            pw.flush();
            socket.shutdownOutput();

            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            if ((info=br.readLine())!=null){
                System.out.println("我是客户端,服务端说:"+info);
            }

            pw.close();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
