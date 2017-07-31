package com.Design_pattern.Proxy.Example;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Client {
	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		/*Car car = new Car();
		car.move();*/
		//通过继承
		/*Moveable car2 = new Car2();
		car2.move();*/
		//通过聚合
		/*Car car = new Car();
		Moveable m = new CarTimeProxy(car);
		m.move();*/
		/*Car car = new Car();
		CarTimeProxy ctp = new CarTimeProxy(car);
		CarlogProxy clp = new CarlogProxy(ctp);
		clp.move();*/
		
		/*Proxy p = new Proxy();
		Moveable m = (Moveable) p.newProxyInstance(Moveable.class);
		m.move();*/
		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);
		Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class,h);
		m.move();
	}
	
	
}
