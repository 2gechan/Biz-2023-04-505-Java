package com.callor.exam;

import com.callor.exam.service.GuideService;
import com.callor.exam.service.impl.GuideServiceImplV1;

public class exec {
	
	public static void main(String[] args) {
		
		GuideService gs = new GuideServiceImplV1();
		
		gs.loadGuide();
		gs.printGuideList();
	}

}
