package com.Design_pattern.look.Example1;

import java.util.Observable;
import java.util.Observer;

import com.Design_pattern.look.Example1.ConcreteWeatherSubject;

public class ConcretObserver implements Observer {
	//观察者名称的变量
	private String observerName;
	public String getObserverName() {
		return observerName;
	}
	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		//第一种 推
		System.out.println(observerName + "收到了消息，目标推送过来的是"+arg);
		//第二种 拉
		System.out.println(observerName + "收到了信息，主动到目标对象中去拉，拉到的内容是"+
				((ConcreteWeatherSubject)o).getContent());
	}

}
