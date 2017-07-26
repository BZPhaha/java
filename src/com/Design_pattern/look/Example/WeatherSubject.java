package com.Design_pattern.look.Example;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * 目标对象，它知道观察它的观察者，并提供注册 （添加）和删除的观察者的接口
 * @author BZP
 *
 */
public class WeatherSubject {
	//用来保存注册的观察者对象
	private List<Observer> observers = new ArrayList<Observer>();
	
	//attch detach notifyObservers
	//订阅天气的人添加到列表中
	public void attach(Observer observer){
		observers.add(observer);
	}
	//删除集合中的指定观察者
	public void detach(Observer observer){
		observers.remove(observer);
	}
	
	//通知已经订阅了的所有观察者方法
	protected void notifyObservers(){
		for(Observer observer:observers){
			observer.update(this);
		}
	}
}
