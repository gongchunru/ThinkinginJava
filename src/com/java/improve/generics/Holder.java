package com.java.improve.generics;

/**
 * 协变:
 * 在Java中父类型可以持有子类型,如果一个父类型的容器可以持有子类型的容器,那么
 * 我们就可以称为发生了协变.在Java中,数组是自带协变的,但是范型容器没有自带协变
 * 我们可以根据利用边界和通配符?来实现近似的协变.
 *
 * Holder<? extends Fruit> </> 就是协变的写法.它表示一个列表,列表持有的类是
 * Fruit或者其子类.
 *
 * 这个 Holder<? extends Fruit> 运行时持有的类型是未知的,我们只知道它一定是Fruit类的子类
 * 正因为如此,我们无法向这个holder中放入任何类型的对象,Object类型的对象也不可以.
 * 但是,调用它的返回方法却是可以的.因为边界明确定义了它是Fruit类型的子类.
 * @author gongchunru
 * @Package com.java.improve.generics
 * @date 16/5/31 18:41
 */
public class Holder<T> {
    private T value;

    public Holder(T apple){
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        return value != null && value.equals(o);
    }

    public static void main(String[] args) {
        Holder<Apple> appleHolder = new Holder<Apple>(new Apple());
        Apple d = new Apple();
        appleHolder.setValue(d);
        //不能自动协变
//        Holder<Fruit> fruitHolder = appleHolder;
        //借助?通配符和extends关键字可以实现协变
        Holder<? extends Fruit> fruitHolder = appleHolder;
        //返回一个Fruit,因为添加边界以后返回的对象是 ? extends Fruit
        //可以把它转型为Apple,但是在不知道具体类型的时候存在风险.
        d = (Apple)fruitHolder.getValue();

        //Fruit以及Fruit的父类,就不需要转型.
        Fruit fruit = fruitHolder.getValue();
        Object obj = fruitHolder.getValue();

        try {
            Orange c = (Orange) fruitHolder.getValue();
        } catch (Exception e) {
            System.out.println(e);
        }
        //编译不通过,因为编译阶段根本不知道子类型到底是什么类型
//        fruitHolder.setValue(new Apple());
//        fruitHolder.setValue(new Orange());
//这里是可以的因为equals方法接受的是object作为参数,并不是:? extends Fruit
        System.out.println(fruitHolder.equals(d));
    }

}
