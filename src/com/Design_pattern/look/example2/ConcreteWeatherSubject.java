package com.Design_pattern.look.example2;

public class ConcreteWeatherSubject extends WeatherSubject {

	//存储天气情况   晴天 下雨 下雪
	//目标对象的状态
	private String weatherContent;
	public String getWeatherContent() {
		return weatherContent;
	}
	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
		this.notifyObservers();
	}
	
	
	@Override
	protected void notifyObservers() {
		// TODO Auto-generated method stub
		for(Observer observer:observers){
			//规则是
			if("下雨".equals(this.getWeatherContent())){
				if("bzp's girl".equals(observer.getObserverName())){
					observer.update(this);
				}
				if("bzp's pap".equals(observer.getObserverName())){
					observer.update(this);
				}
			}
			if("下雪".equals(this.getWeatherContent())){
				if("bzp's pap".equals(observer.getObserverName())){
					observer.update(this);
				}
			}
		}
	}

}
