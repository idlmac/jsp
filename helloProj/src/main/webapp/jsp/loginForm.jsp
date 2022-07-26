<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm.jsp</title>
</head>
<body>
	<c:set var="msg" value="${msg}"></c:set>
	<c:if test="${!empty msg }">
		<c:out value="아이디와 비밀번호 확인부탁드립니다."/>
	</c:if>
	
	<form action="login.jsp" method="post">
		ID : <input type="text" name="id"><br> 
		PW : <input type="password" name="pw"><br> 
		<input type="submit" value="로그인">
	</form>
</body>
</html>