package com.Design_pattern.look.Example;

/**
 * 具体的观察者对象，实现更新的方法，使自身的状态和目标的状态保持一致
 * @author BZP
 *
 */
public class ConcreteObserve implements Observer {
	//观察者名字，	 
	private String observeename;
	//天气内容
	private String weatherContent;
	//提醒内容
	private String remindThing;
	
	public String getObserveename() {
		return observeename;
	}

	public void setObserveename(String observeename) {
		this.observeename = observeename;
	}

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

	
	@Override
	public void update(WeatherSubject subject) {
		// TODO Auto-generated method stub
		//获取目标类的状态，同步到观察者状态
		weatherContent = ((ConcreteWeatherSubject)subject).getWeatherContent();
		System.out.println(observeename+"收到了"+weatherContent+","+remindThing);
	}
}
