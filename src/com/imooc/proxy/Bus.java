package com.imooc.proxy;

import java.util.Random;

public class Bus implements Drivable {

	@Override
	public void drive() {
		try {
			System.out.println("巴士Driving中。。。。");
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
}
