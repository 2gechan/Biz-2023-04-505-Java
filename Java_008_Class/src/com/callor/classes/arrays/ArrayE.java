package com.callor.classes.arrays;

public class ArrayE {

	public static void main(String[] args) {
		int[] nums = new int[10];
		
		for (int index = 0; index < nums.length; index++) {
			nums[index] = index + 1;
		}
		
		for(int i = 0; i < nums.length; i++) {
			
			int count = 0;

			for(int j=2; j < nums[i]; j++) {
			
				if(nums[i] % j == 0) {
					count ++;
				}
			}
			
			if(count == 0) {
				System.out.println(nums[i] + " 소수");
			} else {
				System.out.println(nums[i] + " 소수 아님");
			}
			
			count = 0;
			
			/*
			 * 짝수를 구하는 조건식
			 * if(nums[i] % 2 == 0) { System.out.print(nums[i] + "\t"); }
			 */
		}
	}

}
