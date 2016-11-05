package com.java.test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author gongchunru
 * @Package com.java.test
 * @date 2016/10/31 22:58
 */
public class JMXTest {
    public static void main(String[] args) {
        //获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor和synchronizer 信息,仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);

        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("["+threadInfo.getThreadId() +"]"+threadInfo.getThreadName());
        }
    }
}
