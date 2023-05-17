package com.callor.system.service;

import java.util.Scanner;

import com.callor.system.models.StudentDto;

public class StudentServiceV1 {
	Scanner sc = new Scanner(System.in);

	private StudentDto student;

	public void setStudent(StudentDto student) {
		this.student = student;
	}

	public void inputStudent() {

		System.out.print("학번 >> ");
		this.student.setStNum(sc.next());
		System.out.print("이름 >> ");
		this.student.setStName(sc.next());
		int stGrade;
		while (true) {
			System.out.print("학년 >> ");
			String strGrade = sc.next();
			try {
				stGrade = Integer.valueOf(strGrade);
			} catch (Exception e) {
				System.out.println("정수로만 입력하세요");
				continue;
			}
			if (stGrade < 1 || stGrade > 4) {
				System.out.println("학년은 1~4 범위 내의 값을 입력하세요");
				continue;
			}
			break;
		}
//		this.student.setStGrade(sc.nextInt());
		this.student.setStGrade(stGrade);
		System.out.print("학과 >> ");
		this.student.setStDept(sc.next());
		System.out.print("전화번호 >> ");
		this.student.setStTel(sc.next());

		System.out.println(student.toString());
	}

}
