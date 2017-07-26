package com.Design_pattern.look.Example;

public class Client {
	public static void main(String[] args) {
		//1.创建一个目标
		ConcreteWeatherSubject weather = new ConcreteWeatherSubject();
		
		//2.创建观察者
		ConcreteObserve observerGirl = new ConcreteObserve();
		observerGirl.setObserveename("bzp女朋友");
		observerGirl.setRemindThing("我们第一次约会，在XXX");
		
		ConcreteObserve observerPap = new ConcreteObserve();
		observerPap.setObserveename("bzp的老爸");
		observerPap.setRemindThing("是一个出游的好日志，明天去XX玩儿");
		//3.注册观察者
		weather.attach(observerGirl);
		weather.attach(observerPap);
		//4.目标发布天气
		weather.setWeatherContent("明天无语，蓝天白云");
	}
}
