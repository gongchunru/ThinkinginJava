package com.java.improve.IOTest.AIOTest2;

/**
 * Created by gongchunru on 2016/10/11.
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length>0){
            try {
                port=Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }

        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer,"AIO-AsyncTimeServerHandler-001").start();
    }
}
