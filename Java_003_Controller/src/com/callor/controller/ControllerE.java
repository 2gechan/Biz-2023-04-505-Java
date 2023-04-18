package com.callor.controller;

public class ControllerE {

	public static void main(String[] args) {
		int score;

		for (int i = 0; i < 1000; i++) {
			score = (int) (Math.random() * 50) + 51;
//			if (51 > score || score > 100) {
//				System.out.println(score);
//			}

			if (!(score >= 51 && score <= 100)) {
				System.out.println(score);
			}

		}
		System.out.println("Test End");

		int num1 = 100;
		int num2 = 100;
		if (++num1 > 100 || ++num2 > 100) {
			System.out.println("OK");
		}
		if (--num1 > 100 && --num2 > 100) {
			System.out.println("Hello");
		}

	}

}
