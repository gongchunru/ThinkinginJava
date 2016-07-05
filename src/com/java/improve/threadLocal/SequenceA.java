package com.java.improve.threadLocal;

/**
 * @author gongchunru
 * @Package com.java.improve.threadLocal
 * @date 16/6/12 07:30
 */
public class SequenceA implements Sequence {
    private static int number = 0;

    @Override
    public int getNumber() {
        number = number+1;
        return number;
    }
//输出结果显示,线程之间共享了static变量,这是非线程安全的问题.
    public static void main(String[] args) {
        Sequence sequence = new SequenceA();

        ClientThread thread1 = new ClientThread(sequence);
        ClientThread thread2 = new ClientThread(sequence);
        ClientThread thread3 = new ClientThread(sequence);

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
