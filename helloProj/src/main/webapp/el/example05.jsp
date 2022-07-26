<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example05.jsp</title>
</head>
<body>
	<%
	for (int i = 0; i <= 10; i++) {
		out.print("i : " + i + "<br>");
	}
	String[] str = { "엄엉중", "엄준식", "제이팍" };
	for (String name : str) {
		System.out.print(name);
	}
	String fruits = "사과, 바나나,수박,망고,애플망고,망고스틴	";
	%>
	<c:set var="names" value="<%=str%>" />
	<c:set var="fruits2" value="<%=fruits %>"/>
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:out value="${i }"></c:out>
		<br>
	</c:forEach>

	<ul>
		<c:forEach var="name" items="${names }">
			<li>${name }</li>
		</c:forEach>
	</ul>
	
	<ul>
		<c:forTokens items="${fruits2 }" delims="," var="fruit">
			<li>${fruit }</li>
		</c:forTokens>
	</ul>
</body>
</html>