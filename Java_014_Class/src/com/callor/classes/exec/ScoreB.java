package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.ScoreDto;
import com.callor.classes.service.ScoreServiceV1;

/*
 * 일반적인 변수(primitive)는 method의 매개변수로 전달할 때
 * 변수 자체가 전달되는 것이 아니고 변수의 "값(데이터)"만 전달된다.
 * 매개변수로 전달받은 method 에서 아무리 변수의 값을 변경해도
 * 실제 값은 변경되지 않는다.
 */
public class ScoreB {
	
	public static void main(String[] args) {
		//ScoreDto type의 데이터 요소를 저장할 scoreList 리스트 객체 생성
		List<ScoreDto> scoreList = new ArrayList<>();
		
		ScoreServiceV1 scService = new ScoreServiceV1();
		scService.makeScore(scoreList);
		// System.out.println(scoreList.toString());
		scService.printScore(scoreList);
		scService.sortScore(scoreList);
		scService.printScore(scoreList);
		
		int num1 = 100;
		int num2 = 200;
		// scService의 add() method에게 변수 값 전달하기
		// num1, num2에 저장된 값이 전달된다.
		// 변수가 전달되는 것이 아님
		scService.add(num1, num2);
//		System.out.println(num1);
//		System.out.println(num2);
	}

}
