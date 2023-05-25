package com.callor.bank.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.config.DBContract;
import com.callor.bank.models.AccDto;
import com.callor.bank.models.AccListDto;
import com.callor.bank.models.BuyerDto;
import com.callor.bank.service.impl.AccListServiceImplV1;
import com.callor.bank.service.impl.AccServiceImplV1;
import com.callor.bank.service.impl.BuyerServiceImplV1;
import com.callor.bank.utils.Line;

public class BankService {

	protected List<BuyerDto> buyerList;
	protected final BuyerService buyerService;
	protected final AccService accService;
	protected final AccListService accListService;
	protected final Scanner scan;

	public BankService() {
		buyerService = new BuyerServiceImplV1();
		accService = new AccServiceImplV1();
		accListService = new AccListServiceImplV1();
		scan = new Scanner(System.in);
	}

	public void printBuyerList() {

		buyerList = buyerService.selectAll();
		System.out.println("=".repeat(100));
		System.out.println("대한 은행 고객 리스트");
		System.out.println("=".repeat(100));
		System.out.println("ID\t이름\t전화번호\t주소\t생년월일\t직업");
		System.out.println("-".repeat(100));
		for (BuyerDto buyerDto : buyerList) {
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
		if (buDto == null) {
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
		 * if(buyerService.insert(buDto) < 1) { System.out.println("이미 등록된 회원입니다"); }
		 * else { System.out.println("회원 등록 완료"); }
		 */

	}

	public void deleteBuyer() {
		System.out.println("=".repeat(100));
		System.out.println("삭제할 고객 ID 입력하세요");

		System.out.print("ID >> ");
		String strBuId = scan.nextLine();

		BuyerDto buDto = buyerService.findById(strBuId);

		if (buDto == null) {
			System.out.printf("%s, 고객ID는 없는 정보입니다.", strBuId);
		} else {
			System.out.println(buDto.toString());
			System.out.println("고객의 정보를 정말 삭제할까요 (YES/NO)");
			String yesNo = scan.nextLine();

			if (yesNo.equals("YES")) {
				int result = buyerService.delete(strBuId);

				if (result > 0) {
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
		while (true) {
			System.out.println("수정할 고객 ID를 입력하세요");
			System.out.print("고객ID >> ");
			String strBuId = scan.nextLine();

			BuyerDto buDto = buyerService.findById(strBuId);
			if (buDto == null) {
				System.out.printf("%s, 고객 정보가 없습니다", strBuId);
				continue;
			}
			System.out.println(buDto.toString());
			System.out.printf("고객ID : %s\n", buDto.buId);

			System.out.printf("고객이름(%s) >> ", buDto.buName);
			String strBuName = scan.nextLine();
			if (!strBuName.equals(""))
				buDto.buName = strBuName;

			System.out.printf("전화번호(%s) >> ", buDto.buName);
			String strBuTel = scan.nextLine();
			if (!strBuTel.equals(""))
				buDto.buTel = strBuTel;

			int result = buyerService.update(buDto);
			if (result > 0)
				System.out.println("변경 성공");
			else
				System.out.println("변경 실패");

			break;
		}
	}

	public void findUserInfo() {

		printBuyerList();

		System.out.println("조회할 고객 ID를 입력하세요");
		System.out.print("고객 ID >> ");
		String strBuId = scan.nextLine();
		System.out.println(Line.sLine(100));

		BuyerDto buDto = buyerService.findById(strBuId);

		if (buDto != null) {
			System.out.printf("고객ID : %s\n", buDto.buId);
			System.out.printf("고객 이름 : %s\n", buDto.buName);
			System.out.printf("전화번호 : %s\n", buDto.buTel);
			System.out.printf("주소 : %s\n", buDto.buAddr);
			System.out.printf("생일 : %s\n", buDto.buBirth);
			System.out.printf("직업 : %s\n", buDto.buJob);
		} else {
			System.out.printf("%s 고객 정보가 없습니다.", strBuId);
			return;
		}
		List<AccDto> accList = accService.findByBuId(buDto.buId);
		if (accList.isEmpty()) {
			System.out.println("고객의 계좌 정보가 없습니다.");
			return;
		} else {
			System.out.println(Line.dLine(100));
			System.out.println("계좌번호\t계좌구분\tID\t잔액");
			System.out.println(Line.sLine(100));
			for (AccDto acDto : accList) {
				System.out.printf("%s\t", acDto.acNum);

				int intDiv = 0;

				try {
					intDiv = Integer.valueOf(acDto.acDiv);
					System.out.printf("%s\t", DBContract.ACC_DIV[intDiv - 1]);
				} catch (Exception e) {
					System.out.printf("%s\t", "종류불명");
				}
				System.out.printf("%s\t", acDto.acBuId);
				System.out.printf("%d\n", acDto.acBalance);
			}
			System.out.println(Line.dLine(100));
		}

	}

	/*
	 * 계좌 만들기 계좌번호 : 날짜 + 일련번호
	 */
	public void makeAcount() {

		System.out.println("고객 ID를 입력하세요");
		System.out.print("고객 ID >> ");
		String strId = scan.nextLine();
		BuyerDto buDto = buyerService.findById(strId);
		AccDto accDto = new AccDto();

		if (buDto == null) {
			System.out.printf("조회하신 고객 ID : %S의 정보가 없습니다.", strId);
			return;
		} else {
			System.out.printf("고객ID : %s\n", buDto.buId);
			System.out.printf("고객 이름 : %s\n", buDto.buName);
			System.out.printf("전화번호 : %s\n", buDto.buTel);
			System.out.printf("주소 : %s\n", buDto.buAddr);
			System.out.printf("생일 : %s\n", buDto.buBirth);
			System.out.printf("직업 : %s\n", buDto.buJob);

			LocalDate localDate = LocalDate.now();
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("YYYYMMdd");
			String strDate = localDate.format(dateFormat);

			// List<AccDto> accList = accService.selectAll();

			int maxNum = Integer.valueOf(accService.maxAcNum(strDate)) + 1;
			String acNum = String.format("%s%02d", strDate, maxNum);

//			int maxDate = 0;
//			for(AccDto acDto : accList) {
//				if(acDto.acNum.substring(0,strDate.length()).equals(strDate)) {
//					int numDate = Integer.valueOf(acDto.acNum);
//					if(maxDate < numDate) {
//						maxDate = numDate;
//					}
//				}
//			}
//			String acNum = "";
//			if(maxDate == 0) {
//				maxDate = Integer.valueOf(strDate);
//				acNum = maxDate + "01";
//				accDto.acNum = acNum;
//				System.out.printf("생성된 계좌번호 : %s\n", acNum);
//			} else {
//				acNum = (++maxDate) + "";
//				accDto.acNum = acNum;
//				System.out.printf("생성된 계좌번호 : %s\n", acNum);
//			}

			accDto.acNum = acNum;
			while (true) {
				System.out.print("계좌를 선택하세요 : 1. 입출금계좌 2. 적금계좌 3. 대출계좌 >> ");
				String acDiv = scan.nextLine();
				if (acDiv.equals("1") || acDiv.equals("2") || acDiv.equals("3")) {
					accDto.acDiv = acDiv;
					break;
				} else {
					System.out.println("1 ~ 3 중 다시 선택하세요");
					continue;
				}
			}
			accDto.acBuId = strId;
			accDto.acBalance = 10000;
			accService.insert(accDto);

			System.out.println(Line.dLine(100));
			System.out.println("생성된 계좌");
			System.out.println(Line.sLine(100));
			System.out.printf("계좌번호 : %s\n", accDto.acNum);
			int intDiv = 0;
			try {
				intDiv = Integer.valueOf(accDto.acDiv);
				System.out.printf("계좌 구분 : %s\n", DBContract.ACC_DIV[intDiv - 1]);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.printf("고객ID : %s\n", accDto.acBuId);
			System.out.printf("잔액 : %s\n", accDto.acBalance);
			System.out.println(Line.dLine(100));
		}

	}

	public void insertAccList() {

		this.findUserInfo();

		/*
		  printBuyerList();
		  System.out.println("고객 ID를 입력하세요"); 
		  System.out.print("고객ID >> "); 
		  String strBuId = scan.nextLine();
		  
		  while(true) {
		   		List<AccDto> accList = accService.findByBuId(strBuId);
		   		 if (accList.isEmpty()) {
		   		  		System.out.println("생성된 계좌가 없습니다. (1:계좌 생성, QUIT: 종료"));
		  				String noAcc = scan.nextLine(); 
		  				if(noAcc.equals("1")) { 
		  							this.makeAcount();
		  							continue; 
		  				} else if(noAcc.equals("QUIT")) break; 
		  		} else {
		  				System.out.println(Line.dLine(100));
		  				System.out.println("계좌번호\t계좌구분\t고객ID\t잔액");
		  				System.out.println(Line.sLine(100)); 
		  				
		  				for (AccDto acDto : accList) {
		  						System.out.printf("%s\t", acDto.acNum); 
		  						int intDiv = 0; 
		  						try { 
		  						intDiv = Integer.valueOf(acDto.acDiv); 
		  						} catch (Exception e) { 
		  						// TODO: handle exception 
		  						} 
		  						
		  						System.out.printf("%s\t", DBContract.ACC_DIV[intDiv-1]);
		  						System.out.printf("%s\t", acDto.acBuId);
		  					 	System.out.printf("%d\n", acDto.acBalance); 
		  				}
		  				System.out.println(Line.dLine(100)); 
		  		}
		  }
		 */
		while (true) {
			AccListDto accListDto = new AccListDto();
			System.out.print("계좌번호를 입력하세요 >> ");
			String acNum = scan.nextLine();

			AccDto acDto = accService.findById(acNum);
			if (acDto == null) {
				System.out.println("입력된 계좌번호가 존재하지 않습니다");
				return;
			} else {
				String select = "";
				int input = 0;
				int output = 0;
				while (true) {
					System.out.print("거래를 선택하세요 (1:입금, 2:출금, -1:종료) >> ");
					select = scan.nextLine();
					if (select.equals("1")) {
						while (true) {
							System.out.print("입금할 금액을 입력하세요 (종료:QUIT) >> ");
							String strInput = scan.nextLine();
							if(strInput.equals("QUIT")) {
								return;
							}

							try {
								input = Integer.valueOf(strInput);
								acDto.acBalance += input;
							} catch (Exception e) {
								System.out.println("입금액을 다시 입력하세요");
								continue;
							}
							break;
						}
						break;
					} else if (select.equals("2")) {
						while (true) {
							System.out.print("출금할 금액을 입력하세요 (종료:QUIT) >> ");
							String strOutput = scan.nextLine();
							if(strOutput.equals("QUIT")) {
								return;
							}
							try {
								output = Integer.valueOf(strOutput);
								if (acDto.acBalance < output) {
									System.out.println("잔액이 부족합니다.");
									System.out.printf("잔액 : %d\n", acDto.acBalance);
									continue;
								} else {
									acDto.acBalance -= output;
								}

							} catch (Exception e) {
								System.out.println("출금액을 다시 입력하세요");
								continue;
							}
							break;
						}
						break;
					} else if (select.equals("-1")){
						System.out.println("종료");
						return;
					} else {
						System.out.println("잘못 입력하셨습니다");
						continue;
					}
				}
				LocalDateTime localDateTime = LocalDateTime.now();

				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("YYYY-MM-dd");
				DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

				String date = localDateTime.format(dateFormat);
				String time = localDateTime.format(timeFormat);

				accListDto.acNum = acNum;
				accListDto.aioDate = date;
				accListDto.aioTime = time;
				accListDto.aioDiv = select;
				accListDto.aioInput = input;
				accListDto.aioOutput = output;

				int result = accListService.insert(accListDto);

				accService.update(acDto);
				
				if (result > 0) {
					System.out.println("거래 완료");
					List<AccDto> acList = accService.findByBuId(acNum);
					System.out.println(Line.dLine(100));
					System.out.println("계좌번호\t계좌구분\t고객ID\t잔액");
					System.out.println(Line.sLine(100));
					
					for (AccDto accDto : acList) {

						System.out.printf("%s\t", accDto.acNum);
						int intDiv = 0;
						try {
							intDiv = Integer.valueOf(accDto.acDiv);
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						System.out.printf("%s\t", DBContract.ACC_DIV[intDiv - 1]);
						System.out.printf("%s\t", accDto.acBuId);
						System.out.printf("%d\n", accDto.acBalance);
					}
					System.out.println(Line.dLine(100));
				} else {
					System.out.println("거래 실패");
				}
			}
			break;
		}
	}

}
