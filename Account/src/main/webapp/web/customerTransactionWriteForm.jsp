<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 이체 페이지</title>
<link rel="stylesheet" type="text/css" href="css/Account.css">
<script type="text/javascript" src="script/transaction.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>${customer.name}님</h1>
		<form name="frm" method="post" action="AccountServlet">
			<input type="hidden" name="command" value="transaction_write">
			<table>
				<tr>
					<th colspan="2">출금가능금액 ${account.balance}원</th>
				</tr>
				<tr>
					<th colspan="2">본인 계좌번호: ${account.account_num}<input
						type="hidden" id="senderAccount" name="sender_account"
						value="${account.account_num}"></th>
				</tr>
				<tr>
					<th>받는 계좌번호:</th>
					<td><input type="text" name="receiver_account"
						onkeyup="setSenderAccount()"></td>
				</tr>
				<tr>
					<th>이체 금액:</th>
					<td><input type="text" name="amount"></td>
				</tr>
				<tr>
					<th>이체 내용:</th>
					<td><input type="text" name="send_context"></td>
				</tr>
				<tr>
					<th>이체 종류:</th>
					<td><select id="transaction_type" name="transaction_type"
						onchange="setSenderAccount()">
							<option value="in">입금</option>
							<option value="out">출금</option>
					</select></td>
				</tr>

			</table>
			<br> <br> <input type="submit" value="이체"
				onclick="AccountCheck()"> <input type="button" value="목록"
				onclick="location.href='AccountServlet?command=transactionFormAction'">
			<!-- location.href='AccountServlet?command=transaction' -->
		</form>
	</div>
</body>
</html>