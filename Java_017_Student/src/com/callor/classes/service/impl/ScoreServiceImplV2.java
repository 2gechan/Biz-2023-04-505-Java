package com.callor.classes.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.callor.classes.datas.DataIndex;
import com.callor.classes.models.ScoreDto;
import com.callor.classes.models.StudentDto;
import com.callor.classes.models.config.Line;
import com.callor.classes.service.StudentService;

public class ScoreServiceImplV2 extends ScoreServiceImplV1 {
	
	public ScoreServiceImplV2() {
		// V1에서 protected로 선언된 scList를 사용할 수 있도록
		// 초기화 하는 작업, 반드시 필요
		scList = new ArrayList<>();
	}
	
	String file = "src/com/callor/classes/datas/score.csv";
	
	Scanner scan = null;
	InputStream is = null;
	
	
	@Override
	public void loadScore() {
		
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println(file + "이 없습니다");
			e.printStackTrace();
		}
		scan = new Scanner(is);
		
		while(scan.hasNext()) {
			String[] strScore = scan.nextLine().split(",");
			ScoreDto scDto = new ScoreDto(
					strScore[DataIndex.SCORE.ST_NUM], 
			Integer.valueOf(strScore[DataIndex.SCORE.SC_KOR]),
			Integer.valueOf(strScore[DataIndex.SCORE.SC_ENG]),
			Integer.valueOf(strScore[DataIndex.SCORE.SC_MATH]),
			Integer.valueOf(strScore[DataIndex.SCORE.SC_MUSIC]), 
			Integer.valueOf(strScore[DataIndex.SCORE.SC_ART]),
			Integer.valueOf(strScore[DataIndex.SCORE.SC_SOFTWARE]),
			Integer.valueOf(strScore[DataIndex.SCORE.SC_DATABASE]));
			
			scList.add(scDto);
		}
		scan.close();
	}
	@Override
	public void printScore() {
		StudentService stService = new StudentServiceImplV2();
		stService.loadStudent();
		System.out.println(Line.dLine(100));
		System.out.println("학번\t이름\t\t학과\t\t국어\t영어\t수학\t음악\t미술\tSW\tDB");
		System.out.println(Line.sLine(100));

		for (ScoreDto dto : scList) {

			System.out.print(dto.getStNum() + "\t");
			
			StudentDto stDto = stService.getStudent(dto.getStNum());
			
			if (stDto != null) {
				System.out.printf("%-5s\t", stDto.stName);
				System.out.printf("%-5s\t", stDto.stDept);

			} else {
				System.out.print("-" + "\t"); // 이름 정보 없음
				System.out.print("-" + "\t"); // 학과 정보 없음
			}

			System.out.printf("%-3d\t", dto.getScKor());
			System.out.printf("%-3d\t", dto.getScEng());
			System.out.printf("%-3d\t", dto.getScMath());
			System.out.printf("%-3d\t", dto.getScMusic());
			System.out.printf("%-3d\t", dto.getScArt());
			System.out.printf("%-3d\t", dto.getScSoftWare());
			System.out.printf("%-3d\n", dto.getScDataBase());
		}
		System.out.println(Line.dLine(100));
	}

}
