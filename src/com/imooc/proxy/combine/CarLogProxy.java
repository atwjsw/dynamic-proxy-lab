package com.imooc.proxy.combine;

import com.imooc.proxy.Movable;

public class CarLogProxy implements Movable{

	public CarLogProxy(Movable movable) {
		super();
		this.movable = movable;
	}

	private Movable movable;
	
	@Override
	public void move() {
		System.out.println("日志开始。。。。");			
		movable.move();			
		System.out.println("日志停止。。。。");	
	}

}
