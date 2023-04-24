package com.callor.classes.exec;

import com.callor.classes.module.MyClassC;

public class ExecH {
	/*
	 * 51 ~ 100까지 범위의 임의의 랜덤 수 생성 
	 * MyClassC의 prime() method에게 전달하고
	 * 소수인지 아닌지 결과를 출력
	 */
	public static void main(String[] args) {
		int rndNum = (int) (Math.random() * 50) + 51;
		
		// MyClassC type의 myC객체 생성
		MyClassC myC = new MyClassC();
		
		// myC 참조변수를 통해 prime(int) mehtod를 호출하고
		// 그 결과를 result 변수에 받기
		int result = myC.prime(rndNum);

		if (result > 0) {
			System.out.println(rndNum + " 는 소수");
		} else {
			System.out.println(rndNum + " 는 소수 아님");
		}

	}

}
