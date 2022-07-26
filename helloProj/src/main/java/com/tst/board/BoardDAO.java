package com.tst.board;

import java.util.ArrayList;
import java.util.List;

import com.tst.common.DAO;

public class BoardDAO extends DAO {

	// 등록
	public void insertBoard(BoardVO vo) {
		String sql = "insert into board values((select nvl(max(board_id), 0)+1 from board),?,?,?,sysdate,0)";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건 등록");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 목록
	public List<BoardVO> boardList() {
		String sql = "select * from board order by 1";
		List<BoardVO> list = new ArrayList<>();
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO(rs.getInt("board_id")//
						, rs.getString("title")//
						, rs.getString("content")//
						, rs.getString("writer")//
						, rs.getString("create_date")//
						, rs.getInt("cnt")//
				);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 단건조회
	public BoardVO getBoard(int boardId) {
		String sql = "select * from board where board_id = ?";
		connect();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBoardId(boardId);
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setCreateDate(rs.getString("create_date"));
				vo.setCnt(rs.getInt("cnt"));

				// 카우트 증가
				setCnt(boardId);
				return vo;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 조회수
	public void setCnt(int boardId) {
		String sql = "update board set cnt =cnt+1 where board_id =?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardId);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 글내용 수정
	public void updateBoard(BoardVO vo) {
		String sql = "update board set title=?, content=? where board_id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBoardId());

			int r = pstmt.executeUpdate();

			System.out.println(r + "건 수정");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제
	public void deleteBoard(BoardVO vo) {
		String sql = "delete from board where board_id=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, vo.getBoardId());

			int r = pstmt.executeUpdate();

			System.out.println(r + "건 삭제");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 로그인체크

	public UserVO loginCheck(String userId, String userPw) {
		String sql = "select * from users where id=? and passwd=?";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				UserVO vo = new UserVO();
				vo.setUserId(rs.getString("id"));
				vo.setUserPw(rs.getString("passwd"));
				vo.setUserName(rs.getString("name"));

				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
}
