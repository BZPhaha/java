package com.Design_pattern.Proxy.JkdProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimerHandler implements InvocationHandler {

	private Object target;
	
	public TimerHandler(Object target) {
		super();
		this.target = target;
	}
	/**
	 * proxy:被代理的对象
	 * method 被代理对象的方法
	 * args 方法参数
	 * 
	 * 返回值：
	 * Object 方法的返回值
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行驶");
		method.invoke(target);
		long endtime = System.currentTimeMillis();
		System.out.println("汽车结束行驶。。。汽车的行驶时间"+(endtime-starttime)+"毫秒");
		return null;
	}

}
