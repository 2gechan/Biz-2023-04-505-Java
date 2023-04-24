package com.callor.classes.module;

public class ServiceB {
	
	public void scorePrint(String name, int kor, int eng, int math) {
		
		int sum = kor + eng + math;
		double avg = (double)sum / 3; 
				
		System.out.println("========================================");
		System.out.println("이름    국어 영어 수학 총점   평균");
		System.out.println("----------------------------------------");
		System.out.printf("%s   %d   %d   %d   %d   %.1f\n", name, kor, eng, math, sum, avg);
		System.out.println("========================================");
		
	}

}
