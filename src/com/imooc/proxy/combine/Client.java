package com.imooc.proxy.combine;

import com.imooc.proxy.Car;
import com.imooc.proxy.Movable;

/*
 * 静态代理叠加的测试类 
 * 
 */
public class Client {

	public static void main(String[] args) {
		
		Car car = new Car();
		
		//先日志后计时
		/*Movable movable1 = new CarTimeProxy(car);
		Movable movable2 = new CarLogProxy(movable1);
		movable2.move();*/
		
		//先计时后日志. 通过聚合实现的Proxy可以很灵活的组合，实现功能的叠加
		Movable movable3 = new CarLogProxy(car);
		Movable movable4 = new CarTimeProxy(movable3);
		movable4.move();
	}

}
