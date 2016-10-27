package com.java.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;



/**
 * Created by gongchunru on 2016/10/13.
 */
public class TimeServer {
    public void bind(int port) throws Exception{
        //配置服务端的NIO线程组  NioEventLoopGroup是一个线程组，包含了一组NIO线程，专门用于网络事件的处理
        //这里用于服务端接收客户端的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //用于进行SocketChannel的网络读写
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //Netty用于启动nio服务端的辅助启动类，目的是为了降低服务端的开发复杂度。
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChildChannelHandler());//绑定io事件的处理类

            //绑定端口，同步等待成功  主要用于异步操作的通知回调。
            ChannelFuture f = b.bind(port).sync();

            //等待服务端监听端口关闭  进行阻塞，等服务端链路关闭后，main函数才退出。
            f.channel().closeFuture().sync();


        } finally {
            //优雅退出，释放线程池
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{
        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            //TODO
            ch.pipeline().addLast(new TimeServerHandler());
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8089;
        if (args!=null && args.length >0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
            new TimeServer().bind(port);
    }

}


