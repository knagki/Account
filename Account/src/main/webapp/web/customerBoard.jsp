<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/board.css">
<meta charset="UTF-8">
<title>1:1문의 게시판</title>
</head>
<body>
	<div id="wrap" align="center">
		<h1>1:1 문의하기</h1>
		<table class="list">
			<tr>
				<td colspan="5" style="border: white; text-align: right">
					<a href="AccountServlet?command=board_write_form&num=${customer.customer_num}">문의 하기</a>
				</td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:forEach var="inquiry" items="${inquiryList}">
				<tr class="record">
					<td>${inquiry.inquiry_num}</td>
					<td>${inquiry.inquiry_content}</td>
					<td>${customer.name}</td>
					<td><fmt:formatDate value="${inquiry.inquiry_date}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>