package com.callor.student.exec;

import java.util.Scanner;

import com.callor.student.service.StudentService;
import com.callor.student.service.impl.StudentServiceImplV2;
import com.callor.student.utils.Line;

public class StudentExecG {

	public static void main(String[] args) {

		StudentService stService = new StudentServiceImplV2();
		Scanner scan = new Scanner(System.in);

		System.out.println(Line.dLine(100));
		System.out.println("대한고교 학사관리 2023");
		System.out.println(Line.dLine(100));

		while (true) {
			System.out.println("실행할 업무를 선택하세요");
			System.out.println(Line.sLine(100));
			System.out.println("1. 학생 리스트 확인");
			System.out.println("2. 학생정보 추가/수정");
			System.out.println("3. 학생정보 삭제");
			System.out.println("9. 업무종료");
			System.out.println(Line.sLine(100));
			System.out.print("업무선택 >> ");
			String strSelect = scan.nextLine();
			int select = 0;
			try {
				select = Integer.valueOf(strSelect);
			} catch (Exception e) {
				System.out.printf("업무선택란을 확인하세요(%s)\n", strSelect);
				continue;
			}
			if (select == 1) {
				stService.printStudent();
			} else if (select == 2) {
				stService.insertStudent();
			} else if (select == 3) {
				/*
				 * deleteStudent() method는 Service interface에
				 * 없는 method이다. 따라서 method를 포함하고 있는
				 * class type으로 stService를 객체 형변환을 해줘야만
				 * 사용할 수 있다. 
				 */
				((StudentServiceImplV2) stService).deleteStudent();
			} else if (select == 9) {
				break;
			} else {
				System.out.printf("업무 선택이 잘못되었습니다(%d)\n", select);
			}
		}
		System.out.println("업무 종료");
		scan.close();
	}

}
