package com.callor.classes.module;

public class ServiceF {
	
	public void score(int kor, int eng, int math, int soc, int mus, int art, int phy) {
		
		int sum = kor + eng + math + soc + mus + art + phy;
		double avg = (double)sum / 7;
		
		System.out.printf("총점 : %d\n", sum);
		System.out.printf("평균 : %.2f", avg);
	}

}
