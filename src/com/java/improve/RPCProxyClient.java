package com.java.improve;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by gongchunru on 2016/9/15.
 */
public class RPCProxyClient implements InvocationHandler {

    private Object object;

    private RPCProxyClient(){
        this.object = object;
    }

    public static Object getProxy(Object object){
       return java.lang.reflect.Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),new RPCProxyClient());
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = new Object();
        return result;
    }
}
