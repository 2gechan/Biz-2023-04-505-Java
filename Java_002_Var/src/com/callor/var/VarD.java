package com.callor.var;

public class VarD {
	public static void main(String[] args) {
		// 변수에 할당할 값이 정해진 경우
		// 0이 아닌 값으로 초기화를 하는 것이 좋다
		int num1 = 1;
		int num2 = 2;
		
		int sum1 = 0;
//		int sum1 = num1 + num2; 같은 영역에서 같은 이름의 변수는 선언 불가능
		sum1 = num1 + num2;
	}
}
