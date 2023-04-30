<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 관리(table)</title>

<script type="text/javascript" src="script/updateFormScript.js"></script>

<style>
	body{
		margin: 0 auto;
		width: 60%;
	}
	
	form{
		background-color: rgb(194,194,194);
	}

</style>

</head>
<body>
<!-- action : servlet으로 이동, method: get/post중  -->
	<form action="AccountServlet" method="post" name="update_frm">
	<h1>중앙은행</h1> 
	
	<h3>회원정보 관리</h3>
	<table>
		<tr>
			<th colspan = "2"></th>
		</tr>
		
		<tr>
			<td>이름(고정): </td>
			<td><input id="name" type="text" value="${customer.name}" disabled="disabled"></td>
		</tr>
		
		<tr>
			<td>아이디(고정) : </td>
			<td><input id = "id" type="text" value="${customer.id}" disabled="disabled"></td>
		</tr>
		
		<tr>
			<td>비밀번호: </td>
			<td><input name="pw" type ="password"></td>
		</tr>
		
		<tr>
			<td>비밀번호 확인: </td>
			<td><input name="pwCon" type ="password"></td>
		</tr>
		
		<tr>	
			 
			<td>연락처: </td>
			<td><input id="phone" type = "text" size="11" maxlength="11">
				  <input type="hidden" value="${customer.phone}">
			</td>
		</tr>
		
		<tr>
			<td>이메일: </td>
			<td>
			<input name="email" value="${customer.email}" type="text">
			<input type="hidden" value="${customer.email}">
			</td>
		</tr>
		
		<tr>
			<td>직업: </td>
			<td><select>
				  <option> -- 선택 -- </option> 
				  <option value="${customer.job}" ${customer.job == 'desk' ? 'selected' : ''}> 사무직 </option>
				  <option value="${customer.job}" ${customer.job == 'special' ? 'selected' : ''}> 전문직 </option>
				  <option value="${customer.job}" ${customer.job == 'field' ? 'selected' : ''}> 현장직 </option>
				  <option value="${customer.job}" ${customer.job == 'government' ? 'selected' : ''}> 공무원 </option>
				  <option value="${customer.job}" ${customer.job == 'student' ? 'selected' : ''}> 학생 </option>
				  <option value="${customer.job}" ${customer.job == 'soldier' ? 'selected' : ''}> 군인 </option>
				  <option value="${customer.job}" ${customer.job == 'house' ? 'selected' : ''}> 주부 </option>
				  <option value="${customer.job}" ${customer.job == 'etc' ? 'selected' : ''}> 기타 </option> 
				</select>
			</td>
		</tr>
		
	</table>
	<!-- 마이페이지 >> 수정페이지 고객 고유번호(customer.customer_num) 넘기기 -->
							   <%-- ${customer.customer_num} --%>

	<input type="hidden" value="customer_update" name="command">
	<input type="submit" value="수정하기" onclick="return updateCheck()"> 
	<input type="reset" value="취소">
	<hr>	
	<input type="button" value="회원탈퇴" onclick="location.href='customerDeleteForm.jsp'">																		  
	</form>
</body>
</html>