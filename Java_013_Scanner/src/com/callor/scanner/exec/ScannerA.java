package com.callor.scanner.exec;

import java.util.Scanner;

public class ScannerA {

	public static int getNum() {
		Scanner scan = new Scanner(System.in);

		int primeNum;
		while (true) {
			System.out.print("3이상 정수를 입력하세요 (종료 : Q) >> ");
			String strNum = scan.nextLine();
			if (strNum.equals("Q")) {
				return -1;
			}
			try {
				primeNum = Integer.valueOf(strNum);
				// if(primeNum < 3) {
				// continue;
				// }
				// continue 키워드를 사용하고 싶지 않으면
				if (primeNum >= 3) {
					break;
				}

			} catch (Exception e) {
				System.out.println("정수만 정확히 입력하세요");
			}
		}
		return primeNum;
	}

	// 매개변수를 통해 받은 값이
	// 소수가 아니면 -1을 return하고
	// 소수이면 num 값을 return
	public static int prime(int num) {

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return -1;
			}
		}

		return num;

	}

	public static void main(String[] args) {

		while (true) {

			int num = getNum();
			if (num < 0) {
				System.out.println("GAME OVER");

				// main() method에서 return 명령이 실행되면
				// 프로젝트 코드 전체를 중단
				return;
			}

			// prime() method는 전달 받은 num "변수의 값" 이
			// 소수이면 num을 return 소수가 아니면 -1을 return
			int result = prime(num);
			if (result > 0) {
				System.out.println(num + "은 소수");
			} else {
				System.out.println(num + "는 소수가 아님");
			}
		}

//		int index = 0;
//		for (index = 2; index < primeNum; index++) {
//			if (primeNum % index == 0) {
//
//				System.out.println(primeNum + "는 소수 아님");
//				break;
//			}
//		}
//		if (primeNum <= index) {
//			System.out.println(primeNum + "는 소수");
//		}

	}

}
