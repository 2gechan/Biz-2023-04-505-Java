package com.callor.var.controller;

public class ControlH {
	public static void main(String[] args) {

		for (int num = 1; num < 10; num++) {
			System.out.println("Hi" + num);
		}

		int index = 1;
		// index < 10 조건이 ture인 동안만
		// { } 내부의 코드를 실행한다
		for (; index < 10;) {
			System.out.printf("%d x %d = %d \n", 5, index, 5 * index++);
		}
	}

}
