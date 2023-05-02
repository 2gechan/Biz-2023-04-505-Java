package com.callor.classes;

import java.util.Scanner;

public class ClassH {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while(true) {
			System.out.println("두 개의 정수를 입력하세요");
			System.out.println("종료를 원하시면 enter키를 입력하세요");
			
			System.out.print("첫 번째 정수 >> ");
			String num1 = scan.nextLine();
			if(num1.length() < 1) {
				break;
			}
			int intNum1 = Integer.parseInt(num1);
			
			System.out.print("두 번째 정수 >> ");
			String num2 = scan.nextLine();
			if(num2.length() < 1) {
				break;
			}
			int intNum2 = Integer.parseInt(num2);
			
			System.out.printf("%d + %d = %d\n", intNum1, intNum2, intNum1 + intNum2);
			System.out.printf("%d - %d = %d\n", intNum1, intNum2, intNum1 + intNum2);
			System.out.printf("%d x %d = %d\n", intNum1, intNum2, intNum1 + intNum2);
			System.out.printf("%d / %d = %d\n", intNum1, intNum2, intNum1 + intNum2);
			
			
		}
		System.out.println("종료합니다.");

	}

}
