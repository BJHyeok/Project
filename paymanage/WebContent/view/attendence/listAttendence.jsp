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
			<td>입력일자</td>
			<td>근태종류</td>
			<td>근태시작일</td>
			<td>근태종료일</td>
			<td>근태일수</td>
			<td>적요</td>
		</tr>


		<tr>
			<c:forEach var="employee" items="${employeePage.content }">

				<td>${employee.classify }</td>
				<td>${employee.emp_no }</td>
				<td>${employee.emp_name }</td>
				<td>${employee.dept }</td>
				<td>${employee.position }</td>

			</c:forEach>
			
			<c:forEach var="attendancecon"  items="${attendance.content}">
				<td>${attendancecon.entrydate}</td>
				<td>${attendancecon.attendance}</td>
				<td>${attendancecon.startdate}</td>
				<td>${attendancecon.enddate}</td>
				<td>${attendancecon.attendance}</td>
				<td>${attendancecon.enddate}</td>
				<td>${attendancecon.enddate}</td>
			</c:forEach>
		</tr>

	</table>
</body>
</html>