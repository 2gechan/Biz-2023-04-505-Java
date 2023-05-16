package com.callor.student.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import com.callor.student.models.StudentDto;
import com.callor.student.utils.Config;

/*
 * insertStudent, printStudent, loadStudent 모두 상속
 */
public class StudentServiceImplV2 extends StudentServiceImplV1 {

	@Override
	public void loadStudnet() {
		// TODO Auto-generated method stub
		super.loadStudnet();
		
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(Config.STUDENT_FILE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(scan.hasNext()) {
			String student = scan.nextLine();
			String[] stFile = student.split(",");
			
			StudentDto stDto = new StudentDto();
			stDto.stNum = stFile[0];
			stDto.stName = stFile[1];
			stDto.stDept = stFile[2];
			stDto.stGrade = Integer.valueOf(stFile[3]); 
			stDto.stTel = stFile[4];
			
			stdList.add(stDto);
		}
		scan.close();
	}
	
	
	@Override
	public void insertStudent() {
		
		// TODO Auto-generated method stub
		
		// 조상 클래스의 method를 먼저 실행
		super.insertStudent();
		
		OutputStream os = null;
		PrintWriter out = null;
		

		System.out.println("여기는 V2");
		
		String studentFile = Config.STUDENT_FILE;
		try {
			os = new FileOutputStream(studentFile);
			out = new PrintWriter(os);
			for(StudentDto dto : stdList) {
				out.print(dto.stNum + ", ");
				out.print(dto.stName + ", ");
				out.print(dto.stDept + ", ");
				out.print(dto.stGrade + ", ");
				out.print(dto.stTel);
				out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
		try {
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
