package com.callor.system.var;

public class VarAC {
	public static void main(String[] args) {
		/*
		 * 선언만 한 변수는 쓰기 전용
		 */
		int num1; // 정수형 변수 num1을 선언
		// System.out.println(num1);은 오류
		num1 = 100; // num1 초기화
		num1 = 200;
		num1 = 0;
		
		int num2 = 0; // 선언과 동시에 초기화
		
		
	}

}
