package com.callor.classes.module;

public class ServiceA {
	public void score(int kor, int eng, int math, int his, int mus, int art, int phy) {
		
		int sum = kor + eng + math + his + mus + art + phy;
		float avg = (float)sum / 7;
		
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("국사 : " + his);
		System.out.println("음악 : " + mus);
		System.out.println("미술 : " + art);
		System.out.println("체육 : " + phy);
		System.out.println("--------------------------------");
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
		
	}

}
