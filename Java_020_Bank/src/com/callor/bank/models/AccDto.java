package com.callor.bank.models;

/*
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
	
	public AccDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccDto(String buId, String acNum, String acDate, String acDiv, int acInput, int acOutput, String acTime) {
		super();
		this.buId = buId;
		this.acNum = acNum;
		this.acDate = acDate;
		this.acDiv = acDiv;
		this.acInput = acInput;
		this.acOutput = acOutput;
		this.acTime = acTime;
	}

	@Override
	public String toString() {
		return "AccDto [buId=" + buId + ", acNum=" + acNum + ", acDate=" + acDate + ", acDiv=" + acDiv + ", acInput="
				+ acInput + ", acOutput=" + acOutput + ", acTime=" + acTime + "]";
	}
	
	
}
