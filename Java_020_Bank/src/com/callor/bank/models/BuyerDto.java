package com.callor.bank.models;

/*
 * 고객ID	문자열(10)	buID
 * 고객이름	문자열		buName 
 * 전화번호	문자열		buTel
 * 주소		문자열		buAddr
 * 생년월일	문자열		buBirth
 * 직업		문자열		buJob
 */

public class BuyerDto {

	public String buID;
	public String buName;
	public String buTel;
	public String buAddr;
	public String buBirth;
	public String buJob;
	
	public BuyerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuyerDto(String buID, String buName, String buTel, String buAddr, String buBirth, String buJob) {
		super();
		this.buID = buID;
		this.buName = buName;
		this.buTel = buTel;
		this.buAddr = buAddr;
		this.buBirth = buBirth;
		this.buJob = buJob;
	}

	@Override
	public String toString() {
		return "BuyerDto [buID=" + buID + ", buName=" + buName + ", buTel=" + buTel + ", buAddr=" + buAddr
				+ ", buBirth=" + buBirth + ", buJob=" + buJob + "]";
	}

}
