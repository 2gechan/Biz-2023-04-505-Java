package com.callor.classes.exec;

public class ExecI {

	public static void main(String[] args) {

		int[] nums = new int[50];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 50) + 51;
		}

//		int lastNum = 0;
		/*
		 * index 값을 0으로 초기화할 경우 3의 배수가 없으면 nums[index]가 nums[0]이 되어 0번째 index의 값이 출력되게
		 * 된다 그렇기 때문에 index의 초기값을 -1로 설정한 후 조건문을 통해 3의 배수가 있었는지 검증한다.
		 */
		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 3 == 0) {
				index = i;
//				lastNum = nums[i];
			}
		}

		if (index > -1) {
			System.out.println("마지막 index : " + index);
			System.out.println("마지막 3의 배수 값 : " + nums[index]);
		} else {
			System.out.println("3의 배수 없음");
		}

//		for()문 --연산자 사용
//		int lastIndex = 0;
//		int lastNumber = 0;
//		for (index = nums.length - 1; index >= 0; index--) {
//			if (nums[index] % 3 == 0) {
//				lastNumber = nums[index];
//				lastIndex = index;
//				break;
//			}
//		}
//		System.out.println(lastIndex);
//		System.out.println(lastNumber);

	}

}
