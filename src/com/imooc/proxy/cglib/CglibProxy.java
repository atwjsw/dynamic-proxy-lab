package com.imooc.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	
	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class clazz) {
		//设置父类，即代理目标
		enhancer.setSuperclass(clazz);
		//传入代理类
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	/*
	 * 拦截所有目标类方法的调用
	 * target: 目标类的实例，
	 * method: 目标类的方法对象
	 * args: 方法的参数
	 * methodProxy: 代理类的实例
	 */
	@Override
	public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		
		System.out.println("日志开始。。。。");	
		//代理类调用父类的方法
		methodProxy.invokeSuper(target, args);	
		System.out.println("日志停止。。。。");	
		return null;
	}

	
}
