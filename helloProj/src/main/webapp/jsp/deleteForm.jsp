<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteForm.jsp</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	BoardDAO dao = new BoardDAO();
	BoardVO vo = dao.getBoard(Integer.parseInt(id));
	%>
	
	<c:set var="boardId" value="<%=vo.getBoardId() %>"></c:set>
	<c:set var="title" value="<%=vo.getTitle() %>"></c:set>
	<c:set var="content" value="<%=vo.getContent() %>"></c:set>
	<c:set var="writer" value="<%=vo.getWriter() %>"></c:set>
	<c:set var="createDate" value="<%=vo.getCreateDate() %>"></c:set>
	<c:set var="cnt" value="<%=vo.getCnt() %>"></c:set>
	<form action="delete.jsp">
	
		<table border="1">
			<tr><th>글번호</th><td><input type="text" name="bid"  value="${boardId }" readonly></td></tr>
			<tr><th>글제목</th><td>${title }</td></tr>
			<tr><th>글내용</th><td>${content }</td></tr>
			<tr><th>작성자</th><td>${writer }</td></tr>
			<tr><th>작성일자</th><td>${createDate }</td></tr>
			<tr><th>조회수</th><td>${cnt }</td></tr>
			<tr><td colspan="2"><input type="submit" value="삭제" ></td></tr>
		</table>
	</form>
</body>
</html>