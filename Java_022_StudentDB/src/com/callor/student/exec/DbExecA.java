package com.callor.student.exec;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.callor.student.config.DBConnection;
import com.callor.student.mapper.StudentDao;
import com.callor.student.models.StudentDto;

public class DbExecA {

	public static void main(String[] args) {

		// SqlSessionFactory 에게 DB와 연결할 Session을 요청한다.
		// openSession() 의 true : INSERT, UPDATE, DELETE를 수행할 때
		// 자동으로 COMMIT 명령을 실행하라
		// 이 옵션을 사용하지 않으면 JAVA에서 추가, 수정, 삭제한 데이터가
		// SQL Developer 등에서 확인이 안될 수 있다
		SqlSession sqlSession = DBConnection.getFactory().openSession(true);

		// StudentDao interface를 구현한 DaoImplV1과 같은 코드를
		// 생성하여 stDao에 담아준다.
		StudentDao stDao = sqlSession.getMapper(StudentDao.class);

		List<StudentDto> stdList = stDao.selectAll();

		System.out.println(stdList.toString());

	}

}
