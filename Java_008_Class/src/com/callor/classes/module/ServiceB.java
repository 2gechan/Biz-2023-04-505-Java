package com.callor.classes.module;

import com.callor.classes.model.ScoreDto;

public class ServiceB {
	
	public void score(ScoreDto score) {
		
		System.out.println("학번 : " + score.stNum);
		System.out.println("이름 : " + score.stName);
		System.out.println("국어 : " + score.kor);
		System.out.println("영어 : " + score.eng);
		System.out.println("수학 : " + score.math);
		System.out.println("국사 : " + score.his);
		System.out.println("음악 : " + score.mus);
		System.out.println("미술 : " + score.art);
		System.out.println("체육 : " + score.phy);
		
//		int sum = score.kor + score.eng + score.math + score.his + score.mus + score.art + score.phy;
		
		int sum = score.getTotal();
//		float avg = (float)sum / 7;
		float avg = score.getAvg();
		System.out.println("-------------------------");
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
	}

}
