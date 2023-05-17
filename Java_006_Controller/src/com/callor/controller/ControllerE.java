package com.callor.controller;

public class ControllerE {

	/*
	 * 2개의 정수형 인수를 전달받아
	 * 덧셈을 수행하고 더한 값을 반환 하는 메서드
	 */
	public static int add(int num1, int num2) {
		int sum = num1 + num2;

		return sum;
	}

	public static void main(String[] args) {

		// add() method는 두개의 매개변수를 받기 때문에
		// 정수 값 2개를 add() method에 전달
		int result = add(1, 2);
		System.out.println(result);
	}

}
