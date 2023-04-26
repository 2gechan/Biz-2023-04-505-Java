package com.callor.classes.arrays;

import com.callor.classes.model.ScoreDto;
import com.callor.classes.service.ScoreServiceA;

public class HomeWork {
	
	public static void main(String[] args) {
		// 학생 정보를 담을 객체 배열 10개 선언
		ScoreDto[] scores = new ScoreDto[10];
		
		ScoreServiceA scoreService = new ScoreServiceA();
		
		// 객체 배열 생성
		for(int i=0; i<scores.length; i++) {
			scores[i] = new ScoreDto();
		}
		
		scores[0].stNum = "0001";
		scores[1].stNum = "0002";
		scores[2].stNum = "0003";
		scores[3].stNum = "0004";
		scores[4].stNum = "0005";
		scores[5].stNum = "0006";
		scores[6].stNum = "0007";
		scores[7].stNum = "0008";
		scores[8].stNum = "0009";
		scores[9].stNum = "0010";
		
		scores[0].stName = "홍길동";
		scores[1].stName = "이몽룡";
		scores[2].stName = "성춘향";
		scores[3].stName = "장보고";
		scores[4].stName = "임꺽정";
		scores[5].stName = "김철수";
		scores[6].stName = "김희경";
		scores[7].stName = "이기동";
		scores[8].stName = "박철수";
		scores[9].stName = "한동후";
		
		// 국어, 영어, 수학 점수 세팅
		for(int i=0; i<scores.length; i++) {
			scores[i].kor = scoreService.getScore();
			scores[i].eng = scoreService.getScore();
			scores[i].math = scoreService.getScore();
		}
		
		// 국어, 영어, 수학 각 점수 합계
		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;
		for(int i =0; i<scores.length; i++) {
			korSum += scores[i].kor;
			engSum += scores[i].eng;
			mathSum += scores[i].math;
		}
		
		System.out.println("=".repeat(60));
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t 평균");
		System.out.println("-".repeat(60));
		
		// 학생 성적 정보 출력
		for(int i=0; i<scores.length; i++) {
			scoreService.scorePrint(scores[i]);
		}
		
		System.out.println("-".repeat(60));
		
		scoreService.sumPrint(korSum, engSum, mathSum);
		
		System.out.println("=".repeat(60));
		
	}

}
