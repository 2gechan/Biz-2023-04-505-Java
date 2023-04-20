package com.callor.controller;

public class ControllerD {

	public static void main(String[] args) {
		int rndNum;
		boolean yesNo = true;
		
		// 51 ~ 100 사이 범위의 랜덤 수 100개 생성
		for (int i = 0; i < 100; i++) {
			rndNum = (int) (Math.random() * 50) + 51;
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
	}

}
