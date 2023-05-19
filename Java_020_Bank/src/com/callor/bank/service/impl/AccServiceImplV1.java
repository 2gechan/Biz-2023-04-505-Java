package com.callor.bank.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.models.AccDto;
import com.callor.bank.service.AccService;
import com.callor.bank.service.BuyerService;
import com.callor.bank.utils.Config;

public class AccServiceImplV1 implements AccService {

	protected List<AccDto> accList;
	protected Scanner scan;

	public AccServiceImplV1() {
		accList = new ArrayList<>();
		scan = new Scanner(System.in);
	}

	/*
	 * 신규계좌 등록하기 1. 고객번호를 입력받고 2. 고객번호가 고객정보가 있는가 확인 BuyerServiceImplV1.getBuyer()
	 * method를 사용하여 고객정보 찾기 없으면 : 고객정보를 등록하세요 라고 메시지 표현 2. 고객번호가 있으면 신규 게좌를 생성 :
	 * List<AccDto> type accList 에 추가
	 */
	@Override
	public void accInit() {
		Config.bankTitle("계좌생성");
		BuyerService buService = new BuyerServiceImplV2();
		AccDto acDto = new AccDto();

		System.out.print("고객 ID를 입력하세요 >> ");
		String buId = scan.nextLine();
		if (buService.getBuyer(buId) == null) {
			System.out.println("고객정보를 등록하세요");
		} else {
			acDto.buId = buId;
			System.out.println("계좌번호 : 111-1111-11111");
			String acNum = "111-1111-11111";
			System.out.print("1 : 입출금통장 2 : 청약통장 >> ");
			String str = scan.nextLine();
			String acDiv = "";
			while (true) {
				if (str.equals("1")) {
					acDiv = "입출금통장";
					break;
				} else if (str.equals("2")) {
					acDiv = "청약통장";
					break;
				}
			}
			System.out.printf("고객 ID : %s\n", buId);
			System.out.printf("계좌번호 : %s\n", acNum);
			System.out.printf("계좌구분 : %s\n", acDiv);
			int acBalance = 0;
			System.out.printf("잔액 : %s\n", acBalance);
			acDto.acNum = acNum;
			acDto.acDiv = acDiv;
			acDto.acBalance = acBalance;
			accList.add(acDto);
		}
	}

	@Override
	public void inout() {

	}

	@Override
	public void printAccList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAccList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadAccList() {
		// TODO Auto-generated method stub

	}

}
