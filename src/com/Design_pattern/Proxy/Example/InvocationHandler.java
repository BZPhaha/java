package com.Design_pattern.Proxy.Example;

import java.lang.reflect.Method;

public interface InvocationHandler {
	public void invoke(Object o,Method m);
}
