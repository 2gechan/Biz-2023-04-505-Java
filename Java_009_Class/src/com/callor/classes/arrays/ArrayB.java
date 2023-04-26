package com.callor.classes.arrays;

import com.callor.classes.model.ScoreDto;

public class ArrayB {

	public static int getScore() {
		int score = (int)(Math.random() * 50) + 51;
		return score;
	}
	
	public static void main(String[] args) {

		ScoreDto 홍길동 = new ScoreDto();
		ScoreDto 이몽룡 = new ScoreDto();
		ScoreDto 성춘향 = new ScoreDto();

		홍길동.stNum = "0001";
		홍길동.stName = "홍길동";
		홍길동.kor = getScore();
		홍길동.eng = getScore();
		홍길동.math = getScore();

		이몽룡.stNum = "0002";
		이몽룡.stName = "이몽룡";
		이몽룡.kor = getScore();
		이몽룡.eng = getScore();
		이몽룡.math = getScore();

		성춘향.stNum = "0003";
		성춘향.stName = "성춘향";
		성춘향.kor = getScore();
		성춘향.eng = getScore();
		성춘향.math = getScore();

		System.out.println("-".repeat(60));
		
		System.out.println("학번\t 이름\t 국어\t 영어\t 수학\t 총점\t 평균");
		
		System.out.println("-".repeat(60)); // java 1.8 이하에서만 사용 가능한 메서드 .repeat
		
		System.out.println(홍길동.stNum + "\t" + 홍길동.stName + "\t  " + 홍길동.kor + "\t  " + 홍길동.eng + "\t  " + 홍길동.math
				+ "\t " + 홍길동.getTotal() + "\t " + 홍길동.getAvg());

		System.out.println(이몽룡.stNum + "\t" + 이몽룡.stName + "\t  " + 이몽룡.kor + "\t  " + 이몽룡.eng + "\t  " + 이몽룡.math
				+ "\t " + 이몽룡.getTotal() + "\t " + 이몽룡.getAvg());

		System.out.println(성춘향.stNum + "\t" + 성춘향.stName + "\t  " + 성춘향.kor + "\t  " + 성춘향.eng + "\t  " + 성춘향.math
				+ "\t " + 성춘향.getTotal() + "\t " + 성춘향.getAvg());
		
		System.out.println("-".repeat(60));

	}

}
