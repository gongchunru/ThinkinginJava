package com.java.improve.generics;

/**
 * 使用特定的工厂类实现特定的类型能够解决实例化类型参数的问题.
 * @author gongchunru
 * @Package com.java.improve.generics
 * @date 16/5/31 17:05
 */
interface IFactory<T>{
    T create();
}

class Foo2<T>{
    private T x;
    public <F extends IFactory<T>> Foo2(F factory){
        x = factory.create();
    }
}

class IntegerFactory implements IFactory<Integer>{
    @Override
    public Integer create() {
        return new Integer(0);
    }
}

class Widget{
    public static class Factory implements IFactory<Widget>{
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
}
