package com.callor.controller;

public class ControllerG {

	/*
	 * 매개변수로 랜덤 값 받기
	 */
	public static boolean prime(int rndNum) {

		int index = 0;

		
		for (index = 2; index < rndNum; index++) {
			if (rndNum % index == 0) {
//				break;
				return false;
			}
		}

//		if (rndNum <= index) {
//			System.out.println(rndNum + "은 소수");
//		} else {
//			System.err.println(rndNum + "은 소수 아님");
//		}

		boolean yesPrime = rndNum <= index;
		return yesPrime;
	}

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			int rndNum = (int) (Math.random() * 50) + 51;

			// prime method에게 rndNum이 저장된 변수 주소를 전달하는게 아닌
			// rndNum의 순수한 값을 전달
			if (prime(rndNum)) {
				System.out.println(rndNum + "소수");
			} else {
				System.err.println(rndNum + "소수 아님");
			}
		}
	}

}
