package com.callor.bank.exec;

import java.util.Scanner;

import com.callor.bank.config.BankInfo;
import com.callor.bank.service.BankService;

public class DbExecE {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BankService bankService = new BankService();
		BankInfo bankInfo = new BankInfo();
		while(true) {
			bankInfo.headerPrint();
			System.out.println("수행할 업무를 선택하세요");
			System.out.println("	1. 고객 추가");
			System.out.println("	2. 고객 정보 수정");
			System.out.println("	3. 고객 정보 삭제");
			System.out.println("	4. 고객 리스트");
			System.out.println("	5. 고객 정보(계좌) 조회");
			System.out.println("	6. 계좌 개설");
			System.out.println("	9. 업무 종료");
			System.out.println("-".repeat(100));
			System.out.print("업무 선택 >> ");
			String strSelect = scan.nextLine();
			int intSelect = 0;
			try {
				intSelect = Integer.valueOf(strSelect);
			} catch (Exception e) {
				System.out.printf("업무 선택을 잘못하였습니다 (%s)\n", strSelect);
				continue;
			}
			if(intSelect == 1) bankService.insertBuyer();
			else if(intSelect == 2) bankService.update();
			else if(intSelect == 3) bankService.deleteBuyer();
			else if(intSelect == 4) bankService.printBuyerList();
			else if(intSelect == 5) bankService.findUserInfo();
			else if(intSelect == 6) bankService.makeAcount();
			else if(intSelect == 9) break;
		}
		System.out.println("종료");
		
	}

}
