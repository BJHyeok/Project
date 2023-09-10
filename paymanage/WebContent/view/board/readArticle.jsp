<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 읽기</title>
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

form {
	float: right;
	margin-right: 100px;
	letter-spacing: 1px;
	font-size: 17px;
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

.tg  {border-collapse:collapse;border-color:#9ABAD9;border-spacing:0;}
.tg td{background-color:#EBF5FF;border-color:#9ABAD9;border-style:solid;border-width:1px;color:#444;
  font-family:Arial, sans-serif;font-size:14px;overflow:hidden;padding:10px 20px;word-break:normal;}
  
.tg th{background-color:#409cff;border-color:#9ABAD9;border-style:solid;border-width:1px;color:#fff;
  font-family:Arial, sans-serif;font-size:14px;font-weight:normal;overflow:hidden;padding:10px 20px;word-break:normal;}
.tg .tg-c3ow{border-color:inherit;text-align:center;vertical-align:top}
.tg .tg-8nlf{background-color:#409cff;border-color:inherit;color:#ffffff;text-align:center;vertical-align:top}
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
			
			<table class="tg" style="width: 1300px; text-align: center;">
			<thead>
			  <tr>
			    <th class="tg-c3ow" style="width: 100px;">번호</th>
			    <th class="tg-c3ow">제목</th>
			    <th class="tg-c3ow" style="width: 150px;">작성자</th>
			  </tr>
			</thead>
			<tbody>
			  <tr>
			    <td class="tg-c3ow">${articleData.article.number}</td>
			    <td class="tg-c3ow">${articleData.article.title}</td>
			    <td class="tg-c3ow">${articleData.article.writer.name}</td>
			  </tr>
			  <tr>
			    <td class="tg-8nlf" rowspan="2">내용</td>
			    <td class="tg-c3ow" colspan="2" rowspan="2">${articleData.getContent()}</td>
			  </tr>
			  <tr>

			  </tr>
			  <tr>
			  		<td colspan="3">
			  	 	<c:set var="pageNo" value="${empty param.pageNo?'1':param.pageNo}" />
						<a href="list.do?pageNo=${pageNo}">[목록]</a>
						<c:if test="${authUser.id == articleData.article.writer.id}">
							<a href="modify.do?no=${articleData.article.number}">[게시글 수정]</a>
							<a href="delete.do?no=${articleData.article.number}">[게시글 삭제]</a>
						</c:if>
			  	</td>
			  </tr>
			</tbody>
			</table>
			
		</article>
		
	<!-- End of Information -->
	</main>

	<!-- footer 변경 X -->
	<footer>
		<p>Hexagon</p>
	</footer>


</body>
</html>