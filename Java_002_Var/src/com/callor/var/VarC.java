package com.callor.var;

public class VarC {
	public static void main(String[] args) {
		int num1; // 선언
		int num2; // 선언
		num1 = 30; // 초기화(할당)
		num2 = 40; // 초기화(할당)
		
		// 선언만 되어있는 변수는 읽을 수 없다
		// 변수를 읽으려면 반드시 초기화(할당) 필요
		int sum1 = 0;
		System.out.println(sum1);
	}

}
