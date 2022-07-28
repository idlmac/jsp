package co.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.dev.vo.MemberVO;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 연결 메소드
	public void connect() {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 연결끊는 메소드
	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();// 비워두지말아야 함 e.prinsStackTrace라도 적기
		}
	}

	// 입력처리 메소드
	public void insertMember(MemberVO vo) {
		String sql = "insert into member(id, name, passwd, mail) values (?,?,?,?)";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPasswd());
			pstmt.setString(4, vo.getMail());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 멤버리스트
	public List<MemberVO> getList() {
		String sql = "select * from member order by 1";
		List<MemberVO> list = new ArrayList<>();
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setMail(rs.getString("mail"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 단건조회(id)
	public MemberVO searchMember(String id) {
		String sql = "select * from member where id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setMail(rs.getString("mail"));

				return vo;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 수정
	public void updateMember(MemberVO vo) {
		String sql = "update member set name=?, passwd=?, mail=? where id =?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getMail());
			pstmt.setString(4, vo.getId());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건 수정");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제
	public void deleteMember(MemberVO vo) {
		String sql = "delete from member where id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건 삭제");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
