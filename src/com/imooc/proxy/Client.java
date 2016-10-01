package com.imooc.proxy;

public class Client {

	public static void main(String[] args) {
		
		//普通运行方式
		//Movable movable = new Car();
		//movable.move();
		
		//继承方式实现Proxy的调用测试
		//Movable movable = new CarProxyInheritence();
		//movable.move();
		
		//聚合方式实现Proxy的调用测试
		Movable movable = new CarProxyByAssociation(new Car());
		movable.move();
	}

}
