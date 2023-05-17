package com.callor.classes.exec;

import com.callor.classes.module.ServiceA;

public class ExecJ {

	public static void main(String[] args) {
		ServiceA serviceA = new ServiceA();
		
		int rndNum1 = (int)(Math.random() * 50) + 51;
		int rndNum2 = (int)(Math.random() * 50) + 51;
		
		int result = serviceA.add(rndNum1, rndNum2);
		
		System.out.printf("%d + %d = %d",rndNum1, rndNum2, result);
	}

}
