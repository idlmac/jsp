<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example06.jsp</title>
</head>
<body>

	<h3>안녕하세요구르트</h3>
	스크립트릿 :
	<%@include file="footer.jsp"%>
	XML :
	<jsp:include page="footer.jsp"></jsp:include>
	JSTL :
	<c:import url="footer.jsp" var="foot"></c:import>
	${foot }
</body>
</html>