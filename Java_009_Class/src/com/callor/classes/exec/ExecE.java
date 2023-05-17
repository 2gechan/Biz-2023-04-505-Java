package com.callor.classes.exec;

public class ExecE {

	/*
	 * 배열 요소의 생성 개수는 상황에 따라 다르다.
	 * 배열의 요소를 대상으로 for() 반복문으로 처리를 할 때
	 * 배열의 요소의 개수를 일일이 숫자로 코딩하는 것은
	 * 배욜의 요소 개수가 변경될 때마다 수정해야하는
	 * 코드가 많아진다.
	 * 그래서 Java에서느 배열을 생성하면
	 * 배열의 요소 개수를 알 수 잇는 변수를 자동으로 생성한다.
	 * 배열.length
	 */
	public static void main(String[] args) {
		int[] nums = new int[10];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 50) + 51;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 5 == 0) {
				System.out.println(nums[i]);
			}

		}
	}

}
