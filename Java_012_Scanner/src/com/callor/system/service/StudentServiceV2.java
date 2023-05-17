package com.callor.system.service;

import java.util.Scanner;

import com.callor.system.models.StudentDto;

public class StudentServiceV2 {

	Scanner sc = new Scanner(System.in);

	private StudentDto[] stList;

	public void setStList(StudentDto[] stList) {
		this.stList = stList;
	}

	public void inputStudents() {
		for (int i = 0; i < stList.length; i++) {

			System.out.print("학번 >> ");
			String stNum = String.format("%04d", sc.nextInt());
			stList[i].setStNum(stNum);
			System.out.print("이름 >> ");
			stList[i].setStName(sc.next());
			int stGrade;
			while (true) {
				System.out.print("학년 >> ");
				String strGrade = sc.next();
				try {
					stGrade = Integer.valueOf(strGrade);
				} catch (Exception e) {
					System.out.println("정수만 입력하세요");
					continue;
				}
				if (stGrade < 1 || stGrade > 4) {
					System.out.println("1~4 범위의 학년을 입력하세요");
					continue;
				}
				break;
			}
			stList[i].setStGrade(stGrade);
			System.out.print("학과 >> ");
			stList[i].setStDept(sc.next());
			System.out.print("전화번호 >> ");
			stList[i].setStTel(sc.next());
			System.out.println();
		}
//		for (int i = 0; i < stList.length; i++) {
//			System.out.println(stList[i].toString());
//		}

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
