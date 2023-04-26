package com.callor.classes.exec;

public class ExecF {

	public static void main(String[] args) {

		int[] nums = new int[10];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 50) + 51;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 5 == 0) {
				System.out.println("최초의 5의 배수가 들어있는 index : " + i);
				System.out.println("nums[" + i + "] = " + nums[i]);
				break;
			}
		}
	}

}
