package com.callor.classes.exec;

import com.callor.classes.service.ScoreService;
import com.callor.classes.service.StudentService;
import com.callor.classes.service.impl.ScoreServiceImplV3;
import com.callor.classes.service.impl.StudentServiceImplV1;

public class StudentD {
	public static void main(String[] args) {
		
		StudentService stService = new StudentServiceImplV1();
		stService.loadStudent();
		// stService.printStudent();
		
		// System.out.println(stService.getStudent("S0005").toString());
		
		ScoreService scService = new ScoreServiceImplV3();
		
		scService.makeScore();
		scService.printScore();
	}
}
