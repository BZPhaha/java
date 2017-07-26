package com.Design_pattern.COR.example.handler;

public class PriceHandlerFactory {

	/*
	 * 创建PriceHandler的工厂方法
	 */
	public static PriceHandler createPriceHandler() {
		// TODO Auto-generated method stub
		PriceHandler sales = new Sales();
		PriceHandler leader = new Leader();
		PriceHandler manager = new Manager();
		PriceHandler director = new Director();
		PriceHandler vp = new VicePresident();
		PriceHandler ceo = new CEO();
		
		sales.setSuccessor(leader);
		leader.setSuccessor(manager);
		manager.setSuccessor(director);
		director.setSuccessor(vp);
		vp.setSuccessor(ceo);
		
		return sales;
	}

}
