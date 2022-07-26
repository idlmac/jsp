<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example04.jsp</title>
</head>
<body>
	<c:set var="num" value="${80 }"></c:set>

	점수
	<c:out value="${num }" /> 은
	<c:if test="${num >= 60}">
		합격
	</c:if>
	<c:if test="${num lt 60 }">
		불합격
	</c:if>
	<p />
	<c:out value="${num }" />
	<c:choose>
		<c:when test="${num >=90 }">점은 A Grade</c:when>
		<c:when test="${num >=80 }">점은 B Grade</c:when>
		<c:when test="${num >=70 }">점은 C Grade</c:when>
		<c:otherwise>D Grade</c:otherwise>
	</c:choose>

</body>
</html>