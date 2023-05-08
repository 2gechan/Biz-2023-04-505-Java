package com.callor.classes.models;

public class AnimalDto {
	
	private String anName;
	private String anKind;
	private int anAge;

	public String getAnName() {
		return anName;
	}

	public void setAnName(String anName) {
		this.anName = anName;
	}

	public String getAnKind() {
		return anKind;
	}

	public void setAnKind(String anKind) {
		this.anKind = anKind;
	}

	public int getAnAge() {
		return anAge;
	}

	public void setAnAge(int anAge) {
		this.anAge = anAge;
	}

	// 기본 생성자
	public AnimalDto() {
		// TODO Auto-generated constructor stub
	}

	// 임의 생성자
	public AnimalDto(String anName, String anKind, int anAge) {
		super();
		this.anName = anName;
		this.anKind = anKind;
		this.anAge = anAge;
	}

	@Override
	public String toString() {
		return "AnimalDto [anName=" + anName + ", anKind=" + anKind + ", anAge=" + anAge + "]";
	}
	
	

}
