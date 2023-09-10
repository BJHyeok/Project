<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입</title>
<style type="text/css">
header {
	background-color: #87CEFA;
	color: white;
	padding: 10px;
	
}


span {
	font-size:4em;
	font-wiehgt:bold;
}

form {
	margin-right: 100px;
	letter-spacing: 1px;
	font-size: 17px;
}

footer {
	background-color: darkgray;
	height: 50px;
}
	
main {
	text-align: center;
}

p {
	font-size: 2em;
}

input {
	width: 150px;
	height: 30px;
}
</style>

</head>
<body>

	<!-- header -->
		
	<header>
		<a href="main.jsp"><img src="imgs/logo_transparent.png" style="vertical-align:middle; margin-right: auto;" width="250" height="250"></a>
			<span style="color:white; font-weight: bold; margin-top: 20px; margin-left: 50px">Hexagon Salary management</span>
	
	</header>
	
	<main>
	<form action="join.do" method="post">
		<p>
			아이디: <input type="text" name="id" value="${param.id}">
			<c:if test="${errors.id}">ID를 입력하세요.</c:if>
			<c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
		</p>
		<p>
			이름: <input type="text" name="name" value="${param.name}">
			<c:if test="${errors.name}">이름을 입력하세요.</c:if>
		</p>
		<p>
			암호: <input type="password" name="password">
			<c:if test="${errors.password}">암호를 입력하세요.</c:if>
		</p>
		<p>
			암호확인: <input type="password" name="confirmPassword">
			<c:if test="${errors.confirmPassword}">확인을 입력하세요.</c:if>		
			<c:if test="${errors.notMatch}">암호와 확인이 일치하지 않습니다.</c:if>
		</p>
		<input type="submit" value="회원가입">		

	</form>
	</main>
	
	<!-- footer -->
	<footer>
		<p>footer 영역</p>
	</footer>
</body>
</html>