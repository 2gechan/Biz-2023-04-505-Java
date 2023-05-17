package com.callor.system.exec;

public class NumbersA {
	
	public static void main(String[] args) {
		
		// 문자열일 때는 덧셈연산을 통해 문자열 연결만 가능
		// 그 외에 4칙 연산은 불가능
		String strNum1 = "30";
		String strNum2 = "30.0";
		String strNum3 = "30 + 40";
		
		// 문자열안에 들어 있는 숫자를 정수형으로 변환하기
		int num1 = Integer.valueOf(strNum1);
		float num2 = Float.valueOf(strNum2);
//		int num3 = Integer.valueOf(strNum3);
		
		/*
		 * 문자열인 숫자를 실제 4칙연산이 가능한 숫자로
		 * 변환하기 위해서는 숫자만 들어있는 문자열 이외에
		 * 아무것도 허용하지 않는다.
		 */
		System.out.println(Integer.valueOf("30"));
//		System.out.println(Integer.valueOf(" 30"));
//		System.out.println(Integer.valueOf("30 "));
//		System.out.println(Integer.valueOf("A30"));
//		System.out.println(Integer.valueOf("30A"));
		
		
		System.out.println(num1 + num2);
//		System.out.println(num1 + num3);
	}

}
