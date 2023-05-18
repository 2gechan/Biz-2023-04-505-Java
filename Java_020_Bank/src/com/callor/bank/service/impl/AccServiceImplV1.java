package com.callor.bank.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.models.AccDto;
import com.callor.bank.service.AccService;
<<<<<<< HEAD
import com.callor.bank.service.BuyerService;
import com.callor.bank.utils.Config;
=======
>>>>>>> 46d90f8976019ca80cefac0851a7a94e5ea73a67

public class AccServiceImplV1 implements AccService {

	protected List<AccDto> accList;
	protected Scanner scan;

	public AccServiceImplV1() {
		accList = new ArrayList<>();
		scan = new Scanner(System.in);
	}

<<<<<<< HEAD
	/*
	 * 신규계좌 등록하기
	 * 1. 고객번호를 입력받고
	 * 2. 고객번호가 고객정보가 있는가 확인
	 * 		BuyerServiceImplV1.getBuyer() method를 사용하여
	 * 		고객정보 찾기
	 * 		없으면 : 고객정보를 등록하세요 라고 메시지 표현
	 * 2. 고객번호가 있으면 신규 게좌를 생성 : List<AccDto> type accList 에 추가
	 */
	@Override
	public void accInit() {
		Config.bankTitle("계좌생성");
		BuyerService buService = new BuyerServiceImplV2();
		AccDto acDto = new AccDto();
		
		System.out.print("고객 ID를 입력하세요 >> ");
		String buId = scan.nextLine();
		if(buService.getBuyer(buId) == null) {
			System.out.println("고객정보를 등록하세요");
		} else {
			acDto.buId = buId;
			System.out.println("계좌번호 : 111-1111-11111");
			String acNum = "111-1111-11111";
			System.out.print("1 : 입출금통장 2 : 청약통장 >> ");
			String str = scan.nextLine();
			String acDiv = "";
			while(true) {
				if(str.equals("1")) {
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
=======
	@Override
	public void accInit() {
		// TODO Auto-generated method stub
>>>>>>> 46d90f8976019ca80cefac0851a7a94e5ea73a67

	}

	@Override
	public void inout() {
<<<<<<< HEAD
		/*
		// AccDto acDto = null;
		AccDto acDto = new AccDto();
		acDto.acNum = "0001";
		while (true) {
			//
			while(true) {
				String acNum = scan.nextLine();
				
				for(AccDto dto : accList) {
					if(acDto.acNum.equals(acNum)) {
						acDto = dto;
						break;
					}
				}
				break;
			}
			
			if(acDto == null) {
				acDto = new AccDto();
				acDto.acNum = acNum;
			}
			//
			
=======

		AccDto acDto = new AccDto();
		acDto.acNum = "0001";
		while (true) {
>>>>>>> 46d90f8976019ca80cefac0851a7a94e5ea73a67
			String br = "";
			System.out.println("입금 : 1, 출금 : 2 (종료 : QUIT)");
			String select = scan.nextLine();
			if (br.equals("QUIT")) {
				break;
			}
			if (select.equals("1")) { // 입금
				while (true) {

					System.out.print("입금할 금액 입력 >> ");
					String strInput = scan.nextLine();
					br = strInput;
					if (br.equals("QUIT")) {
						break;
					}
					try {
						int input = Integer.valueOf(strInput);
						System.out.println(input + "원 입금완료");
						acDto.acInput += input;
						break;
					} catch (Exception e) {
						System.out.println("정수를 입력하세요");
						continue;
					}

				}
<<<<<<< HEAD
			} // 입금 end
=======
			} // 2. while end
>>>>>>> 46d90f8976019ca80cefac0851a7a94e5ea73a67
			if (select.equals("2")) { // 출금

				while (true) {
					System.out.print("출금 금액 입력 >> ");
					String strOutput = scan.nextLine();
					br = strOutput;
					if (br.equals("QUIT")) {
						break;
					}
					try {
						int output = Integer.valueOf(strOutput);
						if (acDto.acInput > output) {
							acDto.acOutput = output;
							acDto.acInput -= acDto.acOutput;
							break;
						} else {
							System.out.println("잔액 부족");
							System.out.println("잔액" + acDto.acInput + "원");
							break;
						}
					} catch (Exception e) {
						System.out.println("정수를 입력하세요");
					}
				} // 3. while end
<<<<<<< HEAD

=======
				
>>>>>>> 46d90f8976019ca80cefac0851a7a94e5ea73a67
				if (br.equals("QUIT")) {
					break;
				}

<<<<<<< HEAD
			} // 출금 end
=======
			}
>>>>>>> 46d90f8976019ca80cefac0851a7a94e5ea73a67
			accList.add(acDto);
			if (br.equals("QUIT")) {
				break;
			}
		} // 1. while end
<<<<<<< HEAD
		*/
=======

>>>>>>> 46d90f8976019ca80cefac0851a7a94e5ea73a67
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
