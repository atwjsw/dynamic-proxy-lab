package com.imooc.proxy;
/*
 * 通过继承方向实现静态Proxy，来记录开动时间 
 * 继承方式在实现代理叠加时不灵活，一般使用聚合方式。
 */
public class CarProxyByAssociation implements Movable {

	private Car car;
	
	@Override
	public void move() {
		
		System.out.println("汽车开动。。。。");		
		long startTime = System.currentTimeMillis();
		car.move();	
		long endTime = System.currentTimeMillis();
		System.out.println("汽车停止。。。。开动时间： " + (endTime-startTime) + "毫秒");	
		
	}

	public CarProxyByAssociation(Car car) {
		super();
		this.car = car;
	}

}
