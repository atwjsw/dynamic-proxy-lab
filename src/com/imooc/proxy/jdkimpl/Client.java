package com.imooc.proxy.jdkimpl;

import com.imooc.proxy.Car;
import com.imooc.proxy.Movable;


public class Client {
	
	public static void main(String[] args) throws Exception {
		//Proxy.newProxyInstance(Movable.class);
		InvocationHandler timeHandler = new TimeHandler(new Car());
		Movable movable = (Movable)Proxy.newProxyInstance(Movable.class, timeHandler);
		System.out.println(movable.getClass().getName());
		movable.move();
		//Proxy.newProxyInstance(Drivable.class);
		
	}
}
