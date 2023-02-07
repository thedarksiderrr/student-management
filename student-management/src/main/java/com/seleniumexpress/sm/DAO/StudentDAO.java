package com.seleniumexpress.sm.DAO;

import java.util.List;

import com.seleniumexpress.sm.api.Student;
import com.seleniumexpress.sm.api.StudentDTO;

public interface StudentDAO {

	List<Student> loadStudent();

	void saveStudent(StudentDTO studentDTO);

	Student getStudent(int StudentId);

	void updateStudent(StudentDTO studentDTO);
	
	void deleteStudent(int StudentId);
}
