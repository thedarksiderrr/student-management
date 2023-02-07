<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
<link rel="stylesheet" type="text/css"
	href="/student-management/URLToReachResourceFolder/css/my-style-sheet.css">

<link rel="stylesheet" type="text/css"
	href="/student-management/URLToReachResourceFolder/css/add-student.css">

<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body class="myFonts">
	<h1 align="center" class="h1">Student Data</h1>
	<hr>
	<div class="container" align="left">
		<form action="/student-management/addStudent">
			<!-- 	<input type="" value="ADD" class="myButton"> -->
			<button type="submit" class="btn btn-outline-dark">ADD</button>
		</form>
	</div>
	<br>
	<div class="container" align="center">
		<table border="1" class="table table-striped">
			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Mobile</td>
					<td>Country</td>
					<td>Update Record</td>
					<td>Delete Record</td>
				</tr>
			</thead>
			<c:forEach var="student" items="${studentData}">
				<tr>
					<td>${student.studentId}</td>
					<td>${student.studentName}</td>
					<td>${student.studentMobile}</td>
					<td>${student.studentCountry}</td>
					<td><a class="btn btn-outline-dark"
						href="/student-management/updateStudent?userId=${student.studentId}">Update</a></td>
					<td><a class="btn btn-outline-dark"
						href="/student-management/deleteStudent?userId=${student.studentId}"
						onclick="if(!(confirm('Are you sure you want to delete this record?'))) return false">Delete</a></td>
				</tr>
			</c:forEach>
		</table>

		<img alt="student photo"
			src="/student-management/URLToReachImageFolder/6308.jpg"
			style="width: 500px; height: auto;">

	</div>

</body>

</html>