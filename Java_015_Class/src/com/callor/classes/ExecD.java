package com.callor.classes;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.StudentDto;

public class ExecD {
	
	public static void main(String[] args) {
		
		// 한 학생의 데이터 객체를 만들고
		StudentDto stDto = new StudentDto();
		stDto.setStNum("0001");
		stDto.setStName("홍길동");
		stDto.setStDept("컴퓨터공학");
		stDto.setStGrade(3);
		stDto.setStTel("010-111-1111");
		
		// 리스트에 추가하기
		List<StudentDto> stList = new ArrayList<>();
		stList.add(stDto);
		
		// 새로운 학생정보를 임의 생성자를 통해서
		// 데이터가 담긴 객체 생성하기
		stDto = new StudentDto("0002", "이몽룡", "전자공학", 2, "010-222-2222");
		stList.add(stDto);
		
		System.out.println(stList.toString());
	}

}
