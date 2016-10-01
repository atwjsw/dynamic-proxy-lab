package com.imooc.proxy.jdkimpl;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	private Object target;
	
	@Override
	public void invoke(Object o, Method m) {
		try {
			System.out.println("汽车开动。。。。");	
			long startTime = System.currentTimeMillis();
			m.invoke(target);
			long endTime = System.currentTimeMillis();
			System.out.println("汽车停止。。。。开动时间： " + (endTime-startTime) + "毫秒");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
