<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action ="editStudentServlet" method="post">
	College: <input type="text" name="college" value="${studentToEdit.college}">
	StudentName: <input type = "text" name= "studentName" value="${studentToEdit.studentName}">
	 
	 <input type = "hidden" name="id" value="${studentToEdit.id}" }>
	 <input type="submit" value="Save Edited Item">
	 </form>

</body>
</html>