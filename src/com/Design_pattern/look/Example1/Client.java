package com.Design_pattern.look.Example1;

import com.Design_pattern.look.Example1.ConcreteWeatherSubject;

public class Client {
	public static void main(String[] args) {
		ConcreteWeatherSubject w1 = new ConcreteWeatherSubject();
		ConcretObserver girl = new ConcretObserver();
		girl.setObserverName("bzp女朋友");
		ConcretObserver pap = new ConcretObserver();
		pap.setObserverName("bzp老爸");
		
		w1.addObserver(pap);
		w1.addObserver(girl);
		
		w1.setContent("天气晴朗");
		
	}
}
