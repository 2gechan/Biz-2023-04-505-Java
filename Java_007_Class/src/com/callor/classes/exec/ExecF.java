package com.callor.classes.exec;

import com.callor.classes.module.MyClassB;

public class ExecF {

	public static void main(String[] args) {

		/*
		 * MyClassB가 변수를 선언하는 키워드가 되었다.
		 * Java에서 제공하는 키워드 외에 생성한 클래스가
		 * 변수를 선언하는 키워드가 될 수 있다.
		 */
		MyClassB myB = new MyClassB();

		System.out.println(myB.add(30, 40));
		System.out.println(myB.add(30.0f, 40.0f));
		System.out.println(myB.add("대한", "민국"));
	}

}
