package com.callor.score;

public class Score {

	public static void main(String[] args) {

		// 학생 정보를 담을 ScoreDto 타입의 배열 10개 선언
		ScoreDto[] score = new ScoreDto[10];

		// 학생 점수 주입 및 점수 출력 메서드 사용을 위한 객체 생성
		ScoreService scoreService = new ScoreService();

		for (int i = 0; i < score.length; i++) {
			// 학생 정보를 담는 ScoreDto 타입의 객체 10개 생성
			score[i] = new ScoreDto();
		}

		for (int i = 0; i < score.length; i++) {
			// 학번, 점수 저장
			score[i].stNum = String.format("23%03d", (i + 1));
			scoreService.getScore(score[i]);
		}

		System.out.println("=".repeat(65));
		System.out.println("* 한울 고교 성적 리스트 *");
		System.out.println("=".repeat(65));
		System.out.println("학번\t국어\t영어\t수학\t음악\t미술\t총점\t평균");
		System.out.println("-".repeat(65));

		// 학생 성적 출력
		for (int i = 0; i < score.length; i++) {
			scoreService.scorePrint(score[i]);
		}

		/*
		 * for()을 통해 객체 배열에 저장되어 있는 학생들의 점수를 
		 * 학생별 각 과목의 점수를 ScoreService 클래스의 변수에 더한다.
		 */
		for (int i = 0; i < score.length; i++) {
			scoreService.korTotal += score[i].kor;
			scoreService.engTotal += score[i].eng;
			scoreService.mathTotal += score[i].math;
			scoreService.musicTotal += score[i].music;
			scoreService.artTotal += score[i].art;
		}

		System.out.println("-".repeat(65));
		// 각 과목의 총점, 전체 과목의 총점 출력
		scoreService.allTotal();

		// 각 과목의 평균, 전체 과목의 평균 출력
		
		
		// 연습용 - 성적순 출력 (내림차순)
		scoreService.allAvg();
		System.out.println("=".repeat(65));
		System.out.println("* 성적순 출력 *");
		System.out.println("-".repeat(65));
		scoreService.gradeSort(score);
		System.out.println("=".repeat(65));
	}

}
