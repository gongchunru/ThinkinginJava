package com.java.innerclasses;

/**
 * 内部类自动拥有对其外围类所有成员的访问权..
 * 当某个外围类的对象创建了一个内部类对象时,
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/17 16:46
 */

interface Selector{
    boolean end();
    Object current();
    void next();
}

public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x){
        if (next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector implements Selector{
        private int i = 0;
        @Override
        public Object current() { return items[i]; }

        @Override
        public boolean end() {return i== items.length; }

        @Override
        public void next() { if (i<items.length) i++;}
    }

    //生成一个内部类对象
    public Selector selector(){
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        //要获取Sequence中的每一个对象,可以使用Selector接口.这是“迭代器模式”.
        Selector selector = sequence.selector();
        while (!selector.end()){
            System.out.println(selector.current()+"");
            selector.next();
        }
    }

}
