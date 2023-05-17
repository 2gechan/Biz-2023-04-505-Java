package com.callor.var.controller;

public class ControlE {
	public static void main(String[] args) {
		int intRnd = (int) ((Math.random() * 10) + 1);

		if (intRnd % 3 == 0) {
			System.out.println(intRnd + "는 3의 배수이다");
		}

		// intRnd 값이 3의 배수인 경우도 한번 더 아닌가를 확인하여
		// 다소 비효율적인 코드 진행이 된다
		if (intRnd % 3 != 0) {
			System.err.println(intRnd + "는 3의 배수가 아니다");
		}
		
		if(intRnd % 3 == 0) {
			System.out.println(intRnd + "는 3의 배수이다");
		} else System.err.println(intRnd + "는 3의 배수가 아니다");
		// 조건식의 결과가 원하지 않는 결과가 나왔을 경우 else문을 실행

	}

}
