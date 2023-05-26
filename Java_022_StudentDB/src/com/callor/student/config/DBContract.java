package com.callor.student.config;

public class DBContract {
	
	// DB 연결 정보를 변수로 선언
	public static final String Jdbc_Drvier = "oracle.jdbc.driver.OracleDriver"; // 경로 : oracle.jdbc.driver/OracleDriver.class
	public static final String DB_URL= "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER_NAME= "student";
	public static final String PASSWORD= "12341234";
	
	
	public static class TABLE {
		public static final String STUDENT = " tbl_student ";
	}
	
	public static class column {
		public static class STUDENT {
			public static final String ST_NUM = "st_num";
			public static final String ST_NAME = "st_name";
			public static final String ST_DEPT = "st_dept";
			public static final String ST_GRADE = "st_grade";
			public static final String ST_TEL = "st_tel";

		}
	}
}
