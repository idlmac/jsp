<%@page import="com.tst.board.BoardVO"%>
<%@page import="com.tst.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetail.jsp</title>
</head>
<body>
	<%
	// 파라미터를 읽어서 BoardDAO에서 한 건 조회기능을 사용해서
	// 화면에 출력하도록 구현하세요.
	String bno = request.getParameter("id");
	BoardDAO dao = new BoardDAO();
	BoardVO vo = dao.getBoard(Integer.parseInt(bno));
	%>
	<!-- 글번호, 제목, 내용, 작성자, 작성일자, 조회수 -->
	<table border="1">
		<tbody>
			<tr><th>글번호</th><td><%=vo.getBoardId()%></td></tr>
			<tr><th>글제목</th><td><%=vo.getTitle()%></td></tr>
			<tr><th>글내용</th><td><%=vo.getContent() %></td></tr>
			<tr><th>작성자</th><td><%=vo.getWriter()%></td></tr>
			<tr><th>작성일자</th><td><%=vo.getCreateDate() %></td></tr>
			<tr><th>조회수</th><td><%=vo.getCnt()%></td></tr>
		</tbody>
	</table>
	<%
		String loginId = (String) session.getAttribute("loginId");
		if(loginId != null && loginId.equals(vo.getWriter())) {
	%>
	<button onclick="location.href='updateForm.jsp?id=<%=vo.getBoardId()%>'">수정하기</button><br><br>
	<button onclick="location.href='deleteForm.jsp?id=<%=vo.getBoardId()%>'">삭제하기</button><br><br>
	<%
		}
	%>
	<button onclick="location.href='boardList.jsp'">뒤로가기</button><br>
</body>
</html>