package com.callor.student.service;

import java.util.List;

import com.callor.student.models.StudentDto;

public interface StudentService {

	public void loadStudnet();
	public void printStudent();
	public void insertStudent();
	public StudentDto getStudent(String stNum); // 학번을 통해 학생 객체 찾기
	public List<StudentDto> getStudentList(); // List에 저장된 학생객체 모두 가져오기
}
