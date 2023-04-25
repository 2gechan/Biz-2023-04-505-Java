package com.callor.classes.arrays;

/*
 * 정수형 배열 10개를 nums 이름으로 선언하고
 * 각 요소에 50~100까지 랜덤수를 저장하고
 * 배열 요소에 저장된 값들을 덧셈하여 출력
 */
public class ArrayD {

	public static void main(String[] args) {
		int[] nums = new int[10];
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 50) + 51;
			System.out.print(nums[i] + " ");
			sum += nums[i];
		}

		System.out.println();
		System.out.println("nums[]의 합계 : " + sum);
	}

}
