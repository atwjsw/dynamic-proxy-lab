package com.imooc.proxy.cglib;

import java.util.Random;

public class Train {
	
	public void move() {
		
		try {
			System.out.println("火车行驶中。。。。");
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
