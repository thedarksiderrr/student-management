package com.seleniumexpress.sm.api;

public class StudentDTO {

	private Integer StudentId;
	private String studentName;
	private Long studentMobile;
	private String studentCountry;

	public Integer getStudentId() {
		return StudentId;
	}

	public void setStudentId(Integer studentId) {
		StudentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Long getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}

	public String getStudentCountry() {
		return studentCountry;
	}

	public void setStudentCountry(String studentCountry) {
		this.studentCountry = studentCountry;
	}

	@Override
	public String toString() {
		return "StudentId=" + StudentId + ", studentName=" + studentName + ", studentMobile=" + studentMobile
				+ ", studentCountry=" + studentCountry;
	}

}
