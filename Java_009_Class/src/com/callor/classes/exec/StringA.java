package com.callor.classes.exec;

public class StringA {
	
	public static void main(String[] args) {
		String str = "Republic of Korea";
		System.out.println(str.substring(10));
		
		String view = String.format("%d", 20);
		/*
		 * String.format() 
		 * 문자열을 format 형식 문자열로 변환하는 method
		 * printf()는 콘솔에 출력하는 용도로만 사용하는 것과 달리
		 * String.format()은 결과를 다른 변수에 저장할 수 있다.
		 * System.out.printf()의 return type은 void 이기 때문에 출력만 가능
		 * String.format()의 반환 타입은 String 이기 때문에 변수에 저장할 수 있다.
		 */
		
		int num = 3;
		// num 변수에 저장된 값을 문자열로 변환하여
		// result 문자열 변수에 저장하기
		String result = String.format("%d", num);
		
		// printf와 동일한 작동방식
		System.out.printf("값 : %d\n", num);
		result = String.format("값 : %d", num);
		System.out.println(result);
		
		result = String.format("%05d", num);
		System.out.println(result);
		
	}

}
