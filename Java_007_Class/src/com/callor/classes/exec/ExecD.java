package com.callor.classes.exec;

import java.util.Scanner;

import com.callor.classes.module.MyClassA;

public class ExecD {
	
	public static void main(String[] args) {
		
		// MyClassA type의 myA 객체 생성
		
		MyClassA myA = new MyClassA();
		
		int result = myA.add(1, 2);
		
		System.out.println(result);
		
		/*
		 * Scanner type의 scan 객체를 선언하고
		 * Scanner() 생성자 method를 사용하여
		 * scan 객체를 초기화
		 */
		Scanner scan;
		scan = new Scanner(System.in);
		
		/*
		 * 객체(변수)를 초기화 하지 않으면
		 * 일부 기능만 사용할 수 있다 ex) 변수 대입(저장)
		 */
	}

}
