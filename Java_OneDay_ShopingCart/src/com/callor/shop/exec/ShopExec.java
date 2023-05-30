package com.callor.shop.exec;

import java.util.Scanner;

import com.callor.shop.service.ShopService;

public class ShopExec {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ShopService shopService = new ShopService();

		while (true) {

			System.out.println("=".repeat(100));
			System.out.println("빛나라 쇼핑몰 2023");
			System.out.println("=".repeat(100));
			System.out.println("상품관리");
			System.out.println("-".repeat(50));
			System.out.println("1. 상품리스트");
			System.out.println("2. 상품등록 및 수정");
			System.out.println("-".repeat(50));
			System.out.println("고객관리");
			System.out.println("3. 고객리스트");
			System.out.println("4. 고객등록 및 수정");
			System.out.println("-".repeat(50));
			System.out.println("상품판매");
			System.out.println("-".repeat(50));
			System.out.println("5. 장바구니 상품 담기");
			System.out.println("6. 구매자별 장바구니 리스트 보기");
			System.out.println("7. 장바구니 전체 리스트 보기");
			System.out.println("-".repeat(50));
			System.out.println("QUIT. 끝내기");
			System.out.println("=".repeat(100));
			System.out.print("선택 >> ");
			
			String select = scan.nextLine();
			if(select.equals("QUIT")) {
				break;
			}
			int selectNum = 0;
			try {
				selectNum = Integer.valueOf(select);
			} catch (Exception e) {
				System.out.printf("업무 선택은 QUIT(끝내기), 1 ~ 7 정수만 입력할 수 있습니다 ( %s )", select);
				continue;
			}
			
			if(select.equals("1")) {
				shopService.printProduct();
			} else if(select.equals("2")) {
				shopService.insertProduct();
			} else if(select.equals("3")) {
				shopService.printBuyer();
			} else if(select.equals("4")) {
				shopService.insertBuyer();
			} else if(select.equals("5")) {
				shopService.shoppingCart();
			} else if(select.equals("6")) {
				shopService.printBuyerCart();
			} else if(select.equals("7")) {
				shopService.printTradeAll();
			}
			

		}
	}

}
