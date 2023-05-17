package com.callor.var;

public class VarB {
	
	public static void main(String[] args) {

		// 변수에 어떤 값을 저장, 할당, 대입하려면
		// 반드시 먼저 선언되어야 한다.
		
		int num1 = 0;
		int num2 = 0;
		num1 = 30;
		num2 = 40;
		int sum1 = num1 + num2;
		
		System.out.println(sum1);
		
		/*
		 * num1 + num2 연산의 결과를 변수에 저장하려고 한다
		 * 이때 num1과 num2 변수의 type은 int type 이다
		 * 결과적으로 (int type) + (int type)의 연산이 되고
		 * 그 결과도 당연적으로 int type이 된다
		 * 따라서 결과를 저장할 sum1 변수의 type도 당연히 int type이 되어야한다
		 * 
		 * long형 또는 실수형 변수에 저장할 수 있지만
		 * 여기에서는 메모리 낭비가 있을 수 있다
		 */
	}

}
