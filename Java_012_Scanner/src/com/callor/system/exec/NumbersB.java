package com.callor.system.exec;

public class NumbersB {
	
	public static void main(String[] args) {
		String str1 = "30";
		String str2 = "30.0";
		
		int num1 = Integer.valueOf(str1);
		float num2 = Float.valueOf(str2);
		
		System.out.printf("num1 : %d\n", num1);
		System.out.printf("num2 : %f", num2);
		
		num1 = Integer.valueOf(str2);
		num2 = Float.valueOf(num1);
		num2 = Float.valueOf(str2);
		num1 = (int)num2;
	}

}
