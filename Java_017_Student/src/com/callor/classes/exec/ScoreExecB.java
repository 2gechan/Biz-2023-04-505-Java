package com.callor.classes.exec;

import com.callor.classes.service.ScoreService;
import com.callor.classes.service.impl.ScoreServiceImplV2;

public class ScoreExecB {
	
	public static void main(String[] args) {
		ScoreService scService = new ScoreServiceImplV2();
		
		scService.loadScore();
		scService.printScore();
	}

}
