package com.callor.controller;

public class ControllerF {

	/*
	 * prime() method의 코드를 수정하여
	 * 생성된 랜덤수가 소수인지 아닌지 판별하는 코드로 변경
	 * 
	 * void type의 prime() method를
	 * boolean type의 prime() method
	 * 
	 * method를 선언할 때 void type 이외의 type 으로 선언하면
	 * method {} 내에서 반드시 return 명령문이 필요
	 * 
	 * static 사용 시 객체 생성 없이 사용 가능
	 * 프로그램 실행 시 static 메모리에 올라가고 종료시 메모리 해제
	 * static 내에서는 인스턴스 변수 사용 불가, int rndNum, index는 지역 변수
	 */
	public static boolean prime() {

		int rndNum = (int) (Math.random() * 50) + 51;
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
			// prime() method의 { } 내의 코드를 실행
			// prime() method를 호출한다
			if(prime()) {
				System.out.println("소수");
			} else {
				System.err.println("소수 아님");
			}
		}
	}

}
