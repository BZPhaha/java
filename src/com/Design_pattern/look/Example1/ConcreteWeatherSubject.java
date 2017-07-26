package com.Design_pattern.look.Example1;

import java.util.Observable;
//天气目标的具体实现类
public class ConcreteWeatherSubject extends Observable {
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		//通知所有的观察者
		//必写
		this.setChanged();
		//主动通知，推
		this.notifyObservers(content);
		//拉
		//this.notifyObservers();
	}
	
	
}
