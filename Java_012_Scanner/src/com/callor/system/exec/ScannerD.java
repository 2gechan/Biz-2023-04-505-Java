package com.callor.system.exec;

import java.util.Scanner;

public class ScannerD {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num1 = 0;
		int num2 = 0;
		System.out.println("두 개의 정수를 입력하세요");
		while (true) {
			System.out.print("정수 1 (Q : 종료) >> ");
			String strNum1 = scan.nextLine();
			if (strNum1.equals("q")) {
				break;
			}
			/*
			 * strNum1에 저장된 문자열이
			 * q가 아니고 문자열형 숫자가 아닌경우
			 * 1. 그냥 Enter를 누른경우
			 * 2. 정수가 아닌 실수 값을 입력한 경우
			 * 3. space(빈칸)을 입력한 경우
			 * 4. 그 외...
			 */
			
			try {
				num1 = Integer.valueOf(strNum1);
				
			} catch (Exception e) {
				/*
				 * try { }에서 exception이 발생한 경우
				 * Integer.valueOf(strNum1) 명령이 실행되는 도중
				 * 정상적으로 코드가 작동되지 않았을 때
				 * catch { } 내의 코드가 실행된다.
				 * try-catch 블럭으로 감싼 코드는 exception이
				 * 발생하여도 코드가 중단되는 것을 일단 방지한다.
				 */
				System.out.println("정수 1은 정수 값만 입력해야 합니다");
				continue;
				
			}

			System.out.print("정수 2 (Q : 종료) >> ");
			String strNum2 = scan.nextLine();
			if (strNum2.equals("q")) {
				break;
			}
			
			try {
				num2 = Integer.valueOf(strNum2);
				
			} catch (Exception e) {
				System.out.println("정수 2는 정수 값만 입력해야 합니다.");
				continue;
				
			}


			System.out.printf("%d + %d = %d \n", num1, num2, num1 + num2);
			System.out.printf("%d - %d = %d \n", num1, num2, num1 + num2);
			System.out.printf("%d x %d = %d \n", num1, num2, num1 + num2);
			System.out.printf("%d ÷ %d = %d \n", num1, num2, num1 + num2);

		}
		System.out.println("GAME OVER");
		scan.close();
	}

}
