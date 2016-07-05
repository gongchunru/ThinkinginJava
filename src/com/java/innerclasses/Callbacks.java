package com.java.innerclasses;

/**
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/29 10:27
 */
interface Incrementable{
    void increment();
}
//这是最简单的解决方法
class Callee1 implements Incrementable{
    private int i = 0;
    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement{
    public void increment(){
        System.out.println("Other operation");
    }
    static void f(MyIncrement mi){
        mi.increment();
    }
}

class Callee2 extends MyIncrement{
    private int i = 0;
    public void increment(){ //此处的方法和Incrementable的increment()完全不同,因此,只能内部类来实现该方法.
        super.increment();
        i++;
        System.out.println(i);
    }

    private class Closure implements Incrementable{//内部类来实现该方法.
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }

    Incrementable getCallbackReference(){
        return new Closure();
    }
}

class Caller {
    private Incrementable callbackReference;
    Caller(Incrementable cbh){callbackReference = cbh;}
    void go(){callbackReference.increment();}
}

public class Callbacks {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);

        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();

    }
}
