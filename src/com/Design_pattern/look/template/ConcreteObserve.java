package com.Design_pattern.look.template;

/**
 * 具体的观察者对象，实现更新的方法，使自身的状态和目标的状态保持一致
 * @author BZP
 *
 */
public class ConcreteObserve implements Observer {

	/*
	 * 观察者状态
	 */
	private String observerState;
	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		//获取目标类的状态，同步到观察者状态
		observerState = ((ConcreteSubject)subject).getSubjectState();
	}
}
