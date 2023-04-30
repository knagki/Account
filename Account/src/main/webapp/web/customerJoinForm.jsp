<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중앙 회원가입</title>
<link href="css/Join.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="script/Join.js"></script>
</head>
<body>
	<div class="main">
		<!-- header -->
		<div class="main">
			<!--웹페이지 상단-->
			<header>
				<!--LOGO-->
				<div class="logo" onclick="location.href='AccountServlet?command=indexBeforeLogin'">중앙은행</div>
			</header>
		</div>
		<!-- content-->
		<form action="AccountServlet" method="post">
			<input type="hidden" name="command" value="joinAction">
			<div id="content">

				<!-- NAME -->
				<div>
					<h3 class="join_title">
						<label for="name">이름</label>
					</h3>
					<span class="box"> <input type="text" name="name" id="name"
						class="int" maxlength="20" placeholder="한글로 입력해주세요">
					</span>
				</div>

				<!-- ID -->
				<div>
					<h3 class="join_title">
						<label for="id">아이디</label>
					</h3>
					<span class="box"> <input type="text" name="id" id="id"
						class="int" placeholder="아이디는 8자리 이상 입력"> <span
						class="step_url"></span>
					</span>
				</div>

				<!-- PW1 -->
				<div>
					<h3 class="join_title">
						<label for="pswd1">비밀번호</label>
					</h3>
					<span class="box"> <input type="password" name="pswd"
						id="pswd1" class="int" maxlength="20"
						placeholder="영문.숫자.특수문자 합쳐서 8자리 이상 15자리 이하로 입력">
					</span>
				</div>

				<!-- PW2 -->
				<div>
					<h3 class="join_title">
						<label for="pswd2">비밀번호 확인</label>
					</h3>
					<span class="box"> <input type="password" id="pswd2"
						class="int" maxlength="20">
					</span>
				</div>


				<!-- MOBILE -->
				<div>
					<h3 class="join_title">
						<label for="phoneNo">휴대전화</label>
					</h3>
					<span class="box"> <input type="tel" name="mobile"
						id="mobile" class="int" maxlength="16" placeholder="010-xxxx-xxxx">
					</span>
				</div>


				<!-- JOIN BTN-->
				<div class="btn_area">
					<button type="submit" id="btnJoin" onclick="return checkInput()">
						<span>가입하기</span>
					</button>
				</div>
			</div>
		</form>
		<!-- content-->
		<footer>
			<div class="copyright-wrap">
				<span> Copyright © JOONGANG Corp. All Rights Reserved.</span>
			</div>
		</footer>
	</div>
	<!-- wrapper -->
</body>
</html>