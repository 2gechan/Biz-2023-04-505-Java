/*
 * Java의 package
 * Java는 소스코드를 package 단위로 관리한다.
 * package = folder와 같은 개념으로 보면 된다.
 * 
 * base-package : com.callor.classes
 * 3단계 package 단위를 base-package라고 한다.
 * base-package는 일부 Application ID(식별자) 역할을 한다.
 */
package com.callor.classes.exec;

public class ExecA {

	public static int prime(int num1) {

		for (int i = 2; i < num1; i++) {
			if (num1 % i == 0) {
				return 0;
			}
		}

		return num1;
	}

	public static void main(String[] args) {
		int result = prime(11);
		if (result > 0) {
			System.out.println(result + " 는 소수");
		}
	}

}
