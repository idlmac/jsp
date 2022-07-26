<%@page import="com.tst.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/boardList.jsp</title>
</head>
<body>

	<c:choose>
		<c:when test="${!empty loginId }">
			<h3>
				<c:out value="${loginId }"></c:out>
				님으로 로그인하셨습니다.
			</h3>
		</c:when>
		<c:otherwise>
			<h3>손님입니다람쥐 :D</h3>
		</c:otherwise>
	</c:choose>

	<table border="1">
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>글내용</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<%
			BoardDAO dao = new BoardDAO();
			List<BoardVO> list = dao.boardList();
			//for (BoardVO vo : list) {
			%>
			<c:set var="boards" value="<%=list%>" />
			<c:forEach var="vo" items="${boards }">
				<tr>
					<td><a href="boardDetail.jsp?id=${vo.boardId }">${vo.boardId }</a></td>
					<td>${vo.title }</td>
					<td>${vo.content }</td>
					<td>${vo.writer }</td>
					<td>${vo.createDate}</td>
					<td>${vo.cnt}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<br>
	<button onclick="location.href='addBoard.jsp'">글 작성</button>

</body>
</html>