package com.Design_pattern.look.example2;

public class Client {
	public static void main(String[] args) {
		//1.创建目标
		ConcreteWeatherSubject weatherSubject = new ConcreteWeatherSubject();
		
		//2.创建观察者
		ConcreteObserver observerGirl = new ConcreteObserver();
		observerGirl.setOberserName("bzp's girl");
		observerGirl.setRemindThing("好好的待着");
		
		ConcreteObserver observePap = new ConcreteObserver();
		observePap.setOberserName("bzp's pap");
		observePap.setRemindThing("别出门");
		//3.注册观察者
		weatherSubject.attach(observerGirl);
		weatherSubject.attach(observePap);
		//4.目标天气
		weatherSubject.setWeatherContent("下雨");
		weatherSubject.setWeatherContent("下雪");
	}
}
