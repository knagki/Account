<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 개설하기</title>
<link rel="stylesheet" type="text/css" href="css/CreateAccount.css">
<script type="text/javascript" src="script/CreateAccount.js"></script>
</head>
<body>
	<div class="main">
		<header>
			<div class="logo" onclick="location.href='AccountServlet?command=indexAfterLogin'">중앙은행</div>
		</header>
	</div>
	<form action="AccountServlet" method = "post" name = "frm">
	<input type="hidden" value="createAccountFormAction" name="command">
	<div id="wrapper">
		<div id="content">
			<h3>
				<label for="reg_num">주민등록번호</label>
			</h3>
			<div class="jumin-container">
			    <span class="box">
			    	<span style="display:inline-block;">
					<input type="text" class = "int" maxlength="6" name="reg_num1" id = "reg_num1" placeholder="YYMMDD" style="width:200px;">
					</span>
					<span style="display:inline;"> 
					-<input type = "password" maxlength="7" name="reg_num2" id = "reg_num2" style="width:100px;" placeholder="XXXXXXX">
					</span>
					<span class="step_url"></span>
				</span>
				<span class="error_next_box"></span>
			</div>
			<div>
				<h3>
					<label for="email">이메일</label>
				</h3>
				<span class="box"> 
					<input type="text" name = "email" id="email" class="int">
					<span class="step_url"></span>
				</span> 
				<span class="error_next_box"></span>
			</div>
			<div>
				<h3>
					<label for="job">직업</label>
				</h3>
				<span class="box">
				 <select id = "job-select" name="job-select" style="border: none;width:420px;height:40px;">
						<option value = "사무직">사무직</option>
						<option value = "전문직">전문직</option>
						<option value = "현장직">현장직</option>
						<option value = "공무원">공무원</option>
						<option value = "학생">학생</option>
						<option value = "군인">군인</option>
						<option value = "주부">주부</option>
						<option value = "주부">기타</option>
				</select>
				<!-- <input type="text" id="job" style="display:none;" class="int" maxlength="20"> -->
				</span> 
				<span class="error_next_box"></span>
			</div>
			<div class="btn_area">
				<button type="submit" id="btnJoin" onclick="return createAccount();">개설하기</button>
			</div>
		</div>
	</div>
	</form>
	<footer>
		<div class="footer-wrap">
			<span> Copyright © JOONGANG Corp. All Rights Reserved.</span>
		</div>
	</footer>
</body>
</html>