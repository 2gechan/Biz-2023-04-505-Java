package com.callor.classes.exec;

import com.callor.classes.module.ServiceD;

public class ExecM {
	public static void main(String[] args) {
	ServiceD serviceD = new ServiceD();
	
	int rndNum1 = (int)(Math.random() * 50) + 51;
	int rndNum2 = (int)(Math.random() * 50) + 51;
	
	serviceD.add(rndNum1, rndNum2);
		
	}

}
