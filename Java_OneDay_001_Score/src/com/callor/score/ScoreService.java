package com.callor.score;

public class ScoreService {

	// 51 ~ 100사이의 랜덤한 점수를 부여하는 method
	public ScoreDto getScore(ScoreDto score) {

		score.kor = (int) (Math.random() * 50) + 51;
		score.eng = (int) (Math.random() * 50) + 51;
		score.math = (int) (Math.random() * 50) + 51;
		score.music = (int) (Math.random() * 50) + 51;
		score.art = (int) (Math.random() * 50) + 51;

		return score;
	}

	// 성적 정보가 들어있는 객체를 매개변수로 받아 성적을 출력하는 method
	public void scorePrint(ScoreDto score) {
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%d\t%.2f\n",
				score.stNum, score.kor, score.eng, score.math, score.music, score.art, score.getTotal(), score.getAvg());
	}


	// main 함수의 가독성 향상을 위해
	// ScoreService Class에 과목별 점수를 총합하기 위한 변수 선언
	public int korTotal;
	public int engTotal;
	public int mathTotal;
	public int musicTotal;
	public int artTotal;

	// 과목별 총점 출력 method
	public void allTotal() {
		int TotalSum = this.korTotal + this.engTotal + this.mathTotal + this.musicTotal + this.artTotal;

		System.out.printf("총점\t%d\t%d\t%d\t%d\t%d\t%d\n", 
				this.korTotal, this.engTotal, this.mathTotal, this.musicTotal, this.artTotal, TotalSum);
	}

	// 과목별 평균 출력 method
	public void allAvg() {
		double korAvg = (double) this.korTotal / 10;
		double engAvg = (double) this.engTotal / 10;
		double mathAvg = (double) this.mathTotal / 10;
		double musicAvg = (double) this.musicTotal / 10;
		double artAvg = (double) this.artTotal / 10;

		double TotalAvg = (korAvg + engAvg + mathAvg + musicAvg + artAvg) / 5;
		System.out.printf("평균\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t\t%.2f\n", 
				korAvg, engAvg, mathAvg, musicAvg, artAvg, TotalAvg);
	}
	
	
	// 객체간 비교하여 평균값이 낮은 객체를 잠시 저장하기 위해 만든 객체
	ScoreDto ex = new ScoreDto(); 
	// 평균을 기준으로 성적순 출력 (내림차순)
	public void gradeSort(ScoreDto[] score) {
		for(int i=0; i<score.length; i++) {
			for(int j=i+1; j<score.length; j++) {
				if(score[i].exAvg < score[j].exAvg) {
					// 평균이 낮은 객체의 index 자리를 바꾸기 위해
					// 임시로 만든 ScoreDto type의 객체에 잠시 저장
					ex = score[i];
					score[i] = score[j];
					score[j] = ex;
				}
			}
		}
		// 성적순으로 나열된 객체 배열 출력
		for(int i=0; i<score.length; i++) {
			this.scorePrint(score[i]);
		}
	}

}
