package com.callor.classes.service;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.ScoreDto;

public class ScoreServiceV2 {

	// scoreList 변수를 ScoreServiceV2 클래스의
	// 다른 method 에서 사용하기 위하여
	// 클래스 영역으로 scope를 이동
	// 클래스 영역으로 scope가 이동된 객체 변수는
	// 선언만 수행한다.
	private List<ScoreDto> scList;

	public void makeScore() {
		
		// 다른 method(printScore())에서
		// scList를 사용하기 위해
		// scList 선언을 클래스 영역에서 수행한다.
		scList = new ArrayList<>();
		this.makeScore(scList);
		/*
		for (int i = 0; i < 10; i++) {
			ScoreDto scDto = new ScoreDto();
			this.scList.add(scDto);
		}

		for (int i = 0; i < this.scList.size(); i++) {

			String stNum = String.format("%04d", i + 1);
			int kor = (int) (Math.random() * 50) + 51;
			int eng = (int) (Math.random() * 50) + 51;
			int math = (int) (Math.random() * 50) + 51;
			
			this.scList.get(i).setStNum(stNum);
			this.scList.get(i).setScKor(kor);
			this.scList.get(i).setScKor(eng);
			this.scList.get(i).setScKor(math);

		}
		*/

	} // makeScore() method end

	public void makeScore(List<ScoreDto> scList) {
		
		for (int i = 0; i < 10; i++) {
			ScoreDto scDto = new ScoreDto();
			scList.add(scDto);
		}

		for (int i = 0; i < scList.size(); i++) {
			String stNum = String.format("%04d", i + 1);
			int kor = (int) (Math.random() * 50) + 51;
			int eng = (int) (Math.random() * 50) + 51;
			int math = (int) (Math.random() * 50) + 51;

			scList.get(i).setStNum(stNum);
			scList.get(i).setScKor(kor);
			scList.get(i).setScKor(eng);
			scList.get(i).setScKor(math);

		}

	} // makeScore(scList) method end

	public void scorePrint() {

		for (int i = 0; i < this.scList.size(); i++) {
			System.out.println(this.scList.get(i).toString());

		}
	}

}
