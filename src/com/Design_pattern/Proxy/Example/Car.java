package com.Design_pattern.Proxy.Example;

import java.util.Random;

public class Car implements Moveable {

	@Override
	public void move() {
		
		// TODO Auto-generated method stub
		try {
			Thread.sleep(new Random().nextInt(1000));
			System.out.println("汽车正在行驶");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
