<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<link rel="stylesheet" href="css/indexBefore.css">
<script type="text/javascript" src="script/Login.js"></script>
</head>
<body>
	<div class="header">
		<h1 class="title">중앙은행</h1>
		<a href="AccountServlet?command=joinFormAction" class="signup">회원가입</a>
		<a href="AccountServlet?command=loginAction" class="login">로그인</a> 
		<div class="clear"></div>
	</div>
	<div class = "main_img">
		<img src="https://via.placeholder.com/650X400" alt="샘플이미지">
	</div>
	<div class="box-container">
		<div class="box" onclick="return alertLogin()">계좌개설</div>
		<div class="box" onclick="return alertLogin()">환율정보</div>
		<div class="box" onclick="return alertLogin()">이체하기</div>
		<div class="box" onclick="return alertLogin()">1:1문의</div>
	</div>	
	<div class="foot">
		<span> Copyright © JOONGANG Bank Corp. All Rights Reserved.</span>
	</div>
</body>
</html>
