package com.Design_pattern.COR.example.handler;

public class Leader extends PriceHandler{

	@Override
	public void processDiscount(float discount) {
		// TODO Auto-generated method stub
		if(discount <= 0.13){
			System.out.format("%s批准了折扣：%.4f%n",this.getClass().getName(),discount);
		}else{
			successor.processDiscount(discount);
		}
	}
	
}
