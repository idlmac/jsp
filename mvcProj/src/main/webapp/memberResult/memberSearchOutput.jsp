<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색결과(memberSearchOutput.jsp)</title>
</head>
<body>
	<h3>검색결과</h3>
	<c:if test="${!empty member }">
		<p> 아이디 : ${member.id} <br> 비밀번호 :  ${member.passwd} <br> 이름 :  ${member.name } <br>
			이메일 : ${member.mail }</p>
	</c:if>
	<jsp:include page="home.jsp"></jsp:include>
</body>
</html>