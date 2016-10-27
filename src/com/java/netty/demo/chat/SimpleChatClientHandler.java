package com.java.netty.demo.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by gongchunru on 2016/10/17.
 */
public class SimpleChatClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }
}
