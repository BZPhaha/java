package com.Design_pattern.Proxy.Cglib;

public class test {
	public static void main(String[] args) {
		CglibProxy cglibProxy = new CglibProxy();
		Train t = (Train) cglibProxy.getProxy(Train.class);
		t.move();
	}
}
