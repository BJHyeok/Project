<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>급여 리스트</title>

<style type="text/css">
header {
	background-color: #87CEFA;
	color: white;
	padding: 10px;
}

span {
	font-size: 3em;
	font-weight: bold;
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

input[type=button] {
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
</style>





</head>
<body>
	<!-- header 변경 X-->

	<header>
		<a href="/paymanage/"><img src="/imgs/logo_transparent.png"
			style="vertical-align: middle; margin-right: auto;" width="250"
			height="250"></a> <span
			style="color: white; font-weight: bold; margin-top: 20px; margin-left: 50px">Hexagon
			Salary management</span>
		<c:if test="${empty authUser}">
			<table style="float: right; margin-right: 100px;">
				<tr>
					<td><input type="button" onclick="location.href='login.do'"
						value="Login"></td>
					<td><input type="button" onclick="location.href='join.do'"
						value="Sign On"></td>
				</tr>
			</table>
		</c:if>
		<c:if test="${!empty authUser}">
			<table style="float: right; margin-right: 100px;">
				<tr>
					<td style="color: white; font-weight: bold; font-size: 20px">${authUser.name}님
						<input type="button" onclick="location.href='logout.do'"
						value="LogOut">
					</td>
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
					<li><a href="/paymanage/salary/salarylist.do">급여</a></li>
					<li><a href="/paymanage/employee/employeeinfo.do">인사</a></li>
					<li><a href="/paymanage/work/worklist.do">근태</a></li>
					<li><a href="/paymanage/retire/retirelist.do">퇴직</a></li>
					<li><a href="/paymanage/article/list.do">공지사항</a></li>
				</ul>
			</nav>
		</aside>


		<!-- Information 변경 가능한 정보 -->


		<article>
			<section>
				<form action="salarywrite.do" method="post">
					<table border="1">
						<tr>


							<td>사원번호 : <input type="text" id="emp_no" name="emp_no"></td>

							<td>기본급 : <input type="text" id="base_pay" name="base_pay"></td>



							<td>식비 : <input type="text" id="food" name="food"></td>


							<td>당직비 : <input type="text" id="duty_charge"
								name="duty_charge"></td>


							<td>교통비 : <input type="text" id="transport" name="transport"></td>


							<td>상여금 : <input type="text" id="bonus" name="bonus"></td>
						</tr>

					</table>

					<input type="submit" value="등록">


					<button type="button" onclick="location.href='salarylist.do'">취소</button>
					<br />





					<table border="1">
						<tr>
							<td>지급총액 :</td>



							<td>공제총액 :</td>


							<td>실 지급액 :</td>
						</tr>



					</table>







				</form>
			</section>
		</article>

		<!-- End of Information -->
	</main>

	<!-- footer 변경 X -->
	<footer>
		<p>Hexagon</p>
	</footer>

</body>
</html>