package com.callor.student.config;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class DBConnection {
	
	private static SqlSessionFactory sqlSessionFactory;

	static {
		DataSource dataSource = new PooledDataSource(
				DBContract.Jdbc_Drvier,
				DBContract.DB_URL,
				DBContract.USER_NAME,
				DBContract.PASSWORD );
		
		// Transaction이란 여러 개의 Table에 대하여 CRUD를 실행할 때
		// 타이밍에 의한 데이터 sync 오류 등을 자체적으로 관리하는 도구
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		
		// Mybatis를 사용하여 DBMS에 연결하기 위한 환경 설정
		Environment environment = new Environment("dev", transactionFactory, dataSource);
		
		// 환경설정 등을 Mybatis 의 SqlSessionFactory 에게 전달하기 위한 객체
		Configuration configuration = new Configuration(environment);
		
		// Dao interface가 저장되어 있는 package를 지정한다
		// Mybatis는 Dao interface 파일을 scan(검사)하여
		// Annotation으로 설정된 SQL 명령문과
		// 각 method 의 return type 을 참조하여 
		// DBMS를 핸들링하는 CRUD 코드를 생성하게 된다.
		configuration.addMappers("com.callor.student.mapper");
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
	}
	
	public static SqlSessionFactory getFactory() {
		return sqlSessionFactory;
	}

}
