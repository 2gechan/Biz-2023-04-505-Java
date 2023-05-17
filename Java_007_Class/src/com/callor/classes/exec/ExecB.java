package com.callor.classes.exec;

public class ExecB {
	
	public static void main(String[] args) {
		int rndNum = (int)(Math.random() * 100) + 1;
		
		/*
		 * ExecA 클래스에 정의된 pirme() method에게
		 * rndNum 변수의 값을 전달하고
		 * 소수인가를 판별하여 그 결과를 return 받는다.
		 */
		int result = ExecA.prime(rndNum);
		
		if(result > 0) {
			System.out.println(result + " 는 소수");
		} else {
			System.err.println(result + " 는 소수 아님");
		}
	}

}
