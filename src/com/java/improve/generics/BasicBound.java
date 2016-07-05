package com.java.improve.generics;

import java.awt.*;

/**
 * 这里Java重用了extends关键字.边界可以将类型参数的范围限制到一个子集当中.
 * extends 关键字声明中,有两个注意的地方
 *  1. 类必须写在接口之前
 *  2. 只能设置一个类做边界,其他的均为接口
 * @author gongchunru
 * @Package com.java.improve.generics
 * @date 16/5/31 17:31
 */
interface HasColor{
    Color getColor();
}

class Colored<T extends HasColor> {
    T item;
    public Colored(T item){
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public Color color(){
        return item.getColor();
    }
}

class Dimension{
    public int x,y,z;
}

class ColoredDemension<T extends Dimension & HasColor >{
    T item;

    public ColoredDemension(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color color(){
        return item.getColor();
    }

    int getX(){
        return item.x;
    }

    int getY(){
        return item.y;
    }

    int getZ(){
        return item.z;
    }
}

interface Weight{
    int weight();
}

class Solid<T extends Dimension & HasColor & Weight>{
    T item;

    public Solid(T item){
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color color(){
        return item.getColor();
    }

    int getX(){
        return item.x;
    }

    int getY(){
        return item.y;
    }

    int getZ(){
        return item.z;
    }

    int weight(){
        return item.weight();
    }
}

class Bounded extends Dimension implements HasColor,Weight{
    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}

public class BasicBound {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
        solid.color();
        solid.weight();
        solid.getZ();
    }
}

