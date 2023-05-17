package com.callor.controller;

public class ControllerA {

	public static void main(String[] args) {
		int index = 0;
			/*
			 * 1. index < 10 비교문이 실행
			 *    결과가 true이면
			 * 2. {} 내부의 코드 실행
			 * 3. index++ 하여 index 변수 값을 1 증가
			 * 4. index < 10 비교문 결과가 false가 되면 종료
			 *    그렇지 않으면 1~3을 계속해서 반복 
			 */
		for (; index < 10; index++) {
			// 현재 이 코드는 index가 0~9까지
			// 변화되는 동안 실행 즉, 10회 실행된다
		}
	}

}
