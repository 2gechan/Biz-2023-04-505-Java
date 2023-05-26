package com.callor.student.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.student.models.StudentDto;

public interface StudentDao {
	
	@Select(" select * from tbl_student")
	public List<StudentDto> selectAll();
	
	

}
