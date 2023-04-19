package com.callor.controller;

public class ControllerE {
	/*
	 * 51 ~ 100까지 랜덤 수 1개를 만들고
	 * 이 수가 소수(Prime)이 아닌지 찾기
	 * 소수(Prime) 란 2 ~ (자신-1) 까지 각각 나누었을 때
	 * 나머지가 한번도 0이 아닌 수 
	 */
	public static void main(String[] args) {

		int rnd = (int) (Math.random() * 50) + 51;

		System.out.println(rnd);
		/*
		 * 초기 값이 1일 경우 어떤 수이든 나머지가 0이 나오기 때문에
		 * 초기 값을 2로 시작하고 자신-1까지 나누어
		 * 나머지가 0이 나오는 수가 있는지 찾는다 
		 */
		for (int i = 2; i < rnd; i++) {
			if(rnd % i == 0) {
				System.out.println(rnd + "는 " + i + "로 나눠진다");
				System.out.println(rnd + "는 소수가 아니다");
				break; // break; 는 for문을 중단
			}
		}
		
		

	}

}
