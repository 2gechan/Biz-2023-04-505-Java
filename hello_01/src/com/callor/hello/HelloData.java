package com.callor.hello;
		
public class HelloData {
	public static void main(String[] args) {
		System.out.println("Hello Korea");
		System.out.println("Hello" + "Korea");
		System.out.println("Hello      Korea");
		System.out.println("Hello"        +        "Korea");
		System.out.println();
		
		System.out.println(30 + 40);
		System.out.println("30" + "40");
		System.out.println("30 + 40");
		System.out.println();
		
		// 30 + 40 = 70
		System.out.println("30 + 40 = 70");
		System.out.println("30 + 40 = " + 30 + 40);
		// "30 + 40 = " + 30을 연산하려고 시도
		// 문자열 + 숫자의 연산 시 숫자 데이터를 문자열로 바꿔버린다
		// "30 + 40 = " + "30" -> "30 + 40 = 30" + "40" -> "30 + 40 = 3040" 
		
		System.out.println("30 + 40 = " + (30 + 40)); // 괄호를 통해 연산 우선순위 설정
		System.out.println("30 + 40 = " + 30 * 40); // *연산자가 +보다 우선이기 때문에 연산 가능
		
//		문자열은 +(연결연산자)만 가능
//		System.out.println("30 - 40 = " + 30 - 40);
//		System.out.println("30" - "40");
//		System.out.println("30" * "40");
//		System.out.println("30" / "40");
	}

}
