package com.callor.controller;

public class ControllerC {

	public static void main(String[] args) {
		int rndNum = (int) (Math.random() * 50) + 51;

		int index;
		for (index = 2; index < rndNum; index++) {
			if (rndNum % index == 0) {
				break;
			}
		}
		
		// for문 안의 if문이 한번도 실행되지 않게 되면
		// 마지막 index 반복문 실행 후 index++로 rndNum값보다 값이 같거나 커짐
		if(rndNum <= index) {
			System.out.println("는 소수");
		} else {
			System.out.println(rndNum + "는 소수 아님");
		}
	}

}
