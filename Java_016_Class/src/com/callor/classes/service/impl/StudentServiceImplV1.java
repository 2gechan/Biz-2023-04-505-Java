package com.callor.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.StdData;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;

public class StudentServiceImplV1 implements StudentService {

	List<StudentDto> stdList = new ArrayList<>();

	@Override
	public void loadStudent() {
		for (int i = 0; i < StdData.STUDENT.length; i++) {
			String[] student = StdData.STUDENT[i].split(",");
			
			StudentDto stDto = new StudentDto();
			
			stDto.stNum = student[StdData.ST_NUM];
			stDto.stName = student[StdData.ST_NAME];
			stDto.stDept = student[StdData.ST_DEPT];
			int stGrade = Integer.valueOf(student[StdData.ST_GRADE]);
			stDto.stGrade = stGrade;
			stDto.stTel = student[StdData.ST_TEL];
			stDto.stAddr = student[StdData.ST_ADDR];
			
			stdList.add(stDto);
		}

	}

	@Override
	public void printStudent() {
		System.out.println("=".repeat(100));
		System.out.println("학번\t이름\t학과\t\t학년\t전화번호\t주소");
		System.out.println("-".repeat(100));
		for(int i=0; i<stdList.size(); i++) {
			System.out.print(stdList.get(i).stNum + "\t");
			System.out.print(stdList.get(i).stName + "\t");
			System.out.print(stdList.get(i).stDept + "\t");
			System.out.print(stdList.get(i).stGrade + "\t");
			System.out.print(stdList.get(i).stTel + "\t");
			System.out.print(stdList.get(i).stAddr + "\n");
			
		}
		System.out.println("=".repeat(100));

	}

}
