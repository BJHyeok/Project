<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근태 조회</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>구분</td>
			<td>사원번호</td>
			<td>성명</td>
			<td>부서</td>
			<td>직급</td>
		</tr>


		<c:forEach var="attendance" items="${attendance.content }">
			<tr>
				<td>${attendance.classify }</td>
				<td>${attendance.emp_no }</td>
				<td>${attendance.emp_name }</td>
				<td>${attendance.dept }</td>
				<td>${attendance.position }</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>