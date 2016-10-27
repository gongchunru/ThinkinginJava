package com.java.netty.demo.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by gongchunru on 2016/10/17.
 */
public class SimpleChatServer {

    private int port;

    public SimpleChatServer(int port) {
        this.port = port;
    }

    public void run(){
        EventLoopGroup bossGroup = new NioEventLoopGroup();//接收进来的链接
        EventLoopGroup workerGroup = new NioEventLoopGroup();//处理不同的的传输

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new SimpleChatServerInitializer())
                    .option(ChannelOption.SO_BACKLOG,128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true);

            System.out.println("SimpleChatServer启动了");

            //绑定端口，开始接收进来的链接
            ChannelFuture f = b.bind(port).sync();

            //等待服务器 socket关闭
            //在这个例子中，这不会发生，但是可以优雅的关闭服务器
            f.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            System.out.println("SimpleChatServer关闭了");
        }
    }

    public static void main(String[] args) {
        int port;
        if (args.length>0) {
            port = Integer.parseInt(args[0]);
        }else{
            port=8080;
        }
        new SimpleChatServer(port).run();
    }
}
