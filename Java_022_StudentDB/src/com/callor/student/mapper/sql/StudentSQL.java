package com.callor.student.mapper.sql;

public class StudentSQL {
	
	// MyBatis 에서 사용할 SQL 명령문은 반드시 final 키워드가 있어야 한다.
	public static final String STUDENT_INSERT = "insert into tbl_student("
			+ "st_num, st_name, st_dept, st_grade, st_tel) "
			+ " values(#{st_num}, #{st_name}, #{st_dept}, #{st_grade}, #{st_tel})";
	
	public static final String STUDENT_UPDATE = "update tbl_student "
												+ " set st_name = #{st_name}, "
												+ "st_dept = #{st_dept}, "
												+ "st_grade = #{st_grade}, "
												+ "st_tel = #{st_tel} "
												+ " where st_num = #{st_num}";

}
