package book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.exception.NotExistException;
import book.model.dto.BookDTO;
import book.model.dto.BookOrderDTO;
import book.model.util.DBUtil;

public class BookOrderDAO {

	// insert
	public static boolean addOrder(BookOrderDTO order) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into bookorder values(?, ?, ?, ?)");
			pstmt.setInt(1, order.getOnumber());
			pstmt.setString(2, order.getId());
			pstmt.setString(3, order.getDate());
			pstmt.setString(4, order.getCode());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// order_no로 모든 주문정보 삭제하기
	public static boolean deleteBookOrder(int orderno) throws SQLException, NotExistException {
		// 전역변수
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 지역변수
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from bookorder where order_no=?");
			pstmt.setInt(1, orderno);

			if (pstmt.executeUpdate() != 0) {
				return true;
			} else {
				throw new NotExistException("정보가 없습니다.");
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	// order_no로 해당정보 조회하기
	public static BookOrderDTO getBookOrder(int orderno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BookOrderDTO order = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from bookorder where order_no=?");
			pstmt.setInt(1, orderno);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				order = new BookOrderDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return order;
	}

	// order_no로 모든 정보 조회하기
	public static ArrayList<BookOrderDTO> getAllBookOrder() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookOrderDTO> orderlist = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from bookorder");
			rset = pstmt.executeQuery();

			orderlist = new ArrayList<BookOrderDTO>();
			while (rset.next()) {
				orderlist.add(new BookOrderDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return orderlist;
	}

}
