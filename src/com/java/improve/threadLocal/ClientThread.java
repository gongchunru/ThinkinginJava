package com.java.improve.threadLocal;

/**
 * @author gongchunru
 * @Package com.java.improve.threadLocal
 * @date 16/6/12 07:26
 */
public class ClientThread extends Thread {

    private Sequence sequence;

    public ClientThread(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+"==>"+sequence.getNumber());
        }
    }
}
