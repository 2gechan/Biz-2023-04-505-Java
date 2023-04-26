package com.callor.classes.exec;

public class ExecJ {

	public static int prime(int num) {

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return 0;
			}
		}
		return num;
	}

	public static void main(String[] args) {

		int[] nums = new int[50];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 50) + 51;
		}

		int firstPrime = 0;
		int firstIndex = 0;
		int lastPrime = 0;
		int lastIndex = 0;

		for (int i = 0; i < nums.length; i++) {

			int result = prime(nums[i]);

			if (result > 0) {
				firstPrime = nums[i];
				firstIndex = i;
				break;

			}
		}

		for (int i = 0; i < nums.length; i++) {
			int result = prime(nums[i]);

			if (result > 0) {
				lastPrime = nums[i];
				lastIndex = i;

			}
		}

		System.out.println("최초의 Prime : " + firstPrime);
		System.out.println("최초의 Prime의 Index : " + firstIndex);
		System.out.println();
		System.out.println("마지막 Prime : " + lastPrime);
		System.out.println("마지막 Prime의 Index : " + lastIndex);

	}

}
