package com.callor.scanner.exec;

import java.util.Scanner;

public class ScannerG {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] nums = new int[6];
		int[] nums2 = new int[6];

		while (true) {

			int rndNum = (int) (Math.random() * 45) + 1;

			for (int i = 0; i < nums.length; i++) {
				if (nums[i] > 0) { // nums[i]에 이미 값이 있을때
					// 랜덤값과 nums[i]가 같으면 새로운 랜덤 수 생성
					if (nums[i] == rndNum) {
						break;
					} else {
						continue;
					}
				} else {
					nums[i] = rndNum;
					break;
				}
			}

			if (nums[nums.length - 1] > 0) {
				break;
			}
		} // 중복되지 않는 랜덤수 생성 while(true) end

		for (int i = 0; i < nums.length; i++) { // 테스트를 위해 배열 출력
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		int count = 0;
		while (true) {

			System.out.println("=".repeat(40));
			System.out.println("GAME START");
			System.out.println("=".repeat(40));
			System.out.print("1 ~ 45 범위의 정수를 입력하세요 (종료 : Q) >> ");
			String strNum = scan.nextLine();
			if (strNum.equals("Q")) {
				return;
			}
			try {
				int num = Integer.valueOf(strNum);
				if (num < 0 || num > 45) {
					System.out.println("1 ~ 45 사이의 숫자를 입력하세요");
				}

				for (int index = 0; index < nums.length; index++) {
					if (nums2[index] == num) {
						System.out.println("이미 맞춘 값 입니다.");
					} else if (nums[index] == num) {

						nums2[index] = num;
						count++;
						System.out.println("정답입니다.");
						if (count == nums.length) {
							int tmp = 0;
							for (int i = 0; i < nums.length; i++) {
								for (int j = i + 1; j < nums.length; j++) {
									if (nums[i] > nums[j]) {
										tmp = nums[i];
										nums[i] = nums[j];
										nums[j] = tmp;
									}
								}
							}
							for (int i = 0; i < nums.length; i++) {
								System.out.print(nums[i] + " ");
							}
							return;
						}

						break;

					}
				}

			} catch (Exception e) {
				System.out.println("정수를 입력하세요");
			}
		} // 중복되지 않는 랜덤수 배열 저장 while(true) end

	}

}
