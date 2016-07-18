package com.java.improve.Concurrents;

/**
 * Created by 龚春如 on 2016/7/9.
 */
public class Volatile extends Object implements Runnable {

    //value 变量没有被标记为volatile
    private int value;

    private volatile boolean missedIt;

    private Long creationTime;

    public Volatile(){
        value = 10;
        missedIt = false;

        creationTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        print("entery run()");

        while (value<20){
            //如果missedIt 的值被修改为true，则通过break退出循环。
            if (missedIt){
                //进入同步代码块之前，将value的值赋值给currValue
                int currValue = value;
                //在要给任意对象上执行同步语句，目的是为了让该线程在进入和离开同步代码块时，
                //将该线程中的所有变量的私有拷贝与共享内存的原始值比较，
                //从而发现没有用volatile 标记的变量所发生的变化。
                Object lock = new Object();
                synchronized (lock){
                    //不做任何事
                }
                //离开同步代码块后，将此事value的值赋值给valueAfterSync
                int valueAfterSync = value;
                print("in run() - see value="+currValue+",but rumor has it that it changed!");
                print("in run() - valueAfterSync=" + valueAfterSync);
                break;
            }
        }
        print("leaving run()");
    }

    public void workMethod() throws InterruptedException{
        print("entering workMethod()");
        print("in workMethod() - about to sleep for 2 seconds");
        Thread.sleep(2000);
        //仅在此改变value 的值
        missedIt = true;
//        value = 50;
        print("in workMethod() - just set value="+value);
        print("in workMethod() - about to sleep for 5 seconds");
        Thread.sleep(5000);
        //仅在此改变missedId的值
//        missedIt = true;
        value = 50;
        print("in workMethod() - just set missedIt=" + missedIt);
        print("in workMethod() - about to sleep for 3 seconds");
        Thread.sleep(3000);
        print("leaving workMethod()");
    }

    //打印msg信息前打印出程序执行到此所化去的时间，以及打印msg代码所在的线程。
    private void print(String msg){
            long interval = System.currentTimeMillis() - creationTime;
            String tmpStr = " " + (interval/1000.0) +"000";
            int pos = tmpStr.indexOf(".");
            String secStr = tmpStr.substring(pos-2,pos+4);
            String nameStr = "        " + Thread.currentThread().getName();
            nameStr = nameStr.substring(nameStr.length()-8,nameStr.length());
            System.out.println(secStr + " "+ nameStr + " " + msg );
    }

    public static void main(String[] args) {
        try{
            //获取实时时钟的当前时间
            Volatile vol = new Volatile();

            //稍微停100ms，以让时钟稍稍超前获取时间，使print()中创建的消息打印的时间大于0
            Thread.sleep(100);

            Thread t = new Thread(vol);
            t.start();

            Thread.sleep(100);

            vol.workMethod();
        }catch (InterruptedException e){
            System.out.println("one of the sleeps was interrupted");
        }
    }

}
