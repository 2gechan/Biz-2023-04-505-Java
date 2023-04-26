package com.callor.classes.exec;

public class ExecK {
	
	public static void main(String[] args) {
		int[] nums = new int[50];
		
		for(int i=0; i< nums.length; i++) {
			
			nums[i] = (int)(Math.random() * 50) + 51;
		}
		
		for(int i=0; i<nums.length; i++) {
			
			System.out.print(nums[i] + "\t");
			
			if((i+1) % 5 == 0) {
				System.out.println();
			}
		}
	}

}
