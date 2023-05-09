package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.service.ScoreServiceV1;

public class ExecA {
	
	public static void main(String[] args) {
		// ScoreServiceV1 클래스에 정의된 method를 사용하기 위하여
		// 클래스를 객체로 생성하는 절차
		
		// method 사용하기 = method 호출
		// 정의된(작성된) method에게 어떤 일을(업무, 행위, 메시지)시키기
		ScoreServiceV1 scoreService = new ScoreServiceV1();
		scoreService.makeScore();
		scoreService.printScore();
		
		// Integer List type의 scoreList 객체변수 생성
		List<Integer> scoreList = new ArrayList<>();
		
		// Integer type의 List 객체 변수 scoreList의 "기억장치 주소"를
		// makeScore() method 에게 전달하면서
		// 뭔가 요청하기
		scoreService.makeScore(scoreList);
		
		// makeScore() method를 호출하기
		// method를 호출하면서 scoreList라는 데이터가 담긴
		// 객체 변수의 "기억장치 주소"를 전달하고
		// return된 결과를 result 변수에 저장
		int result = scoreService.makeScore(scoreList);
	}

}
