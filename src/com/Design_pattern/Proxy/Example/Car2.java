package com.Design_pattern.Proxy.Example;

public class Car2 extends Car{
//通过继承实现
	@Override
	public void move() {
		// TODO Auto-generated method stub
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行驶");
		super.move();
		long endtime = System.currentTimeMillis();
		System.out.println("汽车结束行驶。。。汽车的行驶时间"+(endtime-starttime)+"毫秒");
	}
	
}
