package com.callor.classes.arrays;

public class ArrayA {

	public static void main(String[] args) {

		int[] nums = new int[5];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 50) + 51;
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.printf("%3d\t", nums[i]);
		}
		System.out.println();

		int tmp;

		/*
		 * 1. 먼저 전체 배열을 순회하는 for() 를 만들고 
		 * 2. 현재 index 위치의 값과 index + 1 ~ 끝까지와 비교한다 
		 * 3. 비교한 결과에서 큰 값을 오른쪽으로, 
		 * 		작은값을 왼쪽으로 배열 요소의 값을 서로 교환한다. 
		 * 4. 이 명령을 전체 배열 개수만큼 반복하면 
		 * 5. 배열에 저장된 값이 오름차순으로 정렬된다.
		 */
		for (int i = 0; i < nums.length; i++) {

			// i가 마지막 index(4) 일 경우 j=5가 되기 때문에
			// 조건식이 맞지않아 for()문을 반복하지 않음
			for (int j = i + 1; j < nums.length; j++) {

				if (nums[i] > nums[j]) {
					tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}

			}
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.printf("%3d\t", nums[i]);
		}
	}

}
