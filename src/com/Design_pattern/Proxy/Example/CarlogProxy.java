package com.Design_pattern.Proxy.Example;

public class CarlogProxy implements Moveable{
private Moveable m;
	
	public CarlogProxy(Moveable m) {
		super();
		this.m = m;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		long starttime = System.currentTimeMillis();
		System.out.println("日志开始记录");
		m.move();
		System.out.println("日志结束");
	}
}
