package com.imooc.proxy.combine;

import com.imooc.proxy.Movable;

public class CarTimeProxy implements Movable{

	public CarTimeProxy(Movable movable) {
		super();
		this.movable = movable;
	}

	private Movable movable;
	
	@Override
	public void move() {
		System.out.println("汽车开动。。。。");		
		long startTime = System.currentTimeMillis();
		movable.move();	
		long endTime = System.currentTimeMillis();
		System.out.println("汽车停止。。。。开动时间： " + (endTime-startTime) + "毫秒");	
	}

}
