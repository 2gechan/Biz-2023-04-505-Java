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
import com.callor.student.utils.Index;
import com.callor.student.utils.Line;

/*
 * insertStudent, printStudent, loadStudent 모두 상속
 */
public class StudentServiceImplV3 extends StudentServiceImplV1 {

	protected StudentDto inputStudent() {
		System.out.println(Line.dLine(60));
		System.out.println("학생정보 입력 종료하려면 QUIT 입력");
		System.out.println(Line.dLine(60));

		StudentDto stDto = new StudentDto();
		String stNum = "";
		String stName = "";
		String stDept = "";
		int stGrade = 0;
		String stTel = "";
		while (true) {
			System.out.print("학번 >> ");
			stNum = scan.nextLine();

			if (stNum.equals("QUIT"))
				break;
			try {
				int intNum = Integer.valueOf(stNum);
				stNum = String.format("%04d", intNum);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("학번은 정수로 입력하세요");
				continue;
			}
			break;

		}
		if (stNum.equals("QUIT"))
			return null;
		int check = 0;
		for (StudentDto dto : stdList) {
			if (dto.stNum.equals(stNum)) {
				System.out.println(Line.sLine(100));
				System.out.println("동일학번 학생 데이터 있음, 데이터 수정!!");
				System.out.println(dto.toString());
				System.out.println(Line.sLine(100));

				// dto 의 어떤 데이터가 stDto 에 저장될까??
				stDto = dto;
				check++;
			}
		}
		System.out.printf("이름(%s) >> ", stDto.stName == null ? "신규" : stDto.stName);
		stName = scan.nextLine();
		if (stName.equals("QUIT"))
			return null;
		if (stName.equals("")) {
			stName = stDto.stName;
		}

		System.out.printf("학과(%s) >> ", stDto.stDept == null ? "신규" : stDto.stDept);
		stDept = scan.nextLine();
		if (stDept.equals("QUIT"))
			return null;
		if (stDept.equals("")) {
			stDept = stDto.stDept;
		}

		while (true) {
			System.out.printf("학년(%d) >> ", stDto.stGrade == 0 ? 0 : stDto.stGrade);
			String strGrade = scan.nextLine();
			if (strGrade.equals("QUIT"))
				break;
			try {
				if (stDto.stGrade != 0 && strGrade.equals("")) {
					stGrade = stDto.stGrade;
				} else {
					stGrade = Integer.valueOf(strGrade);
				}
			} catch (Exception e) {
				// TODO: handle exception'
				System.out.println("학년은 정수로 입력하세요");
				continue;
			}
			if (stGrade < 1 || stGrade > 4) {
				System.out.println("학년은 정수 1 ~ 4까지만 입력하세요");
				continue;
			}
			break;
		}

		if (stGrade == 0)
			return null;

		System.out.printf("전화번호(%s) >> ", stDto.stTel == null ? "신규" : stDto.stTel);
		stTel = scan.nextLine();
		if (stTel.equals("QUIT"))
			return null;
		if (stTel.equals("")) {
			stTel = stDto.stTel;
		}

		stDto.stNum = stNum;
		stDto.stName = stName;
		stDto.stDept = stDept;
		stDto.stGrade = stGrade;
		stDto.stTel = stTel;
		// stdList.add(stDto);
		return stDto;

	}

	@Override
	public void loadStudnet() {

		while (true) {
			StudentDto stDto = this.inputStudent();
			if (stDto == null)
				break;
			int index = 0;
			for (index = 0; index < stdList.size(); index++) {
				// inputStudent() 가 return 한 dto 하고
				// stdList 의 요소중에서 참조한 dto 하고
				// 주소가 일치하냐?
				// 주소가 일치하다 ==> stdList 에 있는 요소이다
				if (stdList.get(index) == stDto) {
					break;
				}
			}
			if (index >= stdList.size()) {
				stdList.add(stDto);
			}

		}

		// 그리고 나머지는 내가 처리할께
		System.out.println("여기는 V2");
		OutputStream os = null;
		PrintWriter out = null;

		try {
			os = new FileOutputStream(Config.STUDENT_FILE);
			out = new PrintWriter(os);

			for (StudentDto dto : stdList) {
				out.printf("%s,", dto.stNum);
				out.printf("%s,", dto.stName);
				out.printf("%s,", dto.stDept);
				out.printf("%d,", dto.stGrade);
				out.printf("%s\n", dto.stTel);
			}
			out.close();
			os.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insertStudent() {

		InputStream is = null;
		Scanner scan = null;

		try {
			is = new FileInputStream(Config.STUDENT_FILE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan = new Scanner(is);

		int rows = 0;
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] student = line.split(",");
			rows++;
			try {
				StudentDto stDto = new StudentDto();
				stDto.stNum = student[Index.STUDENT.ST_NUM];
				stDto.stName = student[Index.STUDENT.ST_NAME];
				stDto.stDept = student[Index.STUDENT.ST_DEPT];
				stDto.stGrade = Integer.valueOf(student[Index.STUDENT.ST_GRADE]);
				stDto.stTel = student[Index.STUDENT.ST_TEL];
				stdList.add(stDto);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(rows + " 라인에서 Exception 발생");
			}
		}
		scan.close();
		System.out.println("Load 한 데이터 개수 : " + stdList.size());
	}

}
