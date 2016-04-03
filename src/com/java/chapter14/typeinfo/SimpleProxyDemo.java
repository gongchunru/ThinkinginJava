package com.java.chapter14.typeinfo;

import static com.java.chapter14.net.mindview.util.Print.*;

interface Interface{
	void doSomething();
	void somethingElse(String arg);
}

class RealObject implements Interface{

	@Override
	public void doSomething() {
		print("doSomething");
	}

	@Override
	public void somethingElse(String arg) {
		print("somethingElse "+arg);
	}
}

class SimpleProxy implements Interface{
	private Interface proxied;
	public SimpleProxy(Interface proxied){
		this.proxied = proxied;
	}
	@Override
	public void doSomething() {
		print("SimpleProxy doSomething ");
		proxied.doSomething();
	}
	@Override
	public void somethingElse(String arg) {
		print("SimpleProxy somethingElse " +arg);
	}
}

public class SimpleProxyDemo {
	
	public static void customer(Interface iface){
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	
	public static void main(String[] args) {
		customer(new RealObject());
		customer(new SimpleProxy(new RealObject()));
	}

}
