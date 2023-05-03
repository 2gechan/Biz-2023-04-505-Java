package com.callor.system.exec;

import com.callor.system.models.StudentDto;
import com.callor.system.service.StudentServiceV2;

public class StudentD {
	
	public static void main(String[] args) {
		
		StudentDto[] stList = new StudentDto[3];
		
		for(int i=0; i< stList.length; i++) {
			stList[i] = new StudentDto();
		}
		
		StudentServiceV2 stService = new StudentServiceV2();
		
		stService.setStList(stList);
		
		stService.inputStudents();
		
		stService.printStudents();
		
	}

}
