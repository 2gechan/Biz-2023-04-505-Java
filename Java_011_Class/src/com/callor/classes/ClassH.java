package com.callor.classes;

import java.util.Scanner;

public class ClassH {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while(true) {
			System.out.println("두 개의 정수를 입력하세요");
			System.out.println("첫 번째 정수 >> ");
			int num1 = scan.nextInt();
			System.out.println("두 번째 정수 >> ");
			int num2 = scan.nextInt();
			
			System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
			System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
			System.out.printf("%d x %d = %d\n", num1, num2, num1 * num2);
			System.out.printf("%d / %d = %d\n", num1, num2, num1 / num2);
			
			System.out.println("종료를 원하시면 end를 입력하시고");
			System.out.println("계속하길 원하시면 아무값이나 입력하세요");
			String str = scan.next();
			if(str.equals("end")) {
				break;
			} else {
				continue;
			}
		}
		System.out.println("종료합니다.");

	}

}
