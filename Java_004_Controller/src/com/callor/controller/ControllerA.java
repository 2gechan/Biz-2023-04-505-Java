package com.callor.controller;

public class ControllerA {

	public static void main(String[] args) {
		int rnd;

		for (int i = 0; i < 100; i++) {
			rnd = (int) (Math.random() * 50) + 51;

			if (rnd < 51 || rnd > 100) {
				
			} else {
				System.out.print(rnd + " ");
			}
			
		}

	}

}
