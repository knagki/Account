<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<link rel="stylesheet"  href="css/indexAfter.css">
</head>
<body>
	<div class="header">
		<h1 class="title">중앙은행</h1>
		<a href="AccountServlet?command=myPageAction" class="mypage">마이페이지</a>
		<a href="AccountServlet?command=logoutAction" class="logout">로그아웃</a> 
		<div class="clear"></div>
	</div>
	<div class = "main_img">
		<img src="https://via.placeholder.com/650X400" alt="샘플이미지">
	</div>
	<div class="box-container">
		<div class="box" onclick="location.href='AccountServlet?command=createAccountAction';">계좌개설</div>
		<div class="box" onclick="location.href='AccountServlet?command=exchangeAction';">환율정보</div>
		<div class="box" onclick="location.href='AccountServlet?command=transactionAction';">이체하기</div>
		<div class="box" onclick="location.href='AccountServlet?command=customerBoardForm';">1:1문의</div>
	</div>	
	<div class="foot">
		<span> Copyright © JOONGANG Bank Corp. All Rights Reserved.</span>
	</div>
</body>
</html>
