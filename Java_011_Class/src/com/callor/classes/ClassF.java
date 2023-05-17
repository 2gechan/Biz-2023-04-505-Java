package com.callor.classes;

import java.util.Scanner;

public class ClassF {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		for (int i = 0; i < 3; i++) {
			
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
			System.out.println();
			
		}
		/*
		 * scan 객체는 하드웨어인 키보드와 연결된 상태의 여러 정보를
		 * 가지고 있는 상태이다.
		 * 하드웨어 키보드는 운영체제나 여러곳에서 여러 정보를 필요로 하고
		 * 그 정보를 기억장소 어딘가에 보관하고 있는 상태이다.
		 * 이 상태로 프로젝트가 종룓뢰면, 기억장소에 저장된 정보가
		 * 소멸되는데 상당한 시간이 소요될 것이다.
		 * 그렇기 때문에 사용이 끝난 키보드(Scanner)는 메모리에서 제거하는 절차를
		 * 강제로 실행한다.
		 * 
		 * 이것은 자원의 누수(leak)를 방지하는 목적이 있다.
		 */
		scan.close();

	}

}
