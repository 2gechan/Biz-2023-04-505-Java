package com.callor.bank.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.models.AccDto;
import com.callor.bank.service.AccService;

public class AccServiceImplV1 implements AccService {

	protected List<AccDto> accList;
	protected Scanner scan;

	public AccServiceImplV1() {
		accList = new ArrayList<>();
		scan = new Scanner(System.in);
	}

	@Override
	public void accInit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inout() {

		AccDto acDto = new AccDto();
		acDto.acNum = "0001";
		while (true) {
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
			} // 2. while end
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

			}
			accList.add(acDto);
			if (br.equals("QUIT")) {
				break;
			}
		} // 1. while end

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
