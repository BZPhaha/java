package com.Design_pattern.Proxy.JkdProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.Design_pattern.Proxy.Example.Car;
import com.Design_pattern.Proxy.Example.Moveable;

public class test {
	/**
	 * jdk动态代理
	 */
	public static void main(String[] args) {
		Car car = new Car();
		InvocationHandler h = new TimerHandler(car);
		Class<?> cls = car.getClass();
		/**
		 * 参数：
		 * loader 类加载器
		 * interfaces 实现接口
		 *  h InvocationHandler
		 */
		Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
		m.move();
	}
}
