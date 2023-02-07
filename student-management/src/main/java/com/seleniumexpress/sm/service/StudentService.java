package com.seleniumexpress.sm.service;

import java.util.List;

import com.seleniumexpress.sm.api.Student;
import com.seleniumexpress.sm.api.StudentDTO;

public interface StudentService {
	
	List<StudentDTO> loadStudent();

	void saveStudent(StudentDTO studentDTO);

	Student getStudent(int StudentId);
	
	void updateStudent(StudentDTO studentDTO);
	
	void deleteStudent(int StudentId);
}
