package com.callor.var.controller;

public class ControlD {
	public static void main(String[] args) {
		int intRnd = (int)(Math.random() * 10);
		if(intRnd % 2 ==0) {
			System.out.println(intRnd + "는 짝수이다");
		}
		if(intRnd % 2 != 0) {
			System.err.println(intRnd + "는 짝수가 아니다");
		}
		if(intRnd % 2 == 1) {
			System.out.println(intRnd + "는 홀수이다");
		}
		if(intRnd % 2 != 1) {
			System.err.println(intRnd + "는 홀수가 아니다");
		}
		
	}
	

}
