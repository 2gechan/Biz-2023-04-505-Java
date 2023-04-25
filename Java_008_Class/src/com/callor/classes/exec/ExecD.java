package com.callor.classes.exec;

public class ExecD {
	
	
	public static void main(String[] args) {
		
		int st1Kor = 80;
		int st2Kor = 70;
		int st3Kor = 85;
		int st4Kor = 100;
		int st5Kor = 65;
		
		int total = st1Kor + st2Kor + st3Kor + st4Kor + st5Kor;
		float avg = (float)total / 5;
		
		System.out.println("합계 : " + total);
		System.out.println("평균 : " + avg);
	}

}
