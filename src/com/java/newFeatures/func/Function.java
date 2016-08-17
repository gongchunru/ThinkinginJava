package com.java.newFeatures.func;

/**
 * Created by 龚春如 on 2016/7/29.
 * 定义一个函数接口
 */
@FunctionalInterface
public interface Function<T,E> {
    public void apply(T t,E e);
}
