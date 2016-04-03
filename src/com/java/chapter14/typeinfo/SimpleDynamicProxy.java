package com.java.chapter14.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler{
	private Object proxied;
	
	public DynamicProxyHandler(Object proxied){
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("*** proxy: " + proxy.getClass() + ";method:" + method + "; args" + args);
		if (args != null) {
			for(Object arg:args){
				System.out.println( "  "+arg);
			}
		}
		return method.invoke(proxied, args);
	}
}

public class SimpleDynamicProxy {
	
	public static void consumer(Interface iface){
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	
	/**
	 *  通过调用静态方法：newProxyInstance() 可以创建动态代理，这个方法需要得到：
	 *  	一个类加载器（你通常可以从已经被加载的对象中获取其类加载器，然后传递给他），
	 *  	一个你希望该代理实现的接口列表（不是抽象类或者类），
	 *  	以及InvocationHandler接口的一个实现。
	 *  
	 *  动态代理可以将所有调用重定向到调用处理器，因此通常会向调用处理器的构造器传递一个“实际”对象的引用，
	 *  从而使得调用处理器在执行其中介任务时，可以将请求转发。
	 *  
	 *  
	
	 */
	
	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);
		//insert a proxy and call again
		Interface proxy = (Interface)Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(real));
		consumer(proxy);
	}
	


}
