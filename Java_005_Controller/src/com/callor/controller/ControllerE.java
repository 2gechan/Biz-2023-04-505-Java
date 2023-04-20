package com.callor.controller;

public class ControllerE {

	/*
	 * method 선언
	 */
	public static void prime() {

		int rndNum = (int) (Math.random() * 50) + 51;
		int index = 0;

		for (index = 2; index < rndNum; index++) {
			if (rndNum % index == 0) {
				break;
			}
		}

		if (rndNum <= index) {
			System.out.println(rndNum + "은 소수");
		}
	}

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			// prime() method의 { } 내의 코드를 실행
			// prime() method를 호출한다
			prime();
		}
	}

}
