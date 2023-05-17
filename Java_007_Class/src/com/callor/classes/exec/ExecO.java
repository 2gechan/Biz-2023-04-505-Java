package com.callor.classes.exec;

import com.callor.classes.module.ServiceF;

public class ExecO {
	
	public static void main(String[] args) {
		
		int kor = (int)(Math.random() * 50) + 51;
		int eng = (int)(Math.random() * 50) + 51;
		int math = (int)(Math.random() * 50) + 51;
		int society = (int)(Math.random() * 50) + 51;
		int music = (int)(Math.random() * 50) + 51;
		int art = (int)(Math.random() * 50) + 51;
		int phy = (int)(Math.random() * 50) + 51;
		
		ServiceF serviceF = new ServiceF();
		serviceF.score(kor, eng, math, society, music, art, phy);
	}

}
