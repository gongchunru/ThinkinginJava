package com.java.netty.demo.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * Created by gongchunru on 2016/10/17.
 */
public class SimpleChatServerHandler extends SimpleChannelInboundHandler<String> {

    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 每当从服务端收到新的客户端连接时，客户端的 Channel 存入 ChannelGroup 列表中，并通知列表中的其他客户端 Channel
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        for (Channel channel : channels) {
            channel.writeAndFlush("[SERVER] - "+incoming.remoteAddress() + "加入\n");
        }
        channels.add(ctx.channel());
    }

    /**
     * 每当从服务端收到客户端断开时，客户端的 Channel 移除 ChannelGroup 列表中，并通知列表中的其他客户端 Channel
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        for (Channel channel : channels) {
            channel.writeAndFlush("[SERVER] - "+incoming.remoteAddress() + "离开\n");
        }
        channels.remove(ctx.channel());
    }

    /**
     * 服务端监听到客户端活动
     * @param ctx
     * @throws Exception
     */

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:"+incoming.remoteAddress()+"在线");
    }

    /**
     *  服务端监听到客户端不活动
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:"+incoming.remoteAddress()+"掉线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel incoming = ctx.channel();
        System.out.println("SimpleChatClient:"+incoming.remoteAddress()+"异常");
        //当出现异常就关闭
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 每当从服务端读到客户端写入信息时，将信息转发给其他客户端的 Channel
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel incoming = ctx.channel();
        for (Channel channel : channels) {
            if (channel!=incoming) {
                channel.writeAndFlush("["+incoming.remoteAddress()+"]"+msg+"\n");
            }else {
                channel.write("[you]"+msg+"\n");
            }
        }
    }
}
