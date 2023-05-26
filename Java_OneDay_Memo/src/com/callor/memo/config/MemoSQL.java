package com.callor.memo.config;

public class MemoSQL {
	
	public static final String InsertSQL = "insert into tbl_memo(m_seq, m_writer, m_date, m_subject, m_content) "
			+ "values(seq_memo.nextval, #{m_writer}, #{m_date}, #{m_subject}, #{m_content})";
	
	public static final String UpdateSQL = "update tbl_memo "
											+ "set m_writer = #{m_writer}, "
											+ "m_date = #{m_date}, "
											+ "m_subject = #{m_subject}, "
											+ "m_content = #{m_content} "
											+ "where m_seq = #{m_seq}";

}
