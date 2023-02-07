<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>

<link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourceFolder/css/add-student.css">
</head>
<body>
	<div class="container" align="center">
		<h3>Add Student</h3>
		<hr>
		<form:form action="saveStudent" modelAttribute="addStudentDetail"
			method="POST">
			<form:hidden path="StudentId" />
			<label>Name: </label>
			<form:input path="studentName" />
			<br>
			<label>Mobile: </label>
			<form:input path="studentMobile" />
			<br>
			<label>Country: </label>
			<form:input path="studentCountry" />
			<br>
			<input type="submit" value="Submit">
		</form:form>

	</div>
</body>
</html>