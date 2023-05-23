package com.callor.bank.service;

import java.util.List;
import java.util.Scanner;

import com.callor.bank.models.BuyerDto;
import com.callor.bank.service.impl.BuyerServiceImplV1;

public class BankService {
	
	protected List<BuyerDto> buyerList;
	protected final BuyerService buyerService;
	protected final Scanner scan;
	public BankService() {
		buyerService = new BuyerServiceImplV1();
		scan = new Scanner(System.in);
	}
	
	public void printBuyerList() {
		
		buyerList = buyerService.selectAll();
		System.out.println("=".repeat(100));
		System.out.println("대한 은행 고객 리스트");
		System.out.println("=".repeat(100));
		System.out.println("ID\t이름\t전화번호\t주소\t생년월일\t직업");
		System.out.println("-".repeat(100));
		for(BuyerDto buyerDto : buyerList) {
			System.out.printf("%s\t", buyerDto.buId);
			System.out.printf("%s\t", buyerDto.buName);
			System.out.printf("%s\t", buyerDto.buTel);
			System.out.printf("%s\t", buyerDto.buAddr);
			System.out.printf("%s\t", buyerDto.buBirth);
			System.out.printf("%s\n", buyerDto.buJob);
		}
	}
	
	public void findByBuyer() {
		System.out.println("=".repeat(100));
		System.out.println("조회하고자 하는 고객 id 를 입력하세요 >> ");
		System.out.print("id >> ");
		String strId = scan.nextLine();
		BuyerDto buDto = buyerService.findById(strId);
		if(buDto == null) {
			System.out.println("회원 정보가 없습니다.");
		} else {
			System.out.println(buDto.toString());
		}
	}
	
	public void insertBuyer() {
		
		System.out.println("=".repeat(100));
		System.out.println("고객 정보 등록");
		System.out.println("=".repeat(100));
		
		System.out.print("고객 ID >> ");
		String strBuId = scan.nextLine();
		
		System.out.print("고객명 >> ");
		String strBuName = scan.nextLine();
		
		System.out.print("전화번호 >> ");
		String strBuTel = scan.nextLine();
		
		BuyerDto buDto = new BuyerDto();
		buDto.buId = strBuId;
		buDto.buName = strBuName;
		buDto.buTel = strBuTel;
		
		
		buyerService.insert(buDto);
		/*
		if(buyerService.insert(buDto) < 1) {
			System.out.println("이미 등록된 회원입니다");
		} else {
			System.out.println("회원 등록 완료");
		}
		*/
		
	}
	
	public void deleteBuyer() {
		System.out.println("=".repeat(100));
		System.out.println("삭제할 고객 ID 입력하세요");
		
		System.out.print("ID >> ");
		String strBuId = scan.nextLine();
		
		BuyerDto buDto = buyerService.findById(strBuId);
		
		if(buDto == null) {
			System.out.printf("%s, 고객ID는 없는 정보입니다.", strBuId);
		} else {
			System.out.println(buDto.toString());
			System.out.println("고객의 정보를 정말 삭제할까요 (YES/NO)");
			String yesNo = scan.nextLine();
			
			if(yesNo.equals("YES")) {
				int result = buyerService.delete(strBuId);
				
				if(result > 0) {
					System.out.println("고객 정보 삭제 완료");
				} else {
					System.out.println("고객 정보 삭제 실패");
				}
			} else {
				System.out.println("삭제 취소");
			}
		}
	}
	
	public void update() {
		while(true) {
			System.out.println("수정할 고객 ID를 입력하세요");
			System.out.print("고객ID >> ");
			String strBuId = scan.nextLine();
			
			BuyerDto buDto = buyerService.findById(strBuId);
			if(buDto == null) {
				System.out.printf("%s, 고객 정보가 없습니다", strBuId);
				continue;
			}
			System.out.println(buDto.toString());
			System.out.printf("고객ID : %s\n", buDto.buId);
			
			System.out.printf("고객이름(%s) >> ", buDto.buName);
			String strBuName = scan.nextLine();
			if(!strBuName.equals("")) buDto.buName = strBuName;
			
			System.out.printf("전화번호(%s) >> ", buDto.buName);
			String strBuTel = scan.nextLine();
			if(!strBuTel.equals("")) buDto.buTel = strBuTel;
			
			int result = buyerService.update(buDto);
			if(result > 0) System.out.println("변경 성공");
			else System.out.println("변경 실패");
			
			break;
		}
	}
	

}
