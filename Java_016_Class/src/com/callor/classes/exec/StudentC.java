package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.StdData;
import com.callor.classes.models.StudentDto;

public class StudentC {

	public static void main(String[] args) {

		List<StudentDto> stdList = new ArrayList<>();
		for (int index = 0; index < StdData.STUDENT.length; index++) {

			String[] student = StdData.STUDENT[index].split(",");

			StudentDto stDto = new StudentDto();
			stDto.stNum = student[StdData.ST_NUM];
			stDto.stName = student[StdData.ST_NAME];
			stDto.stDept = student[StdData.ST_DEPT];
			int stGrade = Integer.valueOf(student[StdData.ST_GRADE]);
			stDto.stGrade = stGrade;
			// System.out.printf("%-5s\t",student[StdData.ST_PROF]);
			stDto.stTel = student[StdData.ST_TEL];
			stDto.stAddr = student[StdData.ST_ADDR];

			stdList.add(stDto);

		}
		
	}

}
