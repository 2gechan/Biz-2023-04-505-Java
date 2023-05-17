package com.callor.controller.var;

public class VarA {

	public static void main(String[] args) {
		int intKor = 80;
		int intEng = 80;
		int intMath = 100;
		int intTotal;
		double doubleAvg;
		intTotal = intKor + intEng + intMath;
		doubleAvg = (double)intTotal / 3; 

		System.out.println("=========================");
		System.out.printf("국어 : %3d\n", intKor);
		System.out.printf("영어 : %3d\n", intEng);
		System.out.printf("수학 : %3d\n", intMath);
		System.out.println("-------------------------");
		System.out.printf("총점 : %d, 평균 : %.2f", intTotal, doubleAvg);

	}

}
