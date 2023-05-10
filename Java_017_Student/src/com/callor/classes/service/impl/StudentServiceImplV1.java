package com.callor.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.StudentDto;
import com.callor.classes.models.datas.DataIndex;
import com.callor.classes.models.datas.DataSource;
import com.callor.classes.service.StudentService;

public class StudentServiceImplV1 implements StudentService {

	private List<StudentDto> stdList;
	
	// 생성자에서 List 초기화
	public StudentServiceImplV1() {
		stdList = new ArrayList<>();
	}

	@Override
	public void loadStudent() {
		
		// StdData 클래스의 STUDENT 문자열 배열의 요소들을
		// 차례로 str 문자열에 저장하여 for-each 반복문 수행
		for (String str : DataSource.STUDENT) {
			
			// STUDENT 문자열 배열의 요소를 구분자(",")를 통해
			// student 문자열 배열에 나눠 저장하기
			String[] student = str.split(",");

			StudentDto stDto = new StudentDto();

			stDto.stNum = student[DataIndex.STUDENT.ST_NUM];
			stDto.stName = student[DataIndex.STUDENT.ST_NAME];
			stDto.stDept = student[DataIndex.STUDENT.ST_DEPT];
			int stGrade = Integer.valueOf(student[DataIndex.STUDENT.ST_GRADE]);
			stDto.stGrade = stGrade;
			stDto.stTel = student[DataIndex.STUDENT.ST_TEL];
			stDto.stAddr = student[DataIndex.STUDENT.ST_ADDR];

			stdList.add(stDto);
		}

	}

	@Override
	public void printStudent() {
		System.out.println("=".repeat(100));
		System.out.println("학번\t이름\t학과\t\t학년\t전화번호\t주소");
		System.out.println("-".repeat(100));
		for (StudentDto dto : stdList) {
			System.out.print(dto.stNum + "\t");
			System.out.print(dto.stName + "\t");
			System.out.print(dto.stDept + "\t");
			System.out.print(dto.stGrade + "\t");
			System.out.print(dto.stTel + "\t");
			System.out.print(dto.stAddr + "\n");

		}
		System.out.println("=".repeat(100));

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
