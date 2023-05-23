package com.callor.bank.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.bank.config.DBConnection;
import com.callor.bank.config.DBContract;
import com.callor.bank.models.BuyerDto;
import com.callor.bank.service.BuyerService;

public class BuyerServiceImplV1 implements BuyerService {

	protected final List<BuyerDto> buyerList;
	protected final Connection dbConn;
	
	public BuyerServiceImplV1() {
		buyerList = new ArrayList<>();
		
		// DB 연결을 위한 객체 초기화 된 객체를 가져오기
		dbConn = DBConnection.getDBConn();
	}
	
	protected BuyerDto result2Dto(ResultSet result) {
		BuyerDto buDto = new BuyerDto();
		try {
			buDto.buId = result.getString(DBContract.BUYER.BUID);
			buDto.buName = result.getString(DBContract.BUYER.BUNAME);
			buDto.buTel = result.getString(DBContract.BUYER.BUTEL);
			buDto.buAddr = result.getString(DBContract.BUYER.BUADDR);
			buDto.buBirth = result.getString(DBContract.BUYER.BUBIRTH);
			buDto.buJob = result.getString(DBContract.BUYER.BUJOB);
			return buDto;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<BuyerDto> selectAll() {
		String sql = "select buid, buname, butel, buaddr, bubirth, bujob "
		 + "from tbl_buyer "
		 + "order by buid";
		
		try {

			PreparedStatement pStr = dbConn.prepareStatement(sql);
			ResultSet result = pStr.executeQuery();
			
			while(result.next()) {
				
				BuyerDto buDto = result2Dto(result);
				buyerList.add(buDto);
			}
			return buyerList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * SQL 명령문 작성 주의!!
	 * where 절 명령문을 작성할 때 
	 * 절대 변수와 전달 값을 + 연산으로 묶어서
	 * 처리하지 말 것
	 * 
	 *  다음과 같은 코드를 사용할 경우
	 * " where buid = " + id;
	 * 만약 id 변수에 "0001 OR 1=1" 과 같은 문자열이 담겨서
	 * 전달될 경우 where 절이 무력화 된다
	 * SQL 문이 DELETE 와 같은 명령이라면
	 * TABLE의 모든 데이터가 삭제되는 SQL 질의문이 실행된다
	 * 
	 * ==> SQL Injection 공격 이라고 한다.
	 */
	@Override
	public BuyerDto findById(String id) {
		String sql = "select buid, buname, butel, buaddr, bubirth, bujob "
				 + " from tbl_buyer "
				 + "where buid = ?";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, id); // 1번째 물음표에 id 매개변수를 전달
			
			ResultSet result = pStr.executeQuery();
			if(result.next()) {
				return result2Dto(result);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int insert(BuyerDto dto) {
		String sql = "insert into tbl_buyer(buid, buname, butel) "
				+ " values(?, ?, ?)";
		
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, dto.buId);
			pStr.setString(2, dto.buName);
			pStr.setString(3, dto.buTel);
			
			// SQL로 전달하는 명령대로 DB를 변경(insert)하라 라는 의미
			// executeUpdate()는 정상적으로 업데이트 되었다면 1이 return이 된다
			int result = pStr.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(BuyerDto dto) {
		
		String sql = "update tbl_buyer "
				+ "set buname = ?, butel = ?, buaddr = ?, "
				+ "     bubirth = ?, bujob = ? "
				+ "where buid = ?";

		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, dto.buName);
			pStr.setString(2, dto.buTel);
			pStr.setString(3, dto.buAddr);
			pStr.setString(4, dto.buBirth);
			pStr.setString(5, dto.buJob);
			pStr.setString(6, dto.buId);
			return pStr.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(String id) {
		String sql = "delete from tbl_buyer where buid = ?";
		
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, id);
			
			int result = pStr.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	

}
