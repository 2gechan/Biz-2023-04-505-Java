package com.callor.controller;

public class ControllerB {

	public static void main(String[] args) {

		int rnd;

		for (int i = 0; i < 100; i++) {
			rnd = (int) (Math.random() * 50) + 51;
			System.out.print(rnd + " ");

//			if (rnd % 2 == 0) { 짝수 판별
//				System.out.print(rnd + " ");
//			}
			
			// 짝수인지 홀수인지 판별
//			if (rnd % 2 == 0) {
//				System.out.println("짝수");
//			}
//			if (rnd % 2 == 1) {
//				System.out.println("홀수");
//			}

			if (rnd % 2 == 0) {
				System.out.println("짝수");
			} else if (rnd % 2 == 1) {
				System.out.println("홀수");
			}

		}

	}

}
