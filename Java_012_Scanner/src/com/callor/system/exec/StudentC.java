package com.callor.system.exec;

import com.callor.system.models.StudentDto;
import com.callor.system.service.StudentServiceV1;

public class StudentC {
	
	public static void main(String[] args) {
		StudentDto student = new StudentDto();
		StudentServiceV1 stService = new StudentServiceV1();
		stService.setStudent(student);
		stService.inputStudent();

	}

}
