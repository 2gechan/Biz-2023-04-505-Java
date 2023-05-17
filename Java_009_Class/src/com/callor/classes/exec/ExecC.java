package com.callor.classes.exec;

public class ExecC {

	public static void main(String[] args) {
		int[] nums = new int[10];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 50) + 51;
		}

		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		System.out.println(sum);
	}

}
