package com.callor.hello.data;

public class VarA {
	public static void main(String[] args) {
		/*
		 * 기억장소 어딘가에 값(문자, 문자열, 숫자 등)을 
		 * 저장할 수 있는 공간을 한개 예약하고
		 * 그 장소를 가리키는 변수명(label)을 붙힌다
		 */
		int num1 = 30;
		Integer num2 = 40;
		var num3 = 20;
		System.out.println(num1 + num2);
		System.out.println(num1 - num2);
		System.out.println(num1 * num2);
		System.out.println(num1 / num2);
		System.out.println(num1 % num2);
		
		System.out.println(num1 + num2 + num3);
		
	}

}
