package com.callor.classes.arrays;

import com.callor.classes.model.ScoreDto;
import com.callor.classes.service.ScoreServiceA;

public class HomeWork {

	// 학번, 이름 설정 메서드
	public static void scoreSet(ScoreDto score, String num, String name) {

		score.stNum = num;
		score.stName = name;
	}

	public static void main(String[] args) {
		// 학생 정보를 담을 객체 배열 10개 선언
		ScoreDto[] scores = new ScoreDto[10];

		ScoreServiceA scoreService = new ScoreServiceA();

		// 객체 배열 생성
		for (int i = 0; i < scores.length; i++) {
			scores[i] = new ScoreDto();
		}

		scoreSet(scores[0], "0001", "홍길동");
		scoreSet(scores[1], "0002", "이몽룡");
		scoreSet(scores[2], "0003", "성춘향");
		scoreSet(scores[3], "0004", "장보고");
		scoreSet(scores[4], "0005", "임꺽정");
		scoreSet(scores[5], "0006", "김철수");
		scoreSet(scores[6], "0007", "김희경");
		scoreSet(scores[7], "0008", "이기동");
		scoreSet(scores[8], "0009", "박철수");
		scoreSet(scores[9], "0010", "한동후");

		// 국어, 영어, 수학 점수 세팅
		for (int i = 0; i < scores.length; i++) {
			scores[i].kor = scoreService.getScore();
			scores[i].eng = scoreService.getScore();
			scores[i].math = scoreService.getScore();
		}

		// 국어, 영어, 수학 각 점수 합계
		int korSum = 0;
		int engSum = 0;
		int mathSum = 0;
		for (int i = 0; i < scores.length; i++) {
			korSum += scores[i].kor;
			engSum += scores[i].eng;
			mathSum += scores[i].math;
		}

		System.out.println("=".repeat(60));
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t 평균");
		System.out.println("-".repeat(60));

		// 학생 성적 정보 출력
		for (int i = 0; i < scores.length; i++) {
			scoreService.scorePrint(scores[i]);
		}

		System.out.println("-".repeat(60));

		scoreService.sumPrint(korSum, engSum, mathSum);

		System.out.println("=".repeat(60));

	}

}
