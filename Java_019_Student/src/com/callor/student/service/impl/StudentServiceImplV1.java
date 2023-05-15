package com.callor.student.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.student.models.StudentDto;
import com.callor.student.service.StudentService;
import com.callor.student.utils.Line;

public class StudentServiceImplV1 implements StudentService {

	protected List<StudentDto> stdList;
	protected Scanner scan;
	public StudentServiceImplV1() {
		stdList = new ArrayList<>();
		scan = new Scanner(System.in);
	}

	@Override
	public void loadStudnet() {
		// TODO Auto-generated method stub

	}
	
	/*
	 * insertStudent() method는
	 * StudentService interface에 정의되지 않은 method
	 * 
	 * 이 method는 상속받은 것이 아니고 V1 클래스에서
	 * 임의로 생성한 method 이다.
	 */
	public void insertStudent() {
		
		while(true) {
			
			System.out.println(Line.dLine(60));
			System.out.println("학생정보 추가 종료하려면 QUIT 입력");
			System.out.println(Line.dLine(60));
			
			System.out.print("학번 >> ");
			String stNum = scan.nextLine();
			if(stNum.equals("QUIT")) {
				break;
			}
			
			System.out.print("이름 >> ");
			String stName = scan.nextLine();
			if(stName.equals("QUIT")) {
				break;
			}
			
			System.out.print("학과 >> ");
			String stDept = scan.nextLine();
			if(stDept.equals("QUIT")) {
				break;
			}
			int stGrade = 0;
			String strGrade = "";
			while(true) {
				
				System.out.print("학년 >> ");
				strGrade = scan.nextLine();
				try {
					stGrade = Integer.valueOf(strGrade);
				} catch(Exception e) {
					System.out.println("학년은 정수를 입력하세요");
					continue;
				}
				if(stGrade < 1 || stGrade > 4) {
					System.out.println("학년은 1 ~ 4 범위로 입력해주세요");
				} else {
					break;
				}
			}
			if(strGrade.equals("QUIT")) {
				break;
			}
			
			System.out.print("전화번호 >> ");
			String stTel = scan.nextLine();
			if(stTel .equals("QUIT")) {
				break;
			}
			
			StudentDto stDto = new StudentDto(stNum, stName, stDept, 
					stGrade, stTel);
			
			stdList.add(stDto);
			
		}
		System.out.println("----- 학생 정보 입력 종료 -----");
	}

	@Override
	public void printStudent() {
		System.out.println(Line.dLine(100));
		System.out.println("대한 고교 학생 리스트");
		System.out.println(Line.dLine(100));
		System.out.println("학번\t이름\t학과\t학년\t전화번호");
		System.out.println(Line.sLine(100));
		if (stdList == null || stdList.size() < 1) {
			System.out.println("표시할 데이터가 없음");
			return;
		}
		for(StudentDto stDto : stdList) {
			System.out.printf("%s\t", stDto.stNum);
			System.out.printf("%s\t", stDto.stName);
			System.out.printf("%s\t", stDto.stDept);
			System.out.printf("%d\t", stDto.stGrade);
			System.out.printf("%s\n", stDto.stTel);
		}
		System.out.println(Line.dLine(100));

	}

	@Override
	public StudentDto getStudent(String stNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDto> getStudentList() {
		// TODO Auto-generated method stub
		return null;
	}

}
