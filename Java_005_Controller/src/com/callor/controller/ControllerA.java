package com.callor.controller;

public class ControllerA {
	
	public static void main(String[] args) {
		/*
		 * 큰 실수형(double) douNum 변수를 선언하고
		 * Math.random()가 만들어준 값으로 초기화
		 */
		double douNum = Math.random();
		// douNum = douNum * 50;
		douNum *= 50;
		
		/*
		 * 정수형 intNum 변수를 선언하고
		 * douNum 변수의 값을 정수형으로 변환한 후
		 * 결과 값으로 intNum 변수를 초기화
		 */
		int intNum = (int)douNum;
		intNum += 51;
		
		/*
		 * int type(정수형) rndNum 변수를 선언하고
		 * 51 ~ 100까지 범위의 임의의 수를 생성하여
		 * rndNum 변수를 초기화
		 */
		int rndNum = (int)(Math.random() * 50) + 51;
		
		System.out.println(douNum);
		System.out.println(intNum);
		System.out.println(rndNum);
		
	}

}
