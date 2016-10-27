package com.java.improve.IOTest.AIOTest;

import com.java.improve.IOTest.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by gongchunru on 2016/9/29.
 * //这里详单与是一个伪异步io，创建一个时间服务器的处理类的线程池，
 *
 *
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8099;
        if (args!=null && args.length>0){
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port :"+port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleeExecutor = new TimeServerHandlerExecutePool(50,10000);

            while (true){
                socket = server.accept();
                singleeExecutor.execute(new TimeServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (server!=null) {
                System.out.println("The time server close");
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                server=null;
            }
        }

    }
}
