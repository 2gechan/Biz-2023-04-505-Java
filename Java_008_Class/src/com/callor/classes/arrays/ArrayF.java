package com.callor.classes.arrays;

public class ArrayF {
	public static void prime(int rndNum) {
		
		int index;
		for(index=2; index< rndNum; index++) {
			if(rndNum % index == 0) {
				break;
			}
		}
		
		if(rndNum <= index) {
			System.out.println(rndNum + " 소수");
		} else {
			System.err.println(rndNum + " 소수 아님");
		}
		
	}
	
	public static void main(String[] args) {
		int[] nums = new int[10];

		for(int i=0; i<nums.length; i++) {
			nums[i] = (int)(Math.random() * 50) + 51;
		}
		
		for(int i=0; i<nums.length; i++) {
			prime(nums[i]);
		}
	}

}
