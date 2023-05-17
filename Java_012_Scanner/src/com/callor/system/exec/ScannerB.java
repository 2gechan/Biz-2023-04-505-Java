package com.callor.system.exec;

import java.util.Scanner;

public class ScannerB {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("두 개의 정수를 입력하세요");
			System.out.print("정수 1 (Q : 종료) >> ");
			String strNum1 = scan.nextLine();
			if(strNum1.equals("Q")) {
				break;
			}
			/*
			 * 만약 키보드로 30 이라는 값을 입력하고 enter를 누르면
			 * strNum1 변수에는 문자열형 숫자인 "30" 문자열이 저장된다.
			 * 마찬가지로 strNum2 에도 문자열형 숫자가 저장된다.
			 * 이 두 변수를 덧셈연산하면 문자열 연산이 되고
			 * 나머지 4칙 연산은 오류가 난다.
			 * 
			 * 원하는 연산은
			 * 숫자값의 4칙 연산이다
			 * 따라서 입력된 문자열형 숫자를 실제 숫자형 데이터로
			 * 변환을 해주어야 한다.
			 */
			
			// 문자열형 숫자를 정수형 숫자 데이터로 변환하기
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
