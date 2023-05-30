package com.callor.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.shop.config.ShopSQL;
import com.callor.shop.models.ProductDto;

public interface ProductDao {
	
		@Select(" select * from tbl_product order by pcode")
		public List<ProductDto> findAll();

		// 특정 상품 조회
		@Select(" select * from tbl_product where pcode = #{pcode} ")
		public ProductDto findById(String pcode);
		
		// 상품 이름으로 조회
		@Select(" select * from tbl_product where pname = #{pname} order by pcode ")
		public ProductDto findByName(String pname);
		
		@Insert(ShopSQL.pInsertSql)
		public int insert(ProductDto productDto);
		
		@Update(ShopSQL.pUpdateSql)
		public int update(ProductDto productDto);
		

}
