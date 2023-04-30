<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 정보관리</title>
<link href="css/myPage_style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div id="header">
		<h3 id="logo">중앙은행</h3>
		<input id="logout" type="submit" value="로그아웃"> 
		<input id="mypage" type="submit" value="마이페이지"> nav1 nav2 nav3
	</div>
	<div id="contents">
		<h3>my page</h3>
		프로필 사진<br>
	</div>
	<hr>
	<form action = "AccountServlet" method = "get">
		거래내역 조회
		<br>
		<hr>
		회원정보
		<br> 
		-이름
		<br> 
		-내 통장
		<br> 
		-이체한도
		<br>
		<hr>
		회원정보 관리
		<br>
		<!-- 메인페이지 >> 마이페이지로 넘어올때 고유 고객번호(customer_num)을 넘겨줌 -->
		<input type="hidden" value="customer_update_form" name="command">
		<input type="hidden" value="5" name="customer_num">
		<input type="submit" value="회원정보 관리"><br>
		<%---아이디 변경X <br>
	-비밀번호 변경<br>
	-주소지 변경<br> 
	<hr>
	-탈퇴--%>
	</form>
</body>
</html>