package com.callor.bank.service.impl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.models.BuyerDto;
import com.callor.bank.service.BuyerService;

public class BuyerServiceImplV1 implements BuyerService {

	protected List<BuyerDto> buList;

	public BuyerServiceImplV1() {
		buList = new ArrayList<>();
	}

	@Override
	public void loadBuyer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printBuyerList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printBuyerList(PrintWriter out) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BuyerDto getBuyer(String buId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inputbuyer() {
		Scanner scan = new Scanner(System.in);
		while (true) {

			System.out.println("=".repeat(50));
			System.out.println("고객 정보를 입력(종료 : Q)");
			System.out.println("=".repeat(50));

			BuyerDto buDto = new BuyerDto();
			String buId = "";
			String StringId = "";
			
			while (true) {
				System.out.print("고객ID >> ");
				StringId = scan.nextLine();
				if (StringId.equals("Q")) {
					break;
				}
				try {
					buId = String.format("%04d", Integer.valueOf(StringId));
				} catch (Exception e) {
					System.out.println("Id를 정수로 입력해주세요");
					continue;
				}
				break;
			}
			if (StringId.equals("Q")) {
				break;
			}
			
			int check = 0;
			for (BuyerDto dto : buList) {
				if (buId.equals(dto.buID)) {
					buDto = dto;
					check++;
					break;
				}
			}

			System.out.printf("고객이름(%s) >> ", buDto.buName == null ? "신규" : buDto.buName);
			String buName = scan.nextLine();
			if (buName.equals("Q")) {
				break;
			}
			if(buName.equals("")) {
				buName = buDto.buName;
			}

			System.out.printf("전화번호(%s) >> ", buDto.buTel == null ? "신규" : buDto.buTel);
			String buTel = scan.nextLine();
			if (buTel.equals("Q")) {
				break;
			}
			if(buTel.equals("")) {
				buTel = buDto.buTel;
			}

			System.out.printf("주소(%s) >> ", buDto.buAddr == null ? "신규" : buDto.buAddr);
			String buAddr = scan.nextLine();
			if (buAddr.equals("Q")) {
				break;
			}
			if(buAddr.equals("")) {
				buAddr = buDto.buAddr;
			}

			System.out.printf("생년월일(%s) >> ", buDto.buBirth == null ? "신규" : buDto.buBirth);
			String buBirth = scan.nextLine();
			if (buBirth.equals("Q")) {
				break;
			}
			if(buBirth.equals("")) {
				buBirth = buDto.buBirth;
			}

			System.out.printf("직업(%s) >> ", buDto.buJob == null ? "신규" : buDto.buJob);
			String buJob = scan.nextLine();
			if (buJob.equals("Q")) {
				break;
			}
			if(buJob.equals("")) {
				buJob = buDto.buJob;
			}

			buDto.buID = buId;
			buDto.buName = buName;
			buDto.buTel = buTel;
			buDto.buAddr = buAddr;
			buDto.buBirth = buBirth;
			buDto.buJob = buJob;

			if (check > 0) {
				continue;
			} else {
				buList.add(buDto);
			}
		}
	}

}
