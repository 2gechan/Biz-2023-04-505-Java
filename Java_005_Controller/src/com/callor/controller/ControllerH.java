package com.callor.controller;

public class ControllerH {

	public static boolean prime(int rndNum) {

		int index = 0;

		for (index = 2; index < rndNum; index++) {
			if (rndNum % index == 0) {
				break;
			}
		}

		boolean yesPrime = rndNum <= index;
		return yesPrime;
	}

	// overloading은 메소드 이름은 같지만 파라미터 타입, 수가 다른 메소드를 중복으로 선언
	// overriding은 부모 클래스의 메서드의 기능을 재정의 하는것으로 overloading과 전혀 다름
	public boolean prime() {

		int rndNum = (int) (Math.random() * 50) + 51;
		int index = 0;

		for (index = 2; index < rndNum; index++) {
			if (rndNum % index == 0) {
				break;
			}
		}

		boolean yesPrime = rndNum <= index;
		return yesPrime;
	}

	public static void main(String[] args) {
		
		ControllerH conH = new ControllerH();
		// 메서드에 static이 없기 때문에 클래스를 생성
		
		for (int i = 0; i < 100; i++) {

			int rndNum = (int) (Math.random() * 50) + 51;

			if (prime(rndNum)) {
				System.out.println(rndNum + "소수");
			} else {
				System.err.println(rndNum + "소수 아님");
			}
			
			if (conH.prime()) {
				System.out.println("소수");
			}
		}
	}

}
