package com.callor.classes.exec;

import com.callor.classes.service.StudentService;
import com.callor.classes.service.impl.StudentServiceImplV1;

public class StudentD {
	public static void main(String[] args) {
		
		StudentService stService = new StudentServiceImplV1();
		stService.loadStudent();
		stService.printStudent();
	}
}
