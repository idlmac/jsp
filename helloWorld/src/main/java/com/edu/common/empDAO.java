package com.edu.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class empDAO extends DAO {

	public boolean updateMember(String name, String pass, String role) {
		String sql = "update members set member_password = ?, member_role = ? where member_id =?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, role);
			pstmt.setString(3, name);

			int u = pstmt.executeUpdate();
			if(u > 0) {
				return true;
			}
			System.out.println(u + "건 수정됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// user_name, user_pass, role -> DB 입력
	public boolean insertMember(String name, String pass, String role) {
		String sql = "insert into members values(?,?,?)";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			pstmt.setString(3, role);

			int r = pstmt.executeUpdate();
			
			if(r > 0) {
				return true;
			}
			System.out.println(r + "건 입력됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public List<Employee> getEmpInfo(String name) {
		String sql = "select * from employees where first_name = ?";
		connect(); // conn 객체
		List<Employee> list = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));

				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	public List<Employee> empList() {
		String sql = "select * from employees";
		connect();
		List<Employee> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setSalary(rs.getInt("salary"));
				emp.setJobId(rs.getString("job_id"));

				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
