package com.callor.controller;

public class ControllerE {
	
	public static void prime(int rndNum) {
		boolean yesNo = true;
		for (int j = 2; j < rndNum; j++) {
			if (rndNum % j == 0) {
				yesNo = false;
				break;
			}
			
		}
		if(yesNo) {
			System.out.println(rndNum + "은 소수");
		} 
		yesNo = true;
		
	}

	public static void main(String[] args) {
		
		// 51 ~ 100 사이 범위의 랜덤 수 100개 생성
		for (int i = 0; i < 100; i++) {
			int rndNum = (int) (Math.random() * 50) + 51;
			prime(rndNum);
		}
	}

}
