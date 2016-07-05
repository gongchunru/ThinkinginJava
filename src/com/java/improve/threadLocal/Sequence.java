package com.java.improve.threadLocal;

/**
 * ThreadLocal其实是一个容器,用于存放线程的局部变量.
 * 一个序列号生成器的程序,可能同时会有多个线程并发访问它,要保证每个线程得到的序列号都是自增的,并且互不干扰
 * @author gongchunru
 * @Package com.java.improve.threadLocal
 * @date 16/6/11 23:36
 */
public interface Sequence {
    int getNumber();
}
