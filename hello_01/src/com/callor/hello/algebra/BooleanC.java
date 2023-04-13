package com.callor.hello.algebra;

import java.util.Scanner;

public class BooleanC {
	public static void main(String[] args) {
		System.out.println(33 % 2 == 0);
		
		// 삼항연산자 -> (연산식) ? (true일시) : (false일시)
		System.out.println(33 % 2 == 0 ? "YES" : "NO");
		System.out.println(33 % 3 == 0 ? "몫은 " + (33 / 3) : "나머지는 " + (33 % 3));
		
		
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
				
		System.out.println(a % 2 == 0 ? "짝수" : "홀수");
	}

}
