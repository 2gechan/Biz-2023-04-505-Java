package com.callor.classes;

import java.util.Scanner;

public class ClassE {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num1 = 0;
		int num2 = 0;
		System.out.print("첫번째 정수를 입력하세요 >> ");
		num1 = scan.nextInt();
		System.out.print("두번째 정수를 입력하세요 >> ");
		num2 = scan.nextInt();
		
		System.out.printf("덧셈 >> %d + %d = %d\n", num1, num2, num1 + num2);
		System.out.printf("뺄셈 >> %d - %d = %d\n", num1, num2, num1 - num2);
		System.out.printf("곱셈 >> %d × %d = %d\n", num1, num2, num1 * num2);
		System.out.printf("몫 >> %d / %d = %d\n", num1, num2, num1 / num2);
		System.out.printf("나머지 >> %d ÷ %d = %d\n", num1, num2, num1 % num2);
	}

}
