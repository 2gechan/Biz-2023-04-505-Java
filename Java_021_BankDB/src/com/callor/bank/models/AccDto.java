package com.callor.bank.models;

public class AccDto {
	
	public String acNum;
	public String acDiv;
	public String acBuId;
	public int acBalance;

	public AccDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AccDto(String acNum, String acDiv, String acBuId, int acBalance) {
		super();
		this.acNum = acNum;
		this.acDiv = acDiv;
		this.acBuId = acBuId;
		this.acBalance = acBalance;
	}
	
	@Override
	public String toString() {
		return "AccDto [acNum=" + acNum + ", acDiv=" + acDiv + ", acBuId=" + acBuId + ", acBalance=" + acBalance + "]";
	}
	
}
