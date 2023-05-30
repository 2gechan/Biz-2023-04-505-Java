package com.callor.shop.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.callor.shop.config.DBConnection;
import com.callor.shop.config.Line;
import com.callor.shop.mapper.BuyerDao;
import com.callor.shop.mapper.IoListDao;
import com.callor.shop.mapper.ProductDao;
import com.callor.shop.models.BuyerDto;
import com.callor.shop.models.IoListDto;
import com.callor.shop.models.ProductDto;

public class ShopService {

	protected SqlSession sqlSession;
	protected ProductDao pDao;
	protected BuyerDao buDao;
	protected IoListDao ioDao;
	Scanner scan;

	public ShopService() {
		sqlSession = DBConnection.getFactory().openSession(true);
		pDao = sqlSession.getMapper(ProductDao.class);
		buDao = sqlSession.getMapper(BuyerDao.class);
		ioDao = sqlSession.getMapper(IoListDao.class);
		scan = new Scanner(System.in);
	}

	// 상품리스트 반복 코드
	public void print2Product(ProductDto pDto) {
		System.out.printf("%s\t", pDto.pCode);
		System.out.printf("%s\t", pDto.pName);
		System.out.printf("%s\t", pDto.pItem);
		System.out.printf("%d\t", pDto.pIPrice);
		System.out.printf("%d\n", pDto.pOPrice);
	}

	// 고객리스트 반복 코드
	public void print2Buyer(BuyerDto buDto) {
		System.out.printf("%s\t", buDto.buId);
		System.out.printf("%s\t", buDto.buName);
		System.out.printf("%s\t", buDto.buTel);
		System.out.printf("%s\n", buDto.buAddr);
	}
	
	// 거래내역 반복 코드
	public void print2trade(IoListDto ioDto) {
		BuyerDto buDto = buDao.findById(ioDto.ioBuId);
		ProductDto pDto = pDao.findById(ioDto.ioPCode);
		
		System.out.printf("%s\t", ioDto.ioDate);
		System.out.printf("%s\t", ioDto.ioTime);
		System.out.printf("%s\t", ioDto.ioBuId);
		System.out.printf("%s\t", buDto.buName);
		System.out.printf("%s\t", buDto.buTel); 
		System.out.printf("%s\t", ioDto.ioPCode);
		System.out.printf("%s\t", pDto.pOPrice);
		System.out.printf("%d\t", ioDto.ioQuan);
		System.out.printf("%d\n", ioDto.ioPrice);
	}

	// 상품리스트 전체를 출력하는 method
	public void printProduct() {
		System.out.println(Line.dLine(100));
		System.out.println("상품코드\t상품명\t품목\t매입단가\t매출단가");
		System.out.println(Line.sLine(100));
		List<ProductDto> productList = pDao.findAll();
		for (ProductDto pDto : productList) {
			this.print2Product(pDto);
		}
		System.out.println(Line.dLine(100));
	}

	public void insertProduct() {
		
		String pCode = "";
		while(true) {
			System.out.print("상품코드 >> ");
			pCode = scan.nextLine();
			if(pCode.equals("")) {
				System.out.println("상품코드는 필수 입력입니다");
				continue;
			}
			break;
			
		}
		ProductDto pDto = pDao.findById(pCode);

		if (pDto != null) {
			this.print2Product(pDto);
		} 

		System.out.printf("( %s ) 상품명 >> ", pDto == null ? pCode : "상품수정");
		String pName = scan.nextLine();

		System.out.printf("( %s ) 품목 >> ", pDto == null ? pCode : "상품수정");
		String pItem = scan.nextLine();
		int pIPrice = 0;
		while (true) {
			System.out.printf("( %s ) 매입단가 >> ", pDto == null ? pCode : "상품수정");
			String strPIPrice = scan.nextLine();

			try {
				pIPrice = Integer.valueOf(strPIPrice);
			} catch (Exception e) {
				System.out.println("매입 단가는 정수로 입력하세요");
				continue;
			}
			break;
		}

		int pOPrice = (int) (pIPrice + Math.round(pIPrice * 0.22));

		if (pDto == null) {
			pDto = new ProductDto();
			pDto.pCode = pCode;
			pDto.pName = pName;
			pDto.pItem = pItem;
			pDto.pIPrice = pIPrice;
			pDto.pOPrice = pOPrice;
			pDao.insert(pDto);
		} else {
			pDto.pName = pName;
			pDto.pItem = pItem;
			pDto.pIPrice = pIPrice;
			pDto.pOPrice = pOPrice;
			pDao.update(pDto);
		}
	}

	public void printBuyer() {
		List<BuyerDto> buList = buDao.findAll();
		System.out.println(Line.dLine(100));
		System.out.println("고객ID\t고객이름\t전화번호\t주소");
		System.out.println(Line.sLine(100));
		for (BuyerDto buDto : buList) {
			this.print2Buyer(buDto);

		}
		System.out.println(Line.dLine(100));
	}

