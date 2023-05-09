package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.StudentDto;

public class ExecC {

	public static void main(String[] args) {
		// StudentDto type List 객체 변수 stdList 생성하기
		// size() 0인 변수
		List<StudentDto> stdList = new ArrayList<>();

		// 홍길동의 학생정보를 저장하기 위한 stDto를 생성하고
		StudentDto stDto = new StudentDto();
		// 학번, 이름, 학과 변수에 값을 저장하고
		stDto.stNum = "0001";
		stDto.stName = "홍길동";
		stDto.stDept = "정보통신";

		// 홍길동 객체를 stdList에 추가하기
		stdList.add(stDto);

		stDto = new StudentDto();

		stDto = new StudentDto();
		stDto.stNum = "0002";
		stDto.stName = "성춘향";
		stDto.stDept = "컴퓨터공학";
		stdList.add(stDto);

		System.out.println(stdList.get(0).stName);

		// stdList의 index 0 데이터(학생객체 데이터)를
		// get(읽기)하여 홍길동 객체변수에 복사하기
		StudentDto 홍길동 = stdList.get(0);
		System.out.println(홍길동.toString());
		System.out.println(홍길동.stName);

		StudentDto 성춘향 = stdList.get(1);
		System.out.println(성춘향.toString());
		System.out.println(성춘향.stName);

		for (int i = 0; i < stdList.size(); i++) {
			String stName = stdList.get(i).stName;
			System.out.println(stName);
		}
	}

}
