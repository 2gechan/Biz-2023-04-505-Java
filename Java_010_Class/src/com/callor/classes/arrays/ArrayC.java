package com.callor.classes.arrays;

public class ArrayC {

	public static void main(String[] args) {
		int[] nums = new int[45];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}

		for (int i = 0; i < 1000; i++) {
			int index1 = (int) (Math.random() * nums.length);
			int index2 = (int) (Math.random() * nums.length);
			int tmp;

			tmp = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = tmp;

		}

		for (int i = 0; i < 5; i++) {
			System.out.printf("%d\t", nums[i]);
		}
		System.out.println();

		int[] lottos = new int[5];

		for (int i = 0; i < lottos.length; i++) {
			lottos[i] = nums[i];
		}

		for (int i = 0; i < lottos.length; i++) {

			for (int j = i + 1; j < lottos.length; j++) {

				int tmp;

				if (lottos[i] > lottos[j]) {
					tmp = lottos[i];
					lottos[i] = lottos[j];
					lottos[j] = tmp;
				}
			}
		}
		for (int i = 0; i < lottos.length; i++) {
			System.out.printf("%d\t", lottos[i]);
		}

	}

}
