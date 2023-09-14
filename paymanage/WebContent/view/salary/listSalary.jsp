<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판 예제</title>

<style type="text/css">
header {
	background-color: #87CEFA;
	color: white;
	padding: 10px;
}

span {
	font-size: 3em;
	font-wiehgt: bold;
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
		<a href="/paymanage/"><img src="imgs/logo_transparent.png"
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

			<label for="month">조회할 연월을 선택하세요: <input type="month"
				id="month" max="2024-01" min="2000-01" value="2023-09">
			</label>

			<section>
				<table border="1">
					<tr>
						<td>구분</td>
						<td>사원번호</td>
						<td>성명</td>
						<td>부서</td>
						<td>지급총액</td>
						<td>공제총액</td>
						<td>실제금액</td>
						<td>수정버튼</td>

					</tr>

					<c:forEach var="salarylist" items="${salaryPage.content}">
						<tr>
							<td>${salarylist.salary.employee.classify}</td>
							<td>${salarylist.salary.employee.emp_no}</td>
							<td>${salarylist.salary.employee.emp_name}</td>
							<td>${salarylist.salary.employee.dept}</td>
							<td>${salarylist.total}</td>
							<td>${salarylist.deduct}</td>
							<td>${salarylist.real}</td>
							<!-- <td><button type="button"
									onclick="location.href='salarymodify.do'">수정하기</button></td> -->
							<td><a
								href="salarymodify.do?emp_no=${salarylist.salary.employee.emp_no}">수정하기</a>
							</td>
						</tr>
					</c:forEach>

				</table>



				<table border="1">
					<c:if test="${salaryPage.hasArticles()}">
						<tr>
							<td colspan="4"><c:if test="${salaryPage.startPage > 5}">
									<a href="salarylist.do?pageNo=${articlePage.startPage - 5}">[이전]</a>
								</c:if> <c:forEach var="pNo" begin="${salaryPage.startPage}"
									end="${salaryPage.endPage}">
									<a href="salarylist.do?pageNo=${pNo}">[${pNo}]</a>
								</c:forEach> <c:if test="${salaryPage.endPage < salaryPage.totalPages}">
									<a href="salarylist.do?pageNo=${articlePage.startPage + 5}">[다음]</a>
								</c:if></td>

						</tr>
					</c:if>
				</table>

				<button type="button" onclick="location.href='salarywrite.do'">생성하기</button>

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