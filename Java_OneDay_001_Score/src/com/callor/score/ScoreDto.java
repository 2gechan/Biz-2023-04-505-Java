package com.callor.score;

public class ScoreDto {

	public String stNum;
	public int kor;
	public int eng;
	public int math;
	public int music;
	public int art;
	
	
	
	
	// 학생의 총점을 구하는 method
	public int getTotal() {

		// 호출한 객체의 점수를 모두 더한다.
		int total = this.kor + this.eng + this.math + this.music + this.art;
		
		return total;
	}

	// 학생의 평균을 구하는 method
	public double getAvg() {

		// 호출한 객체의 getTotal() method를 호출하여
		// 총점을 double type으로 변환 후 평균을 계산
		double avg = (double) this.getTotal() / 5;
		
		return avg;
	}
}
