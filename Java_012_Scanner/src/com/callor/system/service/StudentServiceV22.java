package com.callor.system.service;

import java.util.Scanner;

import com.callor.system.models.StudentDto;

public class StudentServiceV22 {

	Scanner sc = new Scanner(System.in);

	private StudentDto[] stList;

	public void setStList(StudentDto[] stList) {
		this.stList = stList;
	}

	public void inputStudents() {
		
			while(true) {
				System.out.println("학생정보를 입력하세요");
				
				int intNum = 0;
				while (true) {
					System.out.println("학번( 1 ~ 5 ) >> ");
					String stNum = sc.next();
					try {
						intNum = Integer.valueOf(stNum);
					} catch (Exception e) {
						System.out.println("학번은 정수로 입력하세요");
						continue;
					}
					// 학번에서 -1을 입력하면 더이상 입력받지 않기
					if(intNum < 0) {
						// method 종료
						return;
					}
					if (intNum < 1 || intNum > stList.length + 1) {
						System.out.println("학번은 1 ~ 5 까지 입력하세요");
						continue;
					}
					break;
				}
				
				StudentDto student = new StudentDto();
				student.setStNum(String.format("%04d", intNum));
				
				
				System.out.print("이름 >> ");
				String stName = sc.next();
				student.setStName(stName);
				
				/*
				 * 현재 stList 배열의 요소는 초기화가 되지 않은 상태이다
				 * 이때 StudentDto type student 객체를 생성하였고,
				 * student 객체의 속성 값을 setting 한 후
				 * student 객체를 배열의 요소에 저장
				 * 
				 * stList[intNum - 1]을 초기화 하지 않더라도
				 * student 객체를 저장하므로써 자동으로 초기화가 된다.
				 */
				stList[intNum - 1] = student;
			}
		
	}

	public void printStudents() {
		System.out.println("=".repeat(70));
		System.out.println("학번\t이름\t학과\t\t학년\t전화번호");
		System.out.println("-".repeat(70));
		for (int i = 0; i < stList.length; i++) {
			System.out.printf("%-3s\t", stList[i].getStNum());
			System.out.printf("%-3s\t", stList[i].getStName());
			System.out.printf("%-8s\t", stList[i].getStDept());
			System.out.printf("%-3s\t", stList[i].getStGrade());
			System.out.printf("%-3s\t", stList[i].getStTel());
			System.out.println();
		}
		System.out.println("=".repeat(70));
	}

}
