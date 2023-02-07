package com.seleniumexpress.sm.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seleniumexpress.sm.api.Student;
import com.seleniumexpress.sm.api.StudentDTO;
import com.seleniumexpress.sm.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> loadStudent() {

//		List<Student> studentList = new ArrayList<Student>();

		String sql = "SELECT * FROM student";
		List<Student> theListOfStudent = jdbcTemplate.query(sql, new StudentRowMapper());

		return theListOfStudent;
	}

	@Override
	public void saveStudent(StudentDTO studentDTO) {
		// write a logic to store the student object to the database
		Object[] sqlParameters = { studentDTO.getStudentName(), studentDTO.getStudentMobile(),
				studentDTO.getStudentCountry() };

		String sql = "insert into student (name,mobile,country) values(?,?,?)";
		jdbcTemplate.update(sql, sqlParameters);

	}

	@Override
	public Student getStudent(int StudentId) {

		String sql = "select * from student where id = ?";
		Student studentUpdate = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), StudentId);

		return studentUpdate;
	}

	@Override
	public void updateStudent(StudentDTO studentDTO) {
		// write a logic to store the student object to the database
		Object[] sqlParameters = { studentDTO.getStudentName(), studentDTO.getStudentMobile(),
				studentDTO.getStudentCountry(), studentDTO.getStudentId() };

		String sql = "update student set name=?, mobile=?, country=? WHERE id = ?";
		jdbcTemplate.update(sql, sqlParameters);

	}

	@Override
	public void deleteStudent(int StudentId) {

		String sql = "delete from student where id = ?";
		jdbcTemplate.update(sql, StudentId);

	}
}
