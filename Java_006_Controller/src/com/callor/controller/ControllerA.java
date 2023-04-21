package com.callor.controller;

public class ControllerA {

	/*
	 * main() 함수란,
	 * java.exe가 파일을 읽어서
	 * 메모리에 load하고 제일 먼저 호출
	 */
	public static void main(String[] args) {
		prime();
		
		// prime()의 반환 타입이 boolean 이라면
		// boolean bl = prime(); 도 가능하다
		
	} // end main

	// 매개 변수 없음, 반환 타입 void(반환타입 x)
	public static void prime() {
		int rndNum = (int) (Math.random() * 50) + 51;
		int index = 0;
		for (index = 2; index < rndNum; index++) {
			if (rndNum % index == 0) {
				break;
			}
		}
		if (index >= rndNum) {
			System.out.println(rndNum + " 소수");
		} else {
			System.out.println(rndNum + " 소수 아님");
		}
	}

}
