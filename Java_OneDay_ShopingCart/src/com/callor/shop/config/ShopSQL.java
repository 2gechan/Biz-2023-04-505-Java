package com.callor.shop.config;

public class ShopSQL {
	
	public static final String pInsertSql = " insert into tbl_product "
			+ "(pcode, pname, pitem, piprice, poprice) "
			+ " values(#{pCode}, #{pName}, #{pItem}, #{pIPrice}, #{pOPrice})";
	
	public static final String buInsertSql = " insert into tbl_buyer "
			+ "(buid, buname, butel, buaddr) "
			+ " values(#{buId}, #{buName}, #{buTel} , #{buAddr})";
	
	public static final String ioInsertSql = " insert into tbl_iolist "
			+ "(ioSEQ, ioDate, ioTime, ioBuId, ioPCode, ioQuan, ioPrice) "
			+ " values(seq_shop.nextval, #{ioDate}, #{ioTime} , #{ioBuId}, #{ioPCode}, #{ioQuan}, #{ioPrice})";

	public static final String pUpdateSql = "update tbl_product set "
			+ "pname = #{pName}, "
			+ "pitem = #{pItem}, "
			+ "piprice = #{pIPrice}, "
			+ "poprice = #{pOPrice} "
			+ "where pcode = #{pCode}";
	
	public static final String buUpdateSql = "update tbl_buyer set "
			+ "buname = #{buName}, "
			+ "butel = #{buTel}, "
			+ "buaddr = #{buAddr} "
			+ "where buid = #{buId}";
	
	public static final String ioUpdateSql = "update tbl_iolist set "
			+ "ioDate = #{ioDate}, "
			+ "ioTime = #{ioTime}, "
			+ "ioBuId = #{ioBuId}, "
			+ "ioPCode = #{ioPCode}, "
			+ "ioQuan = #{ioQuan}, "
			+ "ioPrice = #{ioPrice} "
			+ "where ioSEQ = #{ioSEQ}";
}
