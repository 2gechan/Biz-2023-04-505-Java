package com.callor.scanner.exec;

import java.util.Scanner;

public class ScannerF {

	
	/*
	 * 1. 랜덤 값 생성 후 키보드로 숫자를 입력하여 정답인지 맞추기 
	 * 2. 정답일 경우 배열에 이미 저장되어 있는 값인지 확인
	 * 3. 있다면 배열에 저장하지 않고 새로운 랜덤 값 생성
	 * 3-1. 없다면 비어있는 순서대로 배열의 인덱스에 값 저장
	 * 4. 배열에 숫자가 모두 저장되면 배열의 요소들을 출력한 후 종료
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] nums = new int[6];

		while (true) {
			if (nums[nums.length-1] > 0) {
				for(int i=0; i<nums.length; i++) {
					System.out.print(nums[i] + " ");
				}
				return;
			}
			System.out.println("=".repeat(40));
			System.out.println("GAME START");
			System.out.println("=".repeat(40));

			int rndNum = (int) (Math.random() * 45) + 1;
			
			while (true) {

				System.out.print("1 ~ 45 범위의 정수를 입력하세요 (종료 : Q) >> ");

				String strNum = scan.nextLine();

				if (strNum.equals("Q")) {
					System.out.println("GAME OVER");
					return;
				}
				int num;
				try {
					num = Integer.valueOf(strNum);

				} catch (Exception e) {
					System.out.println("정수만 입력하세요");
					continue;
				}
				if (num < 0 || num > 45) {
					System.out.println("1 ~ 45 까지의 범위의 정수만 입력하세요");
				} else if (rndNum == num) {
					int count = 0;
					for(int i=0; i<nums.length; i++) {
						if(nums[i] == num) {
							count ++;
							break;
						}
					}
					
					if(count > 0) {
						System.out.println("이미 등록된 숫자 입니다.");
						break;
					} else {
						System.out.println("정답입니다.");
						for(int i=0; i<nums.length; i++) {
							if(!(nums[i] > 0)){
								nums[i] = num;
								break;
							}
						}
						break;
						
					}
					
				} else if (rndNum > num) {
					System.out.println("랜덤 수 보다 작은 값을 입력하였습니다.");
				} else if (rndNum < num) {
					System.out.println("랜덤 수 보다 큰 값을 입력하였습니다.");
				} // if 조건문보다 else if를 쓰는 이유는 if 조건문을 쓰게되면
					// 이전 조건이 맞더라도 다시한번 조건문을 실행하게 된다.

			}
		}
	}

}
