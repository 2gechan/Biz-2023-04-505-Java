package com.callor.bank.exec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.callor.bank.config.DBContract;

public class DbExecA {

	/*
	 * DB(DBMS Server)에 연결하는 절차 
	 * 1. Driver를 활성화(실행) 
	 * 2. 접속정보를 통하여 연결 
	 * 3. SQL 전송
	 * 4. 결과 받기
	 */
	public static void main(String[] args) {

		// DB와 연결하기 위한 Input 장치
		Connection conn = null;

		// jdbcDriver를 Loading하여 활성화 하라
		try {
			Class.forName(DBContract.jdbcDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 연결정보를 설정하여 연결 준비
		try {
			conn = DriverManager.getConnection(
					DBContract.DB_URL,
					DBContract.USER_NAME,
					DBContract.PASSWORD
					);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DBMS에 보낼 SQL 명령문 만들기
		String sql = " SELECT * FROM tbl_buyer ";
		
		// DBMS에 연결하여 SQL 보내기
		PreparedStatement pStr = null;
		try {
			pStr = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DBMS에게 SQL 실행을 요청하고
		// SQL이 실행된 결과를 ResultSet type의 객체에 받기
		ResultSet result = null;
		try {
			result = pStr.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// System.out.println(result.toString());
		try {
			System.out.println(result.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
