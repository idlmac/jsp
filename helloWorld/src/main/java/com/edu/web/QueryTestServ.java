package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/queryTest")
public class QueryTestServ extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		String id = req.getParameter("id"); // parameter : id값을 반환
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String[] hobby = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String introduction = req.getParameter("introduction");

		out.print("<h3>입력받은 값</h3>");
		out.print("<p> ID : " + id + "</p>");
		out.print("<p> 비밀번호 : " + pw + "</p>");
		out.print("<p> 이름 : " + name + "</p>");
		out.print("<p> 취미 : <ul> ");
		for (int i = 0; i < hobby.length; i++) {
			out.print("<li>" + hobby[i] + "</li>");
		}
		out.print("</ul>");
		out.print("<p> 성별 : " + gender + "</p>");
		out.print("<p> 종교 : " + religion + "</p>");
		out.print("<p> 소개 : " + introduction + "</p>");
		out.print("질의문자열 : " + req.getQueryString());

		out.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

//		String id = req.getParameter("id"); // parameter : id값을 반환
//		String pw = req.getParameter("pw");
//		String name = req.getParameter("name");
//		String[] hobby = req.getParameterValues("hobby");
//		String gender = req.getParameter("gender");
//		String religion = req.getParameter("religion");
//		String introduction = req.getParameter("introduction");
//
//		out.print("<h3>입력받은 값</h3>");
//		out.print("<p> ID : " + id + "</p>");
//		out.print("<p> 비번 : " + pw + "</p>");
//		out.print("<p> 이름 : " + name + "</p>");
//		out.print("<p> 취미 : <ul> ");
//		for (int i=0; i<hobby.length; i++) {
//			out.print("<li>"+hobby[i]+"</li>");
//		}
//		out.print("</ul>");
//		out.print("<p> 성별 : " + gender + "</p>");
//		out.print("<p> 종교 : " + religion + "</p>");
//		out.print("<p> 자기소개 : " + introduction + "</p>");
		ServletInputStream sis = req.getInputStream(); // post : 입력스트림
		int leng = req.getContentLength(); // 데이터 크기
		byte[] buf = new byte[leng];
		sis.readLine(buf, 0, leng);
		String queryString = new String(buf);
		out.print("<p 'id=queryString'> " + queryString + "</p>");
		sis.close();
		out.close();
	}
}
