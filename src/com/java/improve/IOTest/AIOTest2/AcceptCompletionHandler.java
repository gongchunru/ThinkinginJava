package com.java.improve.IOTest.AIOTest2;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 通过AcceptCompletionHandler 实例作为handler接收accept操作成功的通知消息
 * Created by gongchunru on 2016/10/11.
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel,AsyncTimeServerHandler> {
    @Override
    public void completed(AsynchronousSocketChannel result,AsyncTimeServerHandler  attachment) {
        attachment.asynchronousServerSocketChannel.accept(attachment,this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer,buffer,new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }
}
