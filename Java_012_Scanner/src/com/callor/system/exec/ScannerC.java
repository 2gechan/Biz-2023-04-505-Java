package com.callor.system.exec;

import java.util.Scanner;

public class ScannerC {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("두 개의 정수를 입력하세요");
			System.out.print("정수 1 (Q : 종료) >> ");
			String strNum1 = scan.nextLine();
			if(strNum1.equals("Q")) {
				break;
			}
			int intNum1 = Integer.valueOf(strNum1);
			
			System.out.print("정수 2 (Q : 종료) >> ");
			String strNum2 = scan.nextLine();
			if(strNum2.equals("Q")) {
				break;
			}
			int intNum2 = Integer.valueOf(strNum2);
			
			System.out.printf("%d + %d = %d \n", intNum1, intNum2, intNum1 + intNum2);
			System.out.printf("%d - %d = %d \n", intNum1, intNum2, intNum1 - intNum2);
			System.out.printf("%d x %d = %d \n", intNum1, intNum2, intNum1 * intNum2);
			System.out.printf("%d ÷ %d = %d \n", intNum1, intNum2, intNum1 / intNum2);
			
		}
		System.out.println("GAME OVER");
		scan.close();
	}

}
