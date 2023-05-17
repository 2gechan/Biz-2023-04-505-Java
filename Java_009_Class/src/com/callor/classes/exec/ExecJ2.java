package com.callor.classes.exec;

public class ExecJ2 {

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
		int nums2Index = 0;
		
		int [] nums2 = new int[50]; // 검증된 Prime 값들을 담은 배열
		
		
		for (int i = 0; i < nums.length; i++) {
			
			int result = prime(nums[i]);
			
			if(result > 0) { // 검증된 Prime을 nums2 배열에 저장
				
				nums2[nums2Index++] = result;
				
				// 마지막 Prime, Index
				lastPrime = result;
				lastIndex = i;
			}
		}
		
		// 최초의 Prime 값, Index 구하기
		for(int i = 0; i< nums.length; i++) {
			if(nums2[0] == nums[i]) {
				firstPrime = nums2[0];
				firstIndex = i;
				break;
			}
		}
		
		System.out.println("최초의 Prime : " + firstPrime);
		System.out.println("최초의 Prime의 Index : " + firstIndex);
		System.out.println();
		System.out.println("마지막 Prime : " + lastPrime);
		System.out.println("마지막 Prime의 Index : " + lastIndex);
		
	}

}
