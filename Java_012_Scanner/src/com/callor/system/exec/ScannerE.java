package com.callor.system.exec;

import java.util.Scanner;

public class ScannerE {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num1 = 0;
		int num2 = 0;
		
		// out: --> break out; 하게 되면 out 위치의 반복문까지 탈출
		while (true) {
			System.out.println("두 개의 정수를 입력하세요");
			String strNum1 = "";
			String strNum2 = "";
			while(true) {
				System.out.print("정수 1 (q : 종료) >> ");
				strNum1 = scan.nextLine();
				if (strNum1.equals("q")) {
					break;
				}
				
				try {
					num1 = Integer.valueOf(strNum1);
					
				} catch (Exception e) {
					System.out.println("정수 1은 정수 값만 입력해야 합니다");
					continue;
					
				}
				break;
				
			}
			if(strNum1.equals("q")) {
				break;
			}

			while(true) {
				System.out.print("정수 2 (q : 종료) >> ");
				strNum2 = scan.nextLine();
				if (strNum2.equals("q")) {
					break;
				}
				
				try {
					num2 = Integer.valueOf(strNum2);
					
				} catch (Exception e) {
					System.out.println("정수 2는 정수 값만 입력해야 합니다.");
					continue;
					
				}
				break;
				
			}

			if(strNum2.equals("q")) {
				break;
			}
			System.out.printf("%d + %d = %d \n", num1, num2, num1 + num2);
			System.out.printf("%d - %d = %d \n", num1, num2, num1 - num2);
			System.out.printf("%d x %d = %d \n", num1, num2, num1 * num2);
			System.out.printf("%d ÷ %d = %d \n", num1, num2, num1 / num2);

		}
		System.out.println("GAME OVER");
		scan.close();
	}

}
