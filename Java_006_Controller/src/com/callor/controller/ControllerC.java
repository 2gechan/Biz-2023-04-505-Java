package com.callor.controller;

public class ControllerC {
	
	public static int prime() {

		int rndNum = (int) (Math.random() * 50) + 51;
		
		for (int index = 2; index < rndNum; index++) {
			if (rndNum % index == 0) {
				return 0;
				// 코드의 간결화를 위해 return 문을 2개 사용
			}
		}

		return rndNum;
	}
	
	public static void main(String[] args) {
		
		int rndNum = prime();
		
		if (rndNum > 0) {
			System.out.println(rndNum + " 소수");
			
		}
	}

}
