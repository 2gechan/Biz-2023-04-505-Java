package com.callor.classes.exec;

import com.callor.classes.service.StudentService;
import com.callor.classes.service.impl.StudentServiceImplV2;

public class StudentExecD {
	
	public static void main(String[] args) {
		StudentService stService = new StudentServiceImplV2();
		stService.loadStudent();
		stService.printStudent();
	}

}
