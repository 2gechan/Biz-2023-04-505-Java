package com.callor.controller;

public class ControllerF {
	
	/*
	 * method 중복선언(overloading)
	 * 1. 같은 이름의 method를 중복하여 선언할 수 있다
	 * 2. method의 이름은 유일성을 갖는 식별자이다
	 * 3. 그럼에도 불구하고 Java에서는 method 이름의 중복을 허용한다
	 * 
	 * * method의 중복이 허용되는 경우 *
	 * 1. method의 parameter(매개변수)의 type이 다른 경우
	 * 2. method의 parameter(매개변수)의 개수가 다른 경우
	 * 3. method의 parameter(매개변수)의 type이 여러가지 일 때 순서가 다른 경우
	 */
	public static int add(int num1, int num2) { return num1 + num2;	}
	
	// overloading
	public static int add(int num1, int num2, int num3) { return num1 + num2 + num3; }
	
	// overloading
	public static float add(float num1, float num2) { return num1 + num2; }
	
	// overloading
	public static double add(double num1, double num2) { return num1 + num2; }

	public static void main(String[] args) {
		System.out.println(add(10, 20));
		System.out.println(add(10.0f, 20.0f));
		System.out.println(add(10.0, 20.0));
	}

}
