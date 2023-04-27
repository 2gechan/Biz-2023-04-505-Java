package com.callor.classes.arrays;

import com.callor.classes.model.ScoreDto;
import com.callor.classes.service.ScoreServiceA;

public class HomeWorkB {

	public static void main(String[] args) {

		// String type의 배열을 선언과 동시에 초기화
		String[] names = { "홍길동", "이몽룡", "성춘향", 
				"장보고", "임꺽정", "김철수", "김희경", 
				"이기동", "박철수", "한동후" };

		// 미리 설정한 학생 수 만큼 
		// 학생 정보를 담을 객체 배열 10개 선언
		ScoreDto[] scores = new ScoreDto[names.length];

		ScoreServiceA scoreService = new ScoreServiceA();

		// 객체 배열 생성
		for (int i = 0; i < scores.length; i++) {
			scores[i] = new ScoreDto();
		}

		// 학생 이름, 학번, 국어, 영어, 수학 - 학생 정보 세팅
		for (int i = 0; i < scores.length; i++) {
			scores[i].stName = names[i];

			// 전체 자릿수를 4자리로 고정하고
			// 포멧스트링을 통해 들어온 값 이외에 빈자리를 0으로 채운다
			scores[i].stNum = String.format("%04d", i+1);
			
			scores[i].kor = scoreService.getScore();
			scores[i].eng = scoreService.getScore();
			scores[i].math = scoreService.getScore();
		}

		// 과목별 점수 합계
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

		// 학생 정보 및 성적 정보 출력
		for (int i = 0; i < scores.length; i++) {
			scoreService.scorePrint(scores[i]);
		}

		System.out.println("-".repeat(60));

		scoreService.sumPrint(korSum, engSum, mathSum);

		System.out.println("=".repeat(60));

	}

}
