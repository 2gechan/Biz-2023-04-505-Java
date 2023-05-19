package com.callor.bank.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.models.BuyerDto;
import com.callor.bank.service.BuyerService;
import com.callor.bank.utils.Config;
import com.callor.bank.utils.Index;
import com.callor.bank.utils.Line;

public class BuyerServiceImplV2 implements BuyerService {
	Scanner scan;
	protected List<BuyerDto> buList;

	public BuyerServiceImplV2() {
		buList = new ArrayList<>();
		scan = new Scanner(System.in);
	}

	@Override
	public void loadBuyer() {
		String file = Config.BUYER_FILE;
		InputStream is = null;
		
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scan = new Scanner(is);
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] bArr = line.split("\t");
			
			BuyerDto buDto = new BuyerDto();
			buDto.buId = bArr[Index.BUYER.BU_ID];
			buDto.buName = bArr[Index.BUYER.BU_NAME];
			buDto.buTel = bArr[Index.BUYER.BU_TEL];
			buDto.buAddr = bArr[Index.BUYER.BU_ADDR];
			buDto.buBirth = bArr[Index.BUYER.BU_BIRTH];
			buDto.buJob = bArr[Index.BUYER.BU_JOB];
			
			buList.add(buDto);
		}
		scan.close();
		for(BuyerDto dto : buList) {
			System.out.println(dto.toString());
		}

	}

	/*
	 * 화면 출력을 위하여 리스트 머릿글 부분을 System.out.println() 으로 출력하고
	 * System.out 이 연결된 PrintWriter를 화면용으로 생성하여
	 * printBuyerList(PrintWriter) method에 전달하여 본문 출력
	 */
	@Override
	public void printBuyerList() {
		
		
		OutputStream os = System.out;
		PrintWriter out = new PrintWriter(os);
		
		System.out.println(Line.dLine(100));
		System.out.println("고객정보 리스트");
		System.out.println(Line.dLine(100));
		System.out.println("고객ID\t고객명\t전화번호\t주소\t생년월일\t직업");
		// OutputStream os = System.out 이고,
		// PrintWriter out = new PrintWriter(os) 때문에,
		// 콘솔에 출력이 가능
		printBuyerList(out);
		System.out.println(Line.dLine(100));
		out.close();

	}

	/*
	 * 매개변수로 전달받는 PrintWriter 객체의 구분에 따라
	 * 화면에 출력, 파일에 출력
	 */
	@Override
	public void printBuyerList(PrintWriter out) {
		
		for(BuyerDto dto : buList) {
			out.printf("%s\t", dto.buId);
			out.printf("%s\t", dto.buName);
			out.printf("%s\t", dto.buTel);
			out.printf("%s\t", dto.buAddr);
			out.printf("%s\t", dto.buBirth);
			out.printf("%s\n", dto.buJob);
		}
		
	}

	@Override
	public BuyerDto getBuyer(String buId) {
		
		if(buList.isEmpty()) {
			loadBuyer();
		}
		
		for(BuyerDto dto : buList) {
			if(buId.equals(dto.buId)) {
				return dto;
			}
			
		}
		// TODO Auto-generated method stub
		return null;
	}

	protected int getMaxId() {
		
		int maxId = 0;
		for(BuyerDto dto : buList) {
			int intId = Integer.valueOf(dto.buId);
			if(intId > maxId) {
				maxId = intId;
			}
		}
		return maxId + 1;
	}
	
	
	protected BuyerDto buyerItemInput() {

		// 값에 대한 검증을 하기 위한 while
		BuyerDto buDto = null;
		String buId = "";
		
		while (true) {

			System.out.printf("고객ID(%04d) >> ", getMaxId());
			buId = scan.nextLine();
			// Q처럼 단독 알파벳을 사용하게 되면
			// 종료를 원할때 간편하지만,
			// 실수로 쉽게 누를 수 있기 때문에
			// QUIT를 사용하여 알파벳을 잘못 입력해
			// 종료되는 것을 방지할 수 있다.
			if (buId.equals("QUIT")) return null;
			if (buId.equals("")) {
				buId = String.format("%04d", getMaxId());
			}

			try {
				int intBuId = Integer.valueOf(buId);
				buId = String.format("%04d", intBuId);
				
			} catch (Exception e) {
				System.out.println("고객 Id는 정수로만 입력하세요");
			}
			for (BuyerDto dto : buList) {
				if (buId.equals(dto.buId)) {
					System.out.println("이미 존재하는 ID 입니다.");
					buDto = dto;
					break;
				}
			}
			break;
		} // buID 입력 끝
		
		if (buId.equals("QUIT")) return null;

		System.out.printf("고객 이름(%s) >> ", buDto == null ? "신규" : buDto.buName);
		String buName = scan.nextLine();
		if (buName.equals("QUIT")) return null;
		if(buName.equals("")) buName = buDto.buName;

		System.out.printf("전화번호(%s) >> ", buDto == null ? "신규" : buDto.buTel);
		String buTel = scan.nextLine();
		if (buTel.equals("QUIT")) return null;
		if(buTel.equals("")) buTel = buDto.buTel;

		System.out.printf("주소(%s) >> ", buDto == null ? "신규" : buDto.buAddr);
		String buAddr = scan.nextLine();
		if (buAddr.equals("QUIT")) return null;
		if(buAddr.equals("")) buAddr = buDto.buAddr;

		System.out.printf("생년월일(%s) >> ", buDto == null ? "신규" : buDto.buBirth);
		String buBirth = scan.nextLine();
		if (buBirth.equals("QUIT")) return null;
		if(buBirth.equals("")) buBirth = buDto.buBirth;

		System.out.printf("직업(%s) >> ", buDto == null ? "신규" : buDto.buJob);
		String buJob = scan.nextLine();
		if (buJob.equals("QUIT")) return null;
		if(buJob.equals("")) buJob = buDto.buJob;

		if(buDto == null) buDto = new BuyerDto();
		
		buDto.buId = buId;
		buDto.buName = buName;
		buDto.buTel = buTel;
		buDto.buAddr = buAddr;
		buDto.buBirth = buBirth;
		buDto.buJob = buJob;

		return buDto;
	}

	@Override
	public void inputbuyer() {

		// 전체적인 입력 반복을 위한 while
		while (true) {
			System.out.println(Line.dLine(50));
			System.out.println("고객 정보 관리");
			System.out.println(Line.sLine(50));

			BuyerDto buDto = buyerItemInput();
			if (buDto == null) break;
			/*
			 * 
			 * buList 데이터를 추가 또는 수정
			 * buList 데이터에 buDto 요소가 없으면 추가,
			 * 있으면 무시
			 * 주소에 대한 개념으로 이해하여 보자
			 * 
			 * List type 객체의 contains method
			 * List type 객체(buyerList)의 요소 중에
			 * buDto 변수에 담긴 주소를 가진 요소가 있는지 확인
			 */
			if(!buList.contains(buDto)) buList.add(buDto);
		}
		System.out.println("고객정보 입력 종료");
		
		OutputStream os = null;
		PrintWriter out = null;
		
		try {
			os = new FileOutputStream(Config.BUYER_FILE);
			out = new PrintWriter(os);
			
			printBuyerList(out);
			out.close();
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
