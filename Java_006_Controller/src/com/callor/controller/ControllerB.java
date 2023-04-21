package com.callor.controller;

public class ControllerB {

	public static boolean prime() {
		int rndNum = (int) (Math.random() * 50) + 51;

		for (int index = 2; index < rndNum; index++) {
			if (rndNum % index == 0) {
				return false;
				// 코드의 간결화를 위해 return 문을 2개 사용
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			boolean yesPrime = prime();
			
			if(yesPrime) {
				System.out.println("소수");
			} else {
				System.out.println("소수아님");
			}
		}
	}

}
