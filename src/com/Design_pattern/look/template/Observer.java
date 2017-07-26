package com.Design_pattern.look.template;

/**
 * 这是一个观察者接口，定义一个更新的接口给哪些在目标发送改变的时候被通知的对象。
 * @author BZP
 *
 */
public interface Observer {
	/*
	 * 更新的接口
	 * subject为传入目标对象，方便获取相应的目标对象的状态
	 */
	public void update(Subject subject);
}
