<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록 페이지</title>
</head>
<body>
	<h3>회원목록</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>NAME</th>
			<th>EMAIL</th>
		</tr>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.id}</td>
				<td>${vo.passwd}</td>
				<td>${vo.name}</td>
				<td>${vo.mail}</td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="home.jsp"></jsp:include>
</body>
</html>