package book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.model.dto.MemberDTO;
import book.model.util.DBUtil;
import book.exception.NotExistException;

//회원 DAO 클래스
public class MemberDAO {
	// insert
	public static boolean addMember(MemberDTO member) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into bookmember values(?, ?, ?, ?, ?)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getTel());
			pstmt.setString(5, member.getPostal());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 회원 id로 비밀번호 변경하기
	public static boolean updateMember(String id, String pwd) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update bookmember set bookmember_pwd=? where bookmember_id=?");
			pstmt.setString(1, pwd);
			pstmt.setString(2, id);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 회원 id로 회원정보 삭제
	public static boolean deleteMember(String id) throws SQLException, NotExistException {
		// 전역변수
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 지역변수
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from bookmember where bookmember_id=?");
			pstmt.setString(1, id);

			if (pstmt.executeUpdate() != 0) {
				return true;
			} else {
				throw new NotExistException("정보가 없습니다.");
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	// id로 해당 기부자의 모든 정보 반환
	public static MemberDTO getMember(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO member = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from bookmember where bookmember_id=?");
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				member = new MemberDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return member;
	}

	public static ArrayList<MemberDTO> getAllMembers() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MemberDTO> members = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from bookmember");
			rset = pstmt.executeQuery();

			members = new ArrayList<MemberDTO>();
			while (rset.next()) {
				members.add(new MemberDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
						rset.getString(5)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return members;
	}
}
