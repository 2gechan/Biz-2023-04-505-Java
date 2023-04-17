package com.callor.var.controller;

public class ControlA {
	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 43;
		
		boolean bEven1 = num1 % 2 == 0;
		boolean bEven2 = num2 % 2 == 0;
		
		/*
		 * if(조건 연산식) { }
		 * 만약 "조건 연산식"의 결과가 true이면,
		 * { } 내부의 코드를 실행
		 */
		if(bEven1) {
			System.out.println(num1 + "은 짝수");
		} else System.out.println(num1 + "은 홀수");
		
		if(bEven2) {
			System.out.println(num2 + "은 짝수");
		} else System.out.println(num2 + "은 짝수가 아니다");
	}

}
