package com.callor.classes.exec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class StudentExecC {

	public static void main(String[] args) {

		String studentFile = "src/com/callor/classes/datas/student.csv";
		String saveFile = "src/com/callor/classes/datas/student-save.csv";

		// 객체를 선언말 할 때, null 값을 저장하여 초기화를 하면
		// 객체때문에 발생하는 메모리 관련 문제를 조금 줄일 수 있다.
		Scanner fileScan = null;

		
		InputStream is = null;
		try {
			is = new FileInputStream(studentFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fileScan = new Scanner(is);
		while(fileScan.hasNext()) {
			System.out.println(fileScan.nextLine());
		}
		fileScan.close();
		

	}

}
