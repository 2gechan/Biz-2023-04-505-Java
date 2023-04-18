package com.callor.controller.var;

public class VarE {
	
	public static void main(String[] args) {
		String str = "Repulbic of Korea";
		String nation = "";
		// str에 저장된 문자열을 12번 인덱스에서 잘라서 저장
		nation = str.substring(12);
		System.out.println(nation);
		// str에 저장된 문자열을 9번 인덱스부터 11번인덱스까지 잘라서 출력
		System.out.println(str.substring(9, 11));
	}

}
