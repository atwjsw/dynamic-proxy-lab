package com.imooc.proxy.dynamicJdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler{
	
	//通过聚合实现代理增强
	public LogHandler(Object target) {
		super();
		this.target = target;
	}
	
	//被代理的对象
	private Object target;

	@Override
	/*
	 * Proxy: 代理类
	 * Method：被代理类被代理的方法
	 * Object[]: 方法的参数
	 * 返回值Object: 方法的返回值
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		//增强的代码. 注意以下代码是通用的，与被代理对象解耦
		System.out.println("日志开始。。。。");							
		//被代理方法的执行
		method.invoke(target);
		//增强的代码		
		System.out.println("日志结束。。。。");	
		return null;
	}

}
