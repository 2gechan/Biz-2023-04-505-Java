package com.callor.var.controller;

public class ControlB {
	public static void main(String[] args) {
		double douRnd = Math.random();
		douRnd *= 10;
		int intRnd = (int)douRnd;
		
		// 위 코드와 동일
		intRnd = (int)(Math.random() * 10);
		
		if(intRnd % 2 == 0) {
			System.out.println(intRnd + "는 짝수");
		} else System.out.println(intRnd + "는 짝수가 아니다");
		
	}

}
