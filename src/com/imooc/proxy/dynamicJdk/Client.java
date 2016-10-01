package com.imooc.proxy.dynamicJdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.imooc.proxy.Bus;
import com.imooc.proxy.Car;
import com.imooc.proxy.Drivable;
import com.imooc.proxy.Movable;

/*
 * 动态代理测试类
 */
public class Client {

	public static void main(String[] args) {
		
		//动态代理，代理目标是Car，代理类是TimeProxy
		/*Car car = new Car();
		InvocationHandler timeHandler = new TimeHandler(car);
		
		Movable movable = (Movable)Proxy.newProxyInstance(car.getClass().getClassLoader(), car.getClass().getInterfaces(), timeHandler);
		movable.move();*/
		
		//动态代理，代理目标是bus，代理类是TimeProxy
		/*Bus bus = new Bus();
		InvocationHandler timeHandler = new TimeHandler(bus);
		
		Drivable drivable = (Drivable)Proxy.newProxyInstance(bus.getClass().getClassLoader(), bus.getClass().getInterfaces(), timeHandler);
		drivable.drive();*/
		
		//动态代理组合
		Car car = new Car();
		InvocationHandler timeHandler = new TimeHandler(car);
		Movable movable1 = (Movable)Proxy.newProxyInstance(car.getClass().getClassLoader(), car.getClass().getInterfaces(), timeHandler);
		System.out.println("代理类名称1：" + movable1.getClass().getName());		
		InvocationHandler logHandler = new LogHandler(movable1);
		Movable movable2 = (Movable)Proxy.newProxyInstance(movable1.getClass().getClassLoader(), movable1.getClass().getInterfaces(), logHandler);
		System.out.println("代理类名称2：" + movable2.getClass().getName());
		movable2.move();
		
	}
}
