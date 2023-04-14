package com.callor.system.var;

public class VarAD {
	
	public static void main(String[] args) {
		
		/*
		 * 정수형 변수 num1, num2, num3 를
		 * 선언하고 각각 0으로 초기화
		 */
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		
		/*
		 * 선언된 변수들에 각각 값을 대입
		 */
		num1 = 30;
		System.out.println(num2); // 0이 출력
		num2 = 20;
		num3 = 15;
		
		// num3 변수에 저장된 값을 읽어서 3번 출력
		// 읽기는 수없이 실행해도 변수에 저장된 값은 변함 없음
		System.out.println(num3);
		System.out.println(num3);
		System.out.println(num3);
		System.out.println();
		num1 = num3;
		num2 = num1;
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		
		// 세개의 변수중에 num3의 값을
		// 200으로 변경
		// 변수 num3에 정수 200을 대입
		// 각 변수는 독립적이기 때문에
		// num1, num2의 값은 변함 없음
		num3 = 200;
	}
}
