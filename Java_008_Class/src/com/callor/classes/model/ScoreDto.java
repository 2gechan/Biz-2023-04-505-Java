package com.callor.classes.model;

/*
 * 성적처리를 할 때,
 * 학생이름, 각 과목의 점수를 속성으로 포함하는
 * 데이터 객체를 모델링 하자
 * Dto 클래스 : 데이터 객체를 모델링한 java 클래스
 * 
 * 모델링 단계
 * 
 * 1. 추상화 단계
 *  성적처리(정보기기를 사용하여 성적처리를 하기)를
 *  수행하기 위하여 꼭 필요한 데이터 요소가 무엇이 있을까
 * 2. (Dto) 클래스 모델링
 *  추상화된 각 요소를 클래스로 만드는 과정
 *  => 클래스에 변수를 선언하기
 *  
 *  7개 과목을 처리할 것이고,
 *  학번과 학생이름이 포함되어야 할 것이다
 */
public class ScoreDto {
	
	// 성적처리를 하는데 학생의 정보 요소도 필요
	public String stNum; // 학번
	public String stName; // 이름
	
	// 성적 처리에 필요한 7개 과목 요소 선언(변수로 선언)
	public int kor;
	public int eng;
	public int math;
	public int his;
	public int mus;
	public int art;
	public int phy;
	
	public int getTotal() {
		int total = this.kor + this.eng + this.math + this.his
				+ this.mus + this.art + this.phy;
		return total;
	}
	
	public float getAvg() {
		int total = this.getTotal();
		float avg = (float)total / 7;
		return avg;
	}

}
