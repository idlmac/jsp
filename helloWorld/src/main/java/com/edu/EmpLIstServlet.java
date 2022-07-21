package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empList")
public class EmpLIstServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		empDAO dao = new empDAO();
		List<Employee> list = dao.empList();
		
		PrintWriter out = resp.getWriter();
		
		out.print("<table border = '1' ");
		out.print("<thead></tr><th>사원번호</th><th>성</th><th>이름</th><th>이메일</th><th>입사일자</th><th>급여</th><th>직무</th></thead>");
		out.print("<tbody>");
		for(Employee emp : list) {
			out.print("<tr><td>"+emp.getEmployeeId()+"</td>"
					+"<td>"+emp.getLastName()+"</td>"
					+"<td>"+emp.getFirstName()+"</td>"
					+"<td>"+emp.getEmail()+"</td>"
					+"<td>"+emp.getHireDate()+"</td>"
					+"<td>"+emp.getSalary()+"</td>"
					+"<td>"+emp.getJobId()+"</td></tr>"
					);
		}
		out.print("</tbody>");
		out.print("</table>");
	}

}