	public void insertBuyer() {
		List<BuyerDto> buList = buDao.findAll();
		System.out.print("회원 수정을 원하시면 ID를 입력하세요 >> ");
		String  idCheck = scan.nextLine();
		if(idCheck.equals("")) {
			idCheck = "0";
		}
		BuyerDto buDto = null;
		
		int maxId = 0;
		for (BuyerDto bDto : buList) {
			if(idCheck.equals(bDto.buId)) {
				buDto = bDto;
				break;
			}
			int intId = Integer.valueOf(bDto.buId);
			if (maxId < intId) {
				maxId = intId;
			}
		}
		
		maxId += 1;
		
		String buId = String.format("%010d", maxId);
		
		System.out.printf("( %s ) 고객이름 >> ", buDto == null ? "신규" : buDto.buName);
		String buName = scan.nextLine();
		
		System.out.printf("( %s ) 전화번호 >> ", buDto == null ? "신규" : buDto.buTel);
		String buTel = scan.nextLine();
		
		System.out.printf("( %s ) 주소 >> ", buDto == null ? "신규" : buDto.buAddr);
		String buAddr = scan.nextLine();
		
		
		if(buDto == null) {
			buDto = new BuyerDto();
			buDto.buId = buId;
			buDto.buName = buName;
			buDto.buTel = buTel;
			buDto.buAddr = buAddr;
			buDao.insert(buDto);
		} else {
			if(buName.equals("")) buName = buDto.buName;
			buDto.buName = buName;
			if(buTel.equals("")) buTel = buDto.buTel;
			buDto.buTel = buTel;
			if(buAddr.equals("")) buAddr = buDto.buAddr;
			buDto.buAddr = buAddr;
			buDao.update(buDto);
		}
	}

	// 장바구니 담기
	public void shoppingCart() {

		this.printBuyer();
		String buId = "";
		while(true) {
			
			System.out.println("고객 ID >> ");
			buId = scan.nextLine();
			int intBuId = 0;
			try {
				intBuId = Integer.valueOf(buId);
			} catch (Exception e) {
				System.out.println("고객 ID는 정수로 입력하세요");
				continue;
			}
			buId = String.format("%010d", intBuId);
			BuyerDto buDto = buDao.findById(buId);
			
			if (buDto == null) {
				System.out.println("존재하지 않는 고객ID 입니다");
				return;
			}
			break;
		}

		this.printProduct();
		
	
		ProductDto pDto = null;
		String pCode = "";
		while(true) {
			System.out.println("상품 코드 >> ");
			String strPCode = scan.nextLine();	
			try {
				int intPCode = Integer.valueOf(strPCode);
				pCode = String.format("%013d", intPCode);
				System.out.println(pCode);
			} catch (Exception e) {
				System.out.println("상품 코드는 정수로 입력하세요");
				continue;
			}
			pDto = pDao.findById(pCode);
			
			if (pDto == null) {
				System.out.println("존재하지 않는 상품코드 입니다.");
				return;
			}
			break;
		}
		
		IoListDto ioDto = new IoListDto();

		LocalDateTime localDateTime = LocalDateTime.now();

		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

		String date = localDateTime.format(dateFormat);
		String time = localDateTime.format(timeFormat);
		ioDto.ioDate = date;
		ioDto.ioTime = time;
		ioDto.ioBuId = buId;
		ioDto.ioPCode = pCode;
		
		int ioQuan = 0;
		while(true) {
			System.out.print("수량 >> ");
			String strIoQuan = scan.nextLine();
			
			try {
				ioQuan = Integer.valueOf(strIoQuan);
			} catch (Exception e) {
				System.out.println("수량은 정수로 입력하세요");
				continue;
			}
			break;
		}
		
		ioDto.ioQuan = ioQuan;
		ioDto.ioPrice = pDto.pOPrice * ioQuan;
		
		ioDao.insert(ioDto);

	}

	// 전체 리스트 출력
	public void printTradeAll() {

		System.out.println(Line.dLine(150));
		System.out.println("상품판매 리스트");
		System.out.println(Line.dLine(150));
		System.out.println("거래일자\t거래시각\t" 
				+ "고객ID\t고객이름\t전화번호\t" 
				+ "상품코드\t상품명\t판매단가\t수량\t판매합계");
		System.out.println(Line.sLine(150));
		List<IoListDto> ioList = ioDao.findAll();
		for(IoListDto ioDto : ioList) {
			this.print2trade(ioDto);
		}
	}
	
	public void printBuyerCart() {
		int intBuId = 0;
		String buId = "";
		while(true) {
			System.out.println("고객 ID를 입력하세요");
			System.out.print("고객 ID >> ");
			buId = scan.nextLine();
			try {
				intBuId = Integer.valueOf(buId);
				
			} catch (Exception e) {
				System.out.println("고객 ID는 정수로 입력하세요");
				continue;
			}
			break;
		}
		buId = String.format("%010d", intBuId);
		
		List<IoListDto> ioList = ioDao.findById(buId);
		System.out.println(Line.sLine(150));
		for(IoListDto ioDto : ioList) {
			this.print2trade(ioDto);
		}
		System.out.println(Line.dLine(150));
	}

}
