package com.callor.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.shop.config.ShopSQL;
import com.callor.shop.models.IoListDto;

public interface IoListDao {
	
	// 모든 판매 내역 조회
	@Select(" select * from tbl_iolist")
	public List<IoListDto> findAll();

	@Select(" select * from tbl_iolist where iobuid = #{id} ")
	public List<IoListDto> findById(String id);
	
	// 고객 이름으로 장바구니 리스트 조회
//	@Select(" select * from tbl_iolist where iobuid = #{pname}")
//	public List<IoListDto> findByName(String pname);
	
	// 판매 시 내역 기록
	@Insert(ShopSQL.ioInsertSql)
	public int insert(IoListDto ioListDto);
	
	// 판매 내역 수정
	@Update(ShopSQL.ioUpdateSql)
	public int update(IoListDto ioListDto);

}
