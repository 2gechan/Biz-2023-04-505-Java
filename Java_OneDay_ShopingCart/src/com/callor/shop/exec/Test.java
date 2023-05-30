package com.callor.shop.exec;

public class Test {

	public static void main(String[] args) {

		String buId = String.format("%010d", 1);
		
		System.out.println(buId);
		
		int pOPrice = (int) (10000 + Math.round(11100 * 0.22));
		System.out.println(pOPrice);
	}

}
