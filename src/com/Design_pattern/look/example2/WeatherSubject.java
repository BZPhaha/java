package com.Design_pattern.look.example2;

import java.util.ArrayList;
import java.util.List;

public abstract class WeatherSubject {
	//用来保存注册的观察者对象
	public List<Observer> observers = new ArrayList<Observer>();
	//attch detach abstractnotifyobservers
	public void attach(Observer observer){
		observers.add(observer);
	}
	public void detach(Observer observer){
		observers.remove(observer);
	}
	protected abstract void notifyObservers();
	
}
