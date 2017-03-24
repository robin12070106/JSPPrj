<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WTF</title>
</head>
<body>
	<header>
		<a href="">Home</a>
		<c:if test="${empty sessionScope.id }">
		<a href="account/login">로그인</a>
		</c:if>		
		<a href="account/join">회원가입</a>
		<a href="customer/notice">고객센터</a>
		<c:if test="${not empty sessionScope.id }">
		<a href="account/logout">${sessionScope.id }님 로그아웃</a>
		</c:if>
	</header>
	<h1>WTF</h1>
</body>
</html>