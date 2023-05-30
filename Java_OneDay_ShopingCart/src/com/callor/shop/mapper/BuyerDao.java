package com.callor.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.shop.config.ShopSQL;
import com.callor.shop.models.BuyerDto;

public interface BuyerDao {
	
	@Select(" select * from tbl_buyer order by buname")
	public List<BuyerDto> findAll();

	@Select(" select * from tbl_buyer where buid = #{id} ")
	public BuyerDto findById(String id);
	
	@Select(" select * from tbl_buyer where buname = #{name} order by buid ")
	public BuyerDto findByName(String name);
	
	@Insert(ShopSQL.buInsertSql)
	public int insert(BuyerDto buyerDto);
	
	@Update(ShopSQL.buUpdateSql)
	public int update(BuyerDto buyerDto);

}
