package com.java.improve.socket.demo2;

import java.io.*;
import java.net.Socket;

/**
 * 服务器线程处理类
 * @author gongchunru
 * @Package com.java.improve.socket.demo2
 * @date 16/6/19 14:14
 */
public class ServerThread  extends Thread {
    //和本线程相关的Socket类
    Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    //线程执行的操作,获取客户端的请求
    @Override
    public void run() {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;

        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info  = null;
            while ((info=br.readLine())!=null){
                System.out.println("我是服务器:客户端说:"+info);
            }
            //关闭输入流
            socket.shutdownInput();

            //获取输出流:响应客户端请求
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎");
            pw.flush();
        } catch (IOException e) {

        }finally {
            try {
                if (pw!=null)
                    pw.close();
                if (os!=null)
                    os.close();
                if (br!=null)
                    br.close();
                if (isr!=null)
                    isr.close();
                if (is!=null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.run();
    }
}
