package com.callor.classes.arrays;

import com.callor.classes.model.ScoreDto;
import com.callor.classes.service.ScoreServiceA;

public class ArrayC {

	public static void main(String[] args) {

		// ScoreServiceA 클래스에 선언된 method를 사용하기 위해 객체 변수 생성
		ScoreServiceA scoreServiceA = new ScoreServiceA();

		ScoreDto 홍길동 = new ScoreDto();
		ScoreDto 이몽룡 = new ScoreDto();
		ScoreDto 성춘향 = new ScoreDto();

		홍길동.stNum = "0001";
		홍길동.stName = "홍길동";
		홍길동.kor = scoreServiceA.getScore();
		홍길동.eng = scoreServiceA.getScore();
		홍길동.math = scoreServiceA.getScore();

		이몽룡.stNum = "0002";
		이몽룡.stName = "이몽룡";
		이몽룡.kor = scoreServiceA.getScore();
		이몽룡.eng = scoreServiceA.getScore();
		이몽룡.math = scoreServiceA.getScore();

		성춘향.stNum = "0003";
		성춘향.stName = "성춘향";
		성춘향.kor = scoreServiceA.getScore();
		성춘향.eng = scoreServiceA.getScore();
		성춘향.math = scoreServiceA.getScore();

		System.out.println("-".repeat(60));

		System.out.println("학번\t 이름\t 국어\t 영어\t 수학\t 총점\t 평균");

		System.out.println("-".repeat(60)); // java 1.8 이하에서만 사용 가능한 메서드 .repeat
		
		// 각 학생 정보 출력
		scoreServiceA.scorePrint(홍길동);
		scoreServiceA.scorePrint(이몽룡);
		scoreServiceA.scorePrint(성춘향);

		System.out.println("-".repeat(60));
		
//		int korSum = 홍길동.kor + 이몽룡.kor + 성춘향.kor;
//		int engSum = 홍길동.eng + 이몽룡.eng + 성춘향.eng;
//		int mathSum = 홍길동.math + 이몽룡.math + 성춘향.math;
//		int allSum = korSum + engSum + mathSum;
		
//		System.out.println("\t\t  " + korSum + "\t  " + engSum + "\t  " + mathSum + "\t " + allSum);
		
		scoreServiceA.sumPrint(1, 2, 3);
		
		System.out.println("-".repeat(60));

	}

}
