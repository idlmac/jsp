<%@page import="com.tst.board.BoardDAO"%>
<%@page import="com.tst.board.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");

// 로그인 시도 시 에러메세지
RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");

BoardDAO dao = new BoardDAO();
if (dao.loginCheck(id, pw) == null) {
	request.setAttribute("msg", "아이디와 비밀번호 확인부탁드려요");
	rd.forward(request, response);
	//resoponse.sendRedirect("loginForm.jsp")
} else {
	session.setAttribute("loginId", id);
	response.sendRedirect("boardList.jsp");
}
%>