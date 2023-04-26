package com.callor.classes.service;

import com.callor.classes.model.ScoreDto;

public class ScoreServiceA {
	
	// 51 ~ 100까지 범위의 랜덤 수를 만들어서 return 하는 method
	public int getScore() {
		int score = (int) (Math.random() * 50) + 51;
		return score;
	}

	// ScoreDto 타입의 객체를 매개변수로 받아 객체에 저장된 변수, method를 호출하여 출력
	public void scorePrint(ScoreDto score) {
		System.out.println(score.stNum + "\t" + score.stName + "\t  " + score.kor + "\t  " + score.eng + "\t  "
				+ score.math + "\t " + score.getTotal() + "\t " + score.getAvg());
	}
	
	public void sumPrint(int kor, int eng, int math) {
		
		int allSum = kor + eng + math;
		
		System.out.println("\t\t  " + kor + "\t  " + eng + "\t  " + math + "\t " + allSum);
	}

}
