package com.callor.student.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.student.models.StudentDto;
import com.callor.student.utils.Line;

public class StudentExecA {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		StudentDto stDto = new StudentDto();
		List<StudentDto> stList = new ArrayList<>();
		
		System.out.println(Line.dLine);
		System.out.println("학생 정보 입력");
		System.out.println(Line.sLine);
		
		System.out.print("학번 : ");
		stDto.stNum = scan.nextLine();
		
		System.out.print("이름 : ");
		stDto.stName = scan.nextLine();
		
		System.out.print("학과 : ");
		stDto.stDept = scan.nextLine();
		
		System.out.print("학년 : ");
		String strGrade = scan.nextLine(); 
		stDto.stGrade = Integer.valueOf(strGrade);
		
		System.out.print("전화번호 : ");
		stDto.stTel = scan.nextLine();
		
		// filed 생성자를 사용하여 (데이터가 포함된) 객체 생성
		// stDto = new StudentDto(stNum, stNmae, stDept, Integer.valueOf(stGrade), stTel);
		
		stList.add(stDto);
		System.out.println(stList.toString());
		
		
		scan.close();
	}

}
