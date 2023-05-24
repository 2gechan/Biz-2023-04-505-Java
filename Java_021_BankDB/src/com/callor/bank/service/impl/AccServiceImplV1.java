package com.callor.bank.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.bank.config.DBConnection;
import com.callor.bank.config.DBContract;
import com.callor.bank.models.AccDto;
import com.callor.bank.service.AccService;
import com.callor.bank.service.BankService;

public class AccServiceImplV1 implements AccService {

	// DB에 연결 session 구축하는 도구
	protected final Connection dbConn;

	public AccServiceImplV1() {
		// DB 연결 session을 구축하는 도구에 DB 연결 정보 저장
		dbConn = DBConnection.getDBConn();
	}

	/*
	 * throws ... 
	 * try...catch... 으로 처리해야 하는 코드가 있을 경우
	 * 직접 Exception을 처리하지 않고 이 method를 호출한 곳에서
	 * Exception을 대신 처리하도록 한다
	 */
	protected AccDto result2Dto(ResultSet result) throws SQLException {
		AccDto acDto = new AccDto();

		acDto.acNum = result.getString(DBContract.ACC.ACNUM);
		acDto.acDiv = result.getString(DBContract.ACC.ACDIV);
		acDto.acBuId = result.getString(DBContract.ACC.ACBUID);

		// select된 데이터의 type이 확실하게 숫자형(정수형)인 경우
		// getInt() method를 사용하여 직접 정수형으로 변환 후 받을 수 있다
		acDto.acBalance = result.getInt(DBContract.ACC.ACBALANCE);

		return acDto;
	}

	public List<AccDto> db2List(PreparedStatement pStr) throws SQLException {
		List<AccDto> accList = new ArrayList<>();

		ResultSet result = pStr.executeQuery();

		while (result.next()) {
			AccDto acDto = result2Dto(result);
			accList.add(acDto);
		}

		pStr.close();
		result.close();

		return accList;
	}

	@Override
	public List<AccDto> selectAll() {

		String sql = "select acnum, acdiv, acbuid, acbalance " 
					+ "from tbl_acc "
					+ "order by acnum";

		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			
			List<AccDto> accList = db2List(pStr);
			return accList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public AccDto findById(String acNum) {
		String sql = "select acnum, acdiv, acbuid, acbalance "
				+ "from tbl_acc "
				+ "where acnum = ?";

		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, acNum);

			ResultSet result = pStr.executeQuery();

			if (result.next()) {
				return result2Dto(result);
			}

			pStr.close();
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AccDto> findByBuId(String acBuId) {

		String sql = "select acnum, acdiv, acbuid, acbalance " 
				+ "from tbl_acc " 
				+ "where acbuid = ? "
				+ "order by acnum";

		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, acBuId);

			List<AccDto> accList = db2List(pStr);
			
			return accList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int insert(AccDto acDto) {
		String sql = "insert into tbl_acc(acnum, acdiv, acbuid, acbalance) "
				+ "values(?, ?, ?, ?)" ;
		
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, acDto.acNum);
			pStr.setString(2, acDto.acDiv);
			pStr.setString(3, acDto.acBuId);
			pStr.setInt(4, acDto.acBalance);
			
			int result = pStr.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(AccDto acDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String acNum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
