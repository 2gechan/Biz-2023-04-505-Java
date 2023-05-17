package com.callor.classes.exec;

public class ExecB {
	
	public static void main(String[] args) {
		
		int[] nums = new int[10];
		
		// nums 배열의 0번 요소부터 9번 요소까지
		// 순서대로 1 ~ 10까지 값을 저장하기
		for(int i = 0; i<nums.length; i++) {
			// nums[i] 위치에 i + 1 값을 저장
			nums[i] = i + 1;
		}
		
		for(int i = 0; i<nums.length; i++) {
			
			nums[i] = (int)(Math.random() * 50) + 51;
		}
	}

}
