package com.Design_pattern.look.example2;

public class ConcreteObserver implements Observer {

	private String observerName;
	//天气情况的内容
	private String weatherContent;
	//提醒内容
	private String remindThing;
	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
	}

	public String getRemindThing() {
		return remindThing;
	}

	public void setRemindThing(String remindThing) {
		this.remindThing = remindThing;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	@Override
	public void update(WeatherSubject subject) {
		// TODO Auto-generated method stub
		weatherContent = ((ConcreteWeatherSubject)subject).getWeatherContent();
		System.out.println(observerName+"收到了"+weatherContent+","+remindThing);
	}

	@Override
	public String getObserverName() {
		// TODO Auto-generated method stub
		return this.observerName;
	}

	@Override
	public void setOberserName(String observerName) {
		// TODO Auto-generated method stub
		this.observerName = observerName;
	}

}
