<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>

<link rel="stylesheet" type="text/css"
	href="/student-management/URLToReachResourceFolder/css/add-student.css">

<link rel="stylesheet" type="text/css"
	href="/student-management/URLToReachResourceFolder/css/my-style-sheet.css">

<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body class="body">

	<div class="container" align="center">
		<h1 class="h1">Add Student</h1>
		<hr>
		<form:form class="myFonts" action="saveStudent"
			modelAttribute="addStudentDetail" method="POST">
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
			<br>
			<!-- <input type="submit" value="Submit" class="myButton"> -->
			<button type="submit" class="btn btn-outline-light">ADD</button>
		</form:form>

	</div>
</body>
</html>