package com.callor.controller;

public class ControllerD {

	public static void main(String[] args) {

		int rnd;
		int count = 0;
		int sum = 0;
		double avg = 0;
		/*
		 * 51 ~ 100까지 범위의 랜덤 수 100개 생성
		 * 1. 생성된 랜덤 수 중에 짝수가 몇 개 인가 판별
		 * 
		 * 2. 짝수들의 합계 계산
		 * 3. 짝수들의 평균 계산
		 */
		for (int i = 0; i < 100; i++) {
			rnd = (int)(Math.random() * 50) + 51;
			System.out.println(rnd);
			if(rnd % 2 == 0) {
				sum += rnd;
				count ++;
			}
		}
		avg = (double)sum/count;
		System.err.printf("짝수의 개수 : %d\n", count);
		System.out.printf("짝수의 합계 : %d\n", sum);
		System.out.printf("짝수의 평균 : %.2f\n", avg);
		
	}

}
