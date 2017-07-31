package com.Design_pattern.Proxy.Example;

/**
 * 通过聚合进行代理
 * @author BZP
 *
 */

public class CarTimeProxy implements Moveable {
	private Moveable m;
	
	public CarTimeProxy(Moveable m) {
		super();
		this.m = m;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行驶");
		m.move();
		long endtime = System.currentTimeMillis();
		System.out.println("汽车结束行驶。。。汽车的行驶时间"+(endtime-starttime)+"毫秒");
	}

}
