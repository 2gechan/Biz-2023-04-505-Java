package com.callor.classes;

import java.util.Scanner;

public class ClassD {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("문자열 입력 >> "); // prompt
		scan.nextLine(); // 문자열 입력
		
		System.out.print("정수 입력 >> "); // prompt
		scan.nextInt(); // 정수만 입력
		
		System.out.print("실수 입력 >> "); // prompt
		scan.nextFloat(); // float 타입의 실수만 입력
		
	}

}
