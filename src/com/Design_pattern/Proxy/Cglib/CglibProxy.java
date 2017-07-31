package com.Design_pattern.Proxy.Cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	private Enhancer enhance = new Enhancer();
	
	public Object getProxy(Class clazz){
		//设置创建子类的类
		enhance.setSuperclass(clazz);
		enhance.setCallback(this);
		return enhance.create();
		
	}
	/**
	 * 拦截所有目标类方法的调用
	 * arg0 目标类的实例
	 * arg1目标方法的反射对象
	 * arg2 方法的参数
	 * arg3 代理类的实例 
	 */
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("日志开始。。");
		arg3.invoke(arg0, arg2);
		System.out.println("日志结束。。");
		return null;
	}

}
