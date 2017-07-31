package com.Design_pattern.Proxy.Example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

	private Object target;
	public TimeHandler(Object target) {
		super();
		this.target = target;
	}
	@Override
	public void invoke(Object o, Method m) {
		// TODO Auto-generated method stub
		
		try {
			long starttime = System.currentTimeMillis();
			System.out.println("汽车开始行使");
			m.invoke(target);
			long endtime = System.currentTimeMillis();
			System.out.println("汽车行使了"+ (endtime -starttime)+"毫秒");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
