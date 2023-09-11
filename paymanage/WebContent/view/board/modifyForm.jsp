<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<style type="text/css">
header {
	background-color: #87CEFA;
	color: white;
	padding: 10px;
}


span {
	font-size:3em;
	font-wiehgt:bold;
}



input[type=button] {
	padding: 5px;
	font-size: 15px;
	font-family: Arial;
	margin: 1px;
}

input[type=button]{
	background: orange;
	color: white;
	padding: 5px 5px;
	border-radius: 0 5px 5px 0;
	cursor: pointer;
	font-weight: bold;
}

body {
	background: white;
	line-height: 1.6;
}

main {
	display: flex;
	align-items: baseline;
	gap: 32px;
	padding: 48px 0;
}

article {
	flex: 3;
	background: white;
	padding: 32px;
	border-radius: 16px 0 0 16px;
}

aside {
	width: 300px;
	background: #87CEFA;
	padding: 5px;
	border-radius: 0 16px 16px 0;
	text-align: center;
}

aside h2 {
	font-size: 3em;
	color: white;
}

ul {
	list-style: none;
	padding: 10px;
	color: white;
	font-size: 2em;
}

a {
	text-decoration: none;
}

*, *:before, *:after {
	box-sizing: border-box;
}

footer {
	text-align: right;
	padding: 5px;
	background-color: darkgray;
	height: 50px;
}

input[type=text]{
	width: 450px;
}

textarea {
	width: 450px;
	height: 500px;
}
</style>
</head>
<body>
	
	
		<!-- header 변경 X-->
	
	<header>
		<a href="/paymanage/"><img src="../imgs/logo_transparent.png" style="vertical-align:middle; margin-right: auto;" width="250" height="250"></a>
			<span style="color:white; font-weight: bold; margin-top: 20px; margin-left: 50px">Hexagon Salary management</span>
			<c:if test="${empty authUser}">
				<table style="	float: right; margin-right: 100px;	">
					<tr>
						<td><input type="button" onclick="location.href='login.do'" value="Login"></td>
						<td><input type="button" onclick="location.href='join.do'" value="Sign On"></td>
					</tr>
				</table>
			</c:if>
			<c:if test="${!empty authUser}">
				<table style="	float: right; margin-right: 100px;	">
					<tr>
						<td style="color: white; font-weight: bold; font-size: 20px">${authUser.name}님 <input type="button" onclick="location.href='logout.do'" value="LogOut"></td>
					</tr>
				</table>
				
			</c:if>
	</header>

	<!-- body -->
	<main>
		<aside>
			<nav>
				<h2>목록</h2>
				<ul>
					<li><a href="salary/salarylist.do">급여</a></li>
					<li><a href="employee/employeeinfo.do">인사</a></li>
					<li><a href="work/worklist.do">근태</a></li>
					<li><a href="retire/retirelist.do">퇴직</a></li>
					<li><a href="article/list.do">공지사항</a></li>
				</ul>
			</nav>
		</aside>


	<!-- Information 변경 가능한 정보 -->
	
		<article>
		<h4 style="font-size: 2em; font-weight: bold;">글수정하기</h4>
		<form action="modify.do" method="post">
		<p>
			번호: <br/>${modReq.articleNumber}
		</p>
		<p>
			제목: <br/><input type="text" name="title" value="${modReq.title}">
			<c:if test="${errors.title}">제목을 입력하세요.</c:if>
		</p>
		<p>
			내용: <br/>
			<textarea name="content" rows="5" cols="30">${modReq.content}</textarea>
		</p>
		<input type="submit" value="글 수정">
	</form>

		</article>
		
	<!-- End of Information -->
	</main>

	<!-- footer 변경 X -->
	<footer>
		<p>Hexagon</p>
	</footer>
</body>
</html>