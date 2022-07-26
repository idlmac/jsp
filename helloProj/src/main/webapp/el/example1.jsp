<%@page import="com.tst.board.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example1.jsp</title>
</head>
<body>
<%
	request.setAttribute("user_id", "hong");
	UserVO vo = new UserVO();
	vo.setUserId("user1");
	vo.setUserPw("1111");
	vo.setUserName("사용자1");
	request.setAttribute("user", vo);
	
	request.getParameter("userId");
	request.getParameter("userPw");
%>
	Literal :${"LIteral"}
	<br> Operator : ${5>3}
	<br> Object : ${header.host}
	<br> IfCondition : ${5>3 ? "true" : "false" }
	<br> Context : ${pageContext.servletContext.contextPath }
	<br> UserId : ${user_id }
	<br> VO : ${user.userId}, ${user.userPw }, ${user.userName }
	<br> ${empty user ? "값이 없습니다." : user }
	<br> ID : ${param.id }, PW : ${param["pw"] }
</body>
</html>