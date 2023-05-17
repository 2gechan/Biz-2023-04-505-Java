package com.callor.classes.exec;

import com.callor.classes.module.ServiceE;

public class ExecN {
	
	public static void main(String[] args) {
		
		int kor = (int)(Math.random() * 50) + 51;
		int eng = (int)(Math.random() * 50) + 51;
		int math = (int)(Math.random() * 50) + 51;
		
		ServiceE serviceE = new ServiceE();
		
		serviceE.score(kor, eng, math);
	}

}
