package com.Design_pattern.look.Example;
/**
 * 具体的目标对象，负责把有关状态存入到相应的观察者对象中
 * @author BZP
 *
 */


public class ConcreteWeatherSubject extends WeatherSubject {
	//天气内容信息
	private String WeatherContent;

	public String getWeatherContent() {
		return WeatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		WeatherContent = weatherContent;
		//内容有了，天气更新了，通知所有
		this.notifyObservers();
	}

}
