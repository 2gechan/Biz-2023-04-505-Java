package com.callor.classes.module;

public class ServiceE {
	
	public void score(int kor, int eng, int math) {
		
		int sum = kor + eng + math;
		double avg = (double)sum / 3;
		
		System.out.printf("국어 : %d\n", kor);
		System.out.printf("영어 : %d\n", eng);
		System.out.printf("수학 : %d\n", math);
		System.out.printf("총점 : %d\n", sum);
		System.out.printf("평균 : %.4f\n", avg);
		
	}

}
