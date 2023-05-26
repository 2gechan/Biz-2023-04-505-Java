package com.callor.memo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.memo.config.MemoSQL;
import com.callor.memo.models.MemoDto;

public interface MemoDao {
	
	// 작성된 메모 리스트 조회
	@Select(" select * from tbl_memo ")
	public List<MemoDto> selectMemoList();

	// PK 인 m_seq 를 매개변수로 입력 받아 특정 메모 찾기
	@Select(" select * from tbl_memo where m_seq = #{id} ")
	public MemoDto findById(int id);
	
	@Insert(MemoSQL.InsertSQL)
	public int insert(MemoDto memoDto);
	
	@Update(MemoSQL.UpdateSQL)
	public int update(MemoDto memoDto);
	
	// PK 인 m_seq 를 매개변수로 받아 데이터 삭제
	@Delete(" delete from tbl_memo where m_seq = #{seq}")
	public int delete(int seq);

}
