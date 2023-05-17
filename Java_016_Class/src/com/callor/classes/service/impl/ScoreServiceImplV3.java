package com.callor.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.ScData;
import com.callor.classes.models.ScoreDto;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.ScoreService;
import com.callor.classes.service.StudentService;

/*
 * interface(class)를 implements 한 클래스는
 * interface에 선언된 모든 method를 의무적으로 구현해야 한다.
 * interface에 선언된 method를 한개라도 생략하면
 * 		클래스 코드는 문법 오류가 발생하고 실행 불가 상태가 된다.
 */
public class ScoreServiceImplV3 implements ScoreService {

	private List<ScoreDto> scList;
	
	
	
	public ScoreServiceImplV3() {
		scList = new ArrayList<>();
	}

	// ScData.SCORE 배열을 loading 하여
	// scList 데이터로 변환하기
	@Override
	public void makeScore() {
		for(String str : ScData.score) {
			
			String[] score = str.split(",");
			
			ScoreDto scDto = new ScoreDto(
					score[ScData.ST_NUM],
					Integer.valueOf(score[ScData.SC_KOR]),
					Integer.valueOf(score[ScData.SC_ENG]),
					Integer.valueOf(score[ScData.SC_MATH]),
					Integer.valueOf(score[ScData.SC_MUSIC]),
					Integer.valueOf(score[ScData.SC_ART]),
					Integer.valueOf(score[ScData.SC_SOFTWARE]),
					Integer.valueOf(score[ScData.SC_DATABASE])
			);
			
			scList.add(scDto);
					
		}
		
	}

	@Override
	public void makeScore(List<ScoreDto> scList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printScore() {
		
		StudentService stService = new StudentServiceImplV1();
		stService.loadStudent();
		System.out.println("=".repeat(100));
		System.out.println("학번\t이름\t학과\t\t국어\t영어\t수학\t음악\t미술\tSW\tDB");
		System.out.println("-".repeat(100));
		
		for(ScoreDto dto : scList) {
			System.out.print(dto.getStNum() + "\t");
			System.out.print(stService.getStudent(dto.getStNum()).stName + "\t");
			System.out.print(stService.getStudent(dto.getStNum()).stDept + "\t");
			System.out.print(dto.getScKor() + "\t");
			System.out.print(dto.getScEng() + "\t");
			System.out.print(dto.getScMath() + "\t");
			System.out.print(dto.getScMusic() + "\t");
			System.out.print(dto.getScArt() + "\t");
			System.out.print(dto.getScSoftWare() + "\t");
			System.out.print(dto.getScDataBase() + "\n");
		}
		
	}

	@Override
	public void printScore(List<ScoreDto> scList) {
		// TODO Auto-generated method stub
		
	}

}
