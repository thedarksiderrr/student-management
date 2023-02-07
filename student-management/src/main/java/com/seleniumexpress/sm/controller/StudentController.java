package com.seleniumexpress.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seleniumexpress.sm.api.Student;
import com.seleniumexpress.sm.api.StudentDTO;
import com.seleniumexpress.sm.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

//	@RequestMapping(value = "/showStudent", method = RequestMethod.GET)
	@GetMapping("/showStudent")
	public String showStudentList(Model model) {

		// call the service method to get the data
		List<StudentDTO> studentList = studentService.loadStudent();

//		for (Student tempStudent : studentList) {
//			System.out.println(tempStudent);
//		}

		model.addAttribute("studentData", studentList);

		return "student-list";
	}

	@GetMapping("/addStudent")
	public String addStudent(Model model, StudentDTO studentDTO) {

		model.addAttribute("addStudentDetail", studentDTO);

		return "add-student";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(StudentDTO studentDTO) {
		// do a service call to save the data

		if (studentDTO.getStudentId() != null) {
			// update exist record
			studentService.updateStudent(studentDTO);
		} else {
			// insert a new record
			studentService.saveStudent(studentDTO);
		}

		/*
		 * // if user does have id then do a update if (studentDTO.getStudentId() !=
		 * null && studentDTO.getStudentId().intValue() > 0) {
		 * studentService.updateStudent(studentDTO); } else // if a user doesn't have id
		 * then do a insert studentService.saveStudent(studentDTO);
		 */

		return "redirect:/showStudent";
	}

	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int StudentId, Model model, StudentDTO dto) {

		Student myStudent = studentService.getStudent(StudentId);
		// get from entity and set it to dto
		dto.setStudentCountry(myStudent.getCountry());
		dto.setStudentId(myStudent.getId());
		dto.setStudentMobile(myStudent.getMobile());
		dto.setStudentName(myStudent.getName());
		System.out.println(myStudent);

		model.addAttribute("addStudentDetail", dto);

		return "add-student";
	}

	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int StudentId, StudentDTO dto) {
		
		studentService.deleteStudent(StudentId);
		
		return "redirect:/showStudent";
	}

	/*
	 * POST/Redirect/GET *
	 * 
	 * @ResponseBody
	 * 
	 * @GetMapping("/thankyou") public String thankYou() {
	 * 
	 * return "thank you...... the record has been added."; }
	 */
}
