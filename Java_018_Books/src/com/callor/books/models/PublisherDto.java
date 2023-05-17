package com.callor.books.models;

public class PublisherDto {
	// 출판사코드,출판사명,대표,전화번호,주소
	private String pubCode;
	private String pubName;
	private String pubCeo;
	private String pubTel;
	private String pubAddr;
	
	public PublisherDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PublisherDto(String pubCode, String pubName, String pubCeo, String pubTel, String pubAddr) {
		super();
		this.pubCode = pubCode;
		this.pubName = pubName;
		this.pubCeo = pubCeo;
		this.pubTel = pubTel;
		this.pubAddr = pubAddr;
	}

	public String getPubCode() {
		return pubCode;
	}
	public void setPubCode(String pubCode) {
		this.pubCode = pubCode;
	}
	public String getPubName() {
		return pubName;
	}
	public void setPubName(String pubName) {
		this.pubName = pubName;
	}
	public String getPubCeo() {
		return pubCeo;
	}
	public void setPubCeo(String pubCeo) {
		this.pubCeo = pubCeo;
	}
	public String getPubTel() {
		return pubTel;
	}
	public void setPubTel(String pubTel) {
		this.pubTel = pubTel;
	}
	public String getPubAddr() {
		return pubAddr;
	}
	public void setPubAddr(String pubAddr) {
		this.pubAddr = pubAddr;
	}

	@Override
	public String toString() {
		return "PublisherDto [pubCode=" + pubCode + ", pubName=" + pubName + ", pubCeo=" + pubCeo + ", pubTel=" + pubTel
				+ ", pubAddr=" + pubAddr + "]";
	}
	

}
