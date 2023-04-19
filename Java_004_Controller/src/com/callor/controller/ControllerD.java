package com.callor.controller;

public class ControllerD {

	public static void main(String[] args) {

		int rnd;
		int count = 0;

		for (int i = 0; i < 100; i++) {
			rnd = (int)(Math.random() * 50) + 51;
			System.out.println(rnd);
			if(rnd % 2 == 0) {
				count ++;
			}
		}
		System.err.println("짝수의 개수는 " + count);

	}

}
