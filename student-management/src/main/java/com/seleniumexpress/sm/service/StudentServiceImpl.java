package com.seleniumexpress.sm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.sm.DAO.StudentDAO;
import com.seleniumexpress.sm.api.Student;
import com.seleniumexpress.sm.api.StudentDTO;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public List<StudentDTO> loadStudent() {

		// call the dao method to get the data and send it to service
		List<Student> loadStudent = studentDAO.loadStudent();
		List<StudentDTO> students = new ArrayList<>();
		for (int i = 0; i < loadStudent.size(); i++) {
			Student s = loadStudent.get(i);
			// get from entity and set it to dto
			StudentDTO dto = new StudentDTO();
			dto.setStudentId(s.getId());
			dto.setStudentName(s.getName());
			dto.setStudentMobile(s.getMobile());
			dto.setStudentCountry(s.getCountry());
			students.add(dto);
		}

		return students;
	}

	@Override
	public void saveStudent(StudentDTO studentDTO) {
		// save the data to the database
		studentDAO.saveStudent(studentDTO);

	}

	@Override
	public Student getStudent(int StudentId) {

		return studentDAO.getStudent(StudentId);

	}

	@Override
	public void updateStudent(StudentDTO studentDTO) {

		studentDAO.updateStudent(studentDTO);
	}

	@Override
	public void deleteStudent(int StudentId) {
		
		studentDAO.deleteStudent(StudentId);
	}

}
