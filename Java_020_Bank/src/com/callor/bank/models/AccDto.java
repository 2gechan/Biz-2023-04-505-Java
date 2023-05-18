package com.callor.bank.models;

/*
<<<<<<< HEAD
 * 계좌정보 데이터 클래스
 * 계좌번호 : acNum
 * 계좌구분 : acDiv
 * 고객ID : buId  
 * 최종잔액 : acBalance
 */
public class AccDto {
	
	public String acNum;
	public String acDiv;
	public String buId;
	public int acBalance;
=======
 * 고객ID 				buId
 * 계좌번호	문자열(10)	acNum
 * 거래일자	문자열		acDate
 * 거래구분	문자열		acDiv
 * 입금		정수형		acInput
 * 출금		정수형		acOutput
 * 거래시각	문자열		acTime
 */
public class AccDto {
	
	public String buId;
	public String acNum;
	public String acDate;
	public String acDiv;
	public int acInput;
	public int acOutput;
	public String acTime;
>>>>>>> 46d90f8976019ca80cefac0851a7a94e5ea73a67
	
	public AccDto() {
		super();
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	public AccDto(String acNum, String acDiv, String buId, int acBalance) {
		super();
		this.acNum = acNum;
		this.acDiv = acDiv;
		this.buId = buId;
		this.acBalance = acBalance;
=======
	public AccDto(String buId, String acNum, String acDate, String acDiv, int acInput, int acOutput, String acTime) {
		super();
		this.buId = buId;
		this.acNum = acNum;
		this.acDate = acDate;
		this.acDiv = acDiv;
		this.acInput = acInput;
		this.acOutput = acOutput;
		this.acTime = acTime;
>>>>>>> 46d90f8976019ca80cefac0851a7a94e5ea73a67
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "AccDto [acNum=" + acNum + ", acDiv=" + acDiv + ", buId=" + buId + ", acBalance=" + acBalance + "]";
	}
	
=======
		return "AccDto [buId=" + buId + ", acNum=" + acNum + ", acDate=" + acDate + ", acDiv=" + acDiv + ", acInput="
				+ acInput + ", acOutput=" + acOutput + ", acTime=" + acTime + "]";
	}
	
	
>>>>>>> 46d90f8976019ca80cefac0851a7a94e5ea73a67
}
