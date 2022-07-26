<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm.jsp</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	BoardDAO dao = new BoardDAO();
	BoardVO vo = dao.getBoard(Integer.parseInt(id));

	%>
	<c:set var="boardId" value="${vo.boardId }"></c:set>
	<c:set var="title" value="${vo.title }"></c:set>
	<c:set var="content" value="${vo.content }"></c:set>
	<c:set var="writer" value="${vo.writer }"></c:set>
	<c:set var="createDate" value="${vo.createDate }"></c:set>
	<c:set var="cnt" value="${vo.cnt }"></c:set>
	
	
	<form action="update.jsp">
		<table border="1">
			<tr><th>글번호</th><td><input type="text" name="bid"  value="${boardId }" readonly></td></tr>
			<tr><th>글제목</th><td><input type="text" name="btitle"  value="${title }"></td></tr>
			<tr><th>글내용</th><td><input type="text" name="bcontent"  value="${content }"></td></tr>
			<tr><th>작성자</th><td>${writer }</td></tr>
			<tr><th>작성일자</th><td>${createDate }</td></tr>
			<tr><th>조회수</th><td>${cnt }</td></tr>
			<tr><td colspan="2"><input type="submit" value="수정" ></td></tr>
		</table>
	</form>
</body>
</html>