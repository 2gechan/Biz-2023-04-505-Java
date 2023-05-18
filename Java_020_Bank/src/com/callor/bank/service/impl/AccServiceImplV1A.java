package com.callor.bank.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.models.AccDto;
import com.callor.bank.models.BuyerDto;
import com.callor.bank.service.AccService;
import com.callor.bank.service.BuyerService;
import com.callor.bank.utils.AnsiConsol;
import com.callor.bank.utils.Config;
import com.callor.bank.utils.Line;

public class AccServiceImplV1A implements AccService {

	protected List<AccDto> accList;
	protected Scanner scan;
	BuyerService buService = new BuyerServiceImplV2();

	public AccServiceImplV1A() {
		accList = new ArrayList<>();
		scan = new Scanner(System.in);
	}
	
	// 새로운 계좌번호를 자동으로 생성하기
	/*
	 * 계좌번호 format
	 * 1000-2023-05-18-0001
	 * 
	 * "1000" : 은행코드
	 * "2023-05-18" : 계좌를 신설한 날짜
	 * "0001" : 일련번호
	 */
	protected String getNewAccNum() {
		
		// 컴퓨터의 현재 시각을 get 하는 클래스
		// System.currentTimeMillis()
		// 	1970.1.1 00:00:00.000 부터 시작하여
		//	현재 시점까지 카운트된 밀리세컨드 값
		// 이 값을 Date 클래스의 생성자에 전달하면
		// 현재 날짜, 시각 정보를 알 수 있는 객체로 생성해 준다.
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat todayFormat = new SimpleDateFormat("YYYY-MM-dd");
		String todayString = todayFormat.format(date);
		
		int maxNum = 0;
		String numBank = "1000";
		for(AccDto accDto : accList) {
			
			// 1000-2023-05-18-0001
			// 1000-2023-05-18-0002
			// 1000-2023-05-18-0003
			// 1000-2023-05-18-0004
			// 1000-2023-05-18-0005 
			String accNum = accDto.acNum;
			// 0부터 4글자 잘라서 bank 코드 추출하기
			numBank = accNum.substring(0,4);
			
			// 날짜 부분 추출하기
			String numDate = accNum.substring(numBank.length() + 1, numBank.length() + todayString.length());
			
			if(numDate != null && numDate.equals(todayString)) {
				// 일련번호 부분만 추출하기
				String lastNum = accNum.substring(numBank.length() + todayString.length()+2);
				int intNum = Integer.valueOf(lastNum);
				if(maxNum > intNum) maxNum = intNum;
			}
		}
		String newNum = String.format("%s-%s-%04d", numBank, todayString, maxNum+1);
		return newNum;
	}
	

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
		
		while(true) {
			
			String accNum = getNewAccNum();
			
			System.out.println(Line.sLine(100));
			System.out.println("생성된 계좌번호 : " + accNum);
			System.out.println(Line.sLine(100));
			
			String strBuId = "";
			while(true) {
				System.out.println("고객번호를 입력해 주세요 (종료 : QUIT)");
				System.out.print("고객번호 >> ");
				strBuId = scan.nextLine();
				if(strBuId.equals("QUIT")) break;
				
				try {
					int intBuId = Integer.valueOf(strBuId);
					strBuId = String.format("%04d", intBuId);
					BuyerDto buyerDto = buService.getBuyer(strBuId);
					if(buyerDto == null) {
						System.out.println(AnsiConsol.message("RED", "고객정보가 없습니다"));
						System.out.println(AnsiConsol.BLUE("고객정보를 먼저 등록해 주세요"));
					} else {
						System.out.println(Line.sLine(100));
						System.out.println(buyerDto.toString());
						System.out.println(Line.sLine(100));
					}
				} catch (Exception e) {
					System.out.println("고객번호는 정수로 입력하세요");
				}
			}
			if(strBuId.equals("QUIT")) {
				break;
			}
		}

	}

	@Override
	public void inout() {
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
			} // 입금 end
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

				if (br.equals("QUIT")) {
					break;
				}

			} // 출금 end
			accList.add(acDto);
			if (br.equals("QUIT")) {
				break;
			}
		} // 1. while end
		*/
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
