<%@page import="com.tst.board.BoardDAO"%>
<%@page import="com.tst.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = request.getParameter("bid");

BoardVO vo = new BoardVO();
vo.setBoardId(Integer.parseInt(id));

BoardDAO dao = new BoardDAO();
dao.deleteBoard(vo);

response.sendRedirect("boardList.jsp");
%>