package com.callor.classes.exec;

import com.callor.classes.model.ScoreDto;

public class ExecC {
	
	public static void main(String[] args) {
		ScoreDto 홍길동 = new ScoreDto();
		ScoreDto 이몽룡 = new ScoreDto();
		ScoreDto 성춘향 = new ScoreDto();
		
		홍길동.stName = "홍길동";
		홍길동.kor = 100;
		
		이몽룡.stName = "이몽룡";
		이몽룡.kor = 88;

		성춘향.stName = "성춘향";
		성춘향.kor = 99;
		성춘향.eng = 77;
		성춘향.math = 74;
		성춘향.his = 80;
		성춘향.mus = 44;
		성춘향.art = 94;
		성춘향.phy = 67;
		
		System.out.println(성춘향.getTotal());
	}

}
