package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = null;
		String param = req.getParameter("p");
		String msg = null;

		// 생성, 변경, 삭제.
		if (param.equals("create")) {
			session = req.getSession(true); // 생성된 세션값이 있으면 session반환, 없으면 새로 생성
			if (session.isNew()) {
				msg = "New Session Create";
			} else {
				msg = "기존 Session 객체 반환";
			}
		} else if (param.equals("delete")) {
			session = req.getSession(false); // 생성된 세션이 있으면 세션반환, 없으면 null
			if (session != null) {
				session.invalidate();
				msg = "세션 객체 삭제";
			} else {
				msg = "삭제할 세션 객체가 없음";
			}
		} else if (param.equals("add")) {
			session = req.getSession(true);
			session.setAttribute("msg", "메세지 추가");
			msg = "세션 객체에 속성 지정";

		} else if (param.equals("get")) {
			session = req.getSession(false); // 세션 객체 없으면 null
			if (session != null) {
				String str = (String) session.getAttribute("msg");
				msg = str;
			} else {
				msg = "데이터를 추출할 세션이 없습니다";
			}
		} else if (param.equals("remove")) {
			session = req.getSession(false);
			if (session != null) {
				session.removeAttribute("msg");
				msg = "세션 객체 속성 삭제";
			} else {
				msg = "제거할 세션 객체 없음";
			}
		}
		resp.getWriter().print("처리결과 : " + msg);
	}
}
