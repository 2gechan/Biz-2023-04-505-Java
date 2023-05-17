package com.callor.controller;

public class ControllerC {

	public static void main(String[] args) {
		/*
		 * 100 개의 랜덤 수를 생성하여
		 * 생성된 랜덤 수가 3의 배수인지 2의 배수인지 판별
		 * ,최소 공배수는 3의 배수로 판별
		 */

		int rnd;

		for (int i = 0; i < 100; i++) {
			rnd = (int)(Math.random() * 50) + 51;
			if(rnd % 3 == 0) {
				System.out.println(rnd + "는 3의 배수");
			} else if(rnd % 2 == 0) {
				System.out.println(rnd + "는 2의 배수");
			}
		}
	}

}
