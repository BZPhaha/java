package com.Design_pattern.look.example2;
//定义一个更新的接口方法给那些在目标发生改变的时候被通知的观察者对象调用
public interface Observer {
	public void update(WeatherSubject subject);
	//取的观察者名称
	public String getObserverName();
	public void setOberserName(String observerName);
}
