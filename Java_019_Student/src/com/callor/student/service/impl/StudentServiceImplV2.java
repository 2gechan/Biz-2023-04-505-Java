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
import com.callor.student.utils.Line;

/*
 * insertStudent, printStudent, loadStudent 모두 상속
 */
public class StudentServiceImplV2 extends StudentServiceImplV1 {

	protected StudentDto inputStudent() {
		System.out.println(Line.dLine(60));
		System.out.println("학생정보 입력 종료하려면 QUIT 입력");
		System.out.println(Line.dLine(60));

		String stNum1 = "";
		String stNum2 = "";
		while (true) {
			System.out.print("학번 >> ");
			stNum1 = scan.nextLine();

			if (stNum1.equals("QUIT")) {
				break;
			}
			try {
				stNum2 = String.format("%04d", Integer.valueOf(stNum1));
				int check = 0;
				for (StudentDto stDto : stdList) {
					if (stNum2.equals(stDto.stNum)) {
						System.out.println(stNum2 + " 학번이 이미 존재");
						check ++;
						break;
						
					}
				}
				if(check > 0) {
					continue;
				} 
				break;
				
			} catch (Exception e) {
				System.out.println("정수를 입력하세요");
			}

		}
		if (stNum1.equals("QUIT"))
			return null;
		

		System.out.print("이름 >> ");
		String stName = scan.nextLine();
		if (stName.equals("QUIT"))
			return null;

		System.out.print("학과 >> ");
		String stDept = scan.nextLine();
		if (stDept.equals("QUIT"))
			return null;
		int stGrade = 0;
		String strGrade = "";
		while (true) {

			System.out.print("학년 >> ");
			strGrade = scan.nextLine();
			try {
				if (strGrade.equals("QUIT"))
					return null;
				stGrade = Integer.valueOf(strGrade);
			} catch (Exception e) {
				System.out.println("학년은 정수를 입력하세요");
				continue;
			}
			if (stGrade < 1 || stGrade > 4) {
				System.out.println("학년은 1 ~ 4 범위로 입력해주세요");
			} else {
				break;
			}
		}

		System.out.print("전화번호 >> ");
		String stTel = scan.nextLine();
		if (stTel.equals("QUIT"))
			return null;

		StudentDto stDto = new StudentDto(stNum2, stName, stDept, stGrade, stTel);

		// stdList.add(stDto);
		return stDto;

	}

	@Override
	public void loadStudnet() {

		while (true) {
			StudentDto stDto = this.inputStudent();
			if (stDto == null)
				break;
			stdList.add(stDto);
		}

		InputStream is = null;
		Scanner scan = null;

		try {
			is = new FileInputStream(Config.STUDENT_FILE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (scan.hasNext()) {
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
			for (StudentDto dto : stdList) {
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
