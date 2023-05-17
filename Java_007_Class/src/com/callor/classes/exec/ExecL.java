package com.callor.classes.exec;

import com.callor.classes.module.ServiceC;

public class ExecL {

	public static void main(String[] args) {
	
		ServiceC serviceC = new ServiceC();
		
		int rndNum = (int)(Math.random() * 10);
		
		if(rndNum > 1 && rndNum <10) {
			serviceC.guguDan(rndNum);
		}
		
	}

}
