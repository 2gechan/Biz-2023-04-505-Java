package com.callor.classes.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.classes.models.StudentDto;
import com.callor.classes.models.config.Line;
import com.callor.classes.service.StudentService;

public class StudentServiceImplV2 extends StudentServiceImplV1 {

	public StudentServiceImplV2() {
		stdList = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	String studentFile = "src/com/callor/classes/datas/student.csv";
	// String saveFile = "src/com/callor/classes/datas/student-save.csv";
	Scanner fileScan = null;
	InputStream is = null;

	@Override
	public void loadStudent() {
		
		try {
			is = new FileInputStream(studentFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(studentFile + "이 없습니다 확인하세요.");
			e.printStackTrace();
		}
		
		fileScan = new Scanner(is);
		while(fileScan.hasNext()) {
			
			String fileLine = fileScan.nextLine();
			StudentDto stDto = str2Dto(fileLine);
			/*
			String[] student = fileLine.split(",");
			
			stDto.stNum = student[DataIndex.STUDENT.ST_NUM];
			stDto.stName = student[DataIndex.STUDENT.ST_NAME];
			stDto.stDept = student[DataIndex.STUDENT.ST_DEPT];
			int stGrade = Integer.valueOf(student[DataIndex.STUDENT.ST_GRADE]);
			stDto.stGrade = stGrade;
			stDto.stTel = student[DataIndex.STUDENT.ST_TEL];
			stDto.stAddr = student[DataIndex.STUDENT.ST_ADDR];
			*/
			stdList.add(stDto);
		}
		fileScan.close();
		
	}

	@Override
	public void printStudent() {
		
		printHeader();
		
		int index = 0;
		for(StudentDto stDto : stdList) {
			
			/*
			System.out.printf("%-5s\t", stDto.stNum);
			System.out.printf("%-5s\t", stDto.stName);
			System.out.printf("%-5s\t", stDto.stDept);
			System.out.printf("%-5d\t", stDto.stGrade);
			System.out.printf("%-5s\t", stDto.stTel);
			System.out.printf("%-5s\n", stDto.stAddr);
			*/
			printStudent(stDto);
			
			if((++index) % 5 == 0 && index < stdList.size()) {
				System.out.println(Line.sLine(120));
			}
		}
		System.out.println(Line.dLine(120));
		
	}

	@Override
	public StudentDto getStudent(String stNum) {
		for (StudentDto dto : stdList) {
			if (stNum.equals(dto.stNum)) {
				
				return dto;
			}

		}
		
		return null;
	}
	

}
