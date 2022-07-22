package com.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.empDAO;

@WebServlet("/addMember")
public class addMembersServ extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자 : user_name=user2&user_password=1234&roll=1
		String name = req.getParameter("user_name");
		String pass = req.getParameter("user_pass");
		String role = req.getParameter("role");
		
		empDAO dao = new empDAO();
		
		resp.setContentType("text/html;charset=UTF-8");
		
		//get : 수정, post : 입력
		//DB입력
		boolean isTrue = false;
		if(req.getMethod().toUpperCase().equals("GET")) {
			isTrue = dao.updateMember(name, pass, role);
		} else {
			isTrue = dao.insertMember(name, pass, role);
		}
		
		if(isTrue) {
			resp.getWriter().print("성공");
		}else {
			resp.getWriter().print("실패");			
		}
		
		// DB 입력
		dao.insertMember(name, pass, role);
		
		
	}
	

}
