package com.callor.score.exec;

import com.callor.score.model.ScoreDto;
import com.callor.score.service.ScoreServiceV1;

public class ScoreExecV1 {

	public static void main(String[] args) {

		// 10명 학생의 점수를 저장할 객체 배열 선언
		ScoreDto[] scoreList = new ScoreDto[10];

		for (int i = 0; i < scoreList.length; i++) {
			scoreList[i] = new ScoreDto();
		}
		
		// ScoreService에 있는 method들을 사용하기 위한 준비
		ScoreServiceV1 scService = new ScoreServiceV1();
		
		// ScoreExecV1 클래스에서 생성된(선언과 초기화가 완료된) 객체 배열을
		// ScoreService 클래스의 scoreList 객체 배열변수에 전달하는 절차
		scService.setScoreList(scoreList);
		
		// 점수 생성하기
		scService.scoreRndMake();
		
		/*
		 * ScoreService의 scoreList 객체 배열을
		 * private으로 선언하게 되면
		 * 개발자(코드 작성자)나 임의의 누군가가
		 * 실수나 악의적으로 scoreList 데이터를 변경하지 못하게 된다.
		 */
		// scService.scoreList = new ScoreDto[100];
		
		// 점수 출력하기
		scService.scoreListPrint();
		
		// 과목의 총점 출력하기
		scService.scoreTotalPrint();
		
		// 과목의 평균 출력하기
		scService.scoreAvgPrint();
		
		
	}

}
