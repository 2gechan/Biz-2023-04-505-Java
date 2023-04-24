package com.callor.classes.exec;

import com.callor.classes.module.ServiceB;

public class ExecK {
	
	public static void main(String[] args) {
		
		ServiceB serviceB = new ServiceB();
		String name = "홍길동";
		int rndKor = (int)(Math.random() * 50) + 51;
		int rndEng = (int)(Math.random() * 50) + 51;
		int rndMath = (int)(Math.random() * 50) + 51;
		
		serviceB.scorePrint(name, rndKor, rndEng, rndMath);
		
	}

}
