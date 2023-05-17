package com.callor.controller;

public class ControllerB {

	public static void main(String[] args) {
		int rndNum = (int) (Math.random() * 50) + 51;
		int count = 0;
		
		for (int i = 2; i < rndNum; i++) {
			if (rndNum % i == 0) {
				count++;
				break;
			}
		}
		
		if (count == 0) {
			System.out.println(rndNum + "값은 소수이다");
		} else if (count > 0) {
			System.out.println(rndNum + "값은 소수가 아니다");
		}
		
		boolean yesNo = true;
		for (int i = 2; i < rndNum; i++) {
			if (rndNum % i == 0) {
				yesNo = false;
				break;
			}
		}
		
		if (yesNo) {
			System.out.println(rndNum + "값은 소수이다");
		} else {
			System.out.println(rndNum + "값은 소수가 아니다");
		}
	}

}
