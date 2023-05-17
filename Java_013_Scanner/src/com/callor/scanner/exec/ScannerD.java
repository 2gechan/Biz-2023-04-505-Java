package com.callor.scanner.exec;

import java.util.Scanner;

public class ScannerD {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("GAME START");
			int rndNum = (int) (Math.random() * 10) + 1;
			
			while(true) {
				
				System.out.print("1 ~ 10 범위의 정수를 입력하세요 (종료 : Q) >> ");
				
				String strNum = scan.nextLine();
				
				if(strNum.equals("Q")) {
					System.out.println("GAME OVER");
					return;
				}
				int num;
				try {
					num = Integer.valueOf(strNum);
					if(rndNum == num) {
						System.out.println("정답입니다");
						break;
					}
					
				} catch (Exception e) {
					System.out.println("정수만 입력하세요");
				}
				
			}
		}
	}

}
