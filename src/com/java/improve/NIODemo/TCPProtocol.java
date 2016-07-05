package com.java.improve.NIODemo;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 *
 * @author gongchunru
 * @Package com.java.improve.NIODemo
 * @date 16/6/14 13:11
 */
public interface TCPProtocol {
    //accept I/O形式
    void handleAccept(SelectionKey key) throws IOException;
    //读 I/O形式
    void handleRead(SelectionKey key) throws IOException;
    //write I/O形式
    void handleWrite(SelectionKey key) throws IOException;


}
