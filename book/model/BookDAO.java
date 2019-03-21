package book.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.exception.NotExistException;
import book.model.dto.BookDTO;
import book.model.util.DBUtil;

// 책 DAO 클래스
public class BookDAO {
		// insert
		public static boolean addBook(BookDTO book) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("insert into books values(?, ?, ?, ?, ?, ?");
				pstmt.setString(1, book.getCode());
				pstmt.setString(2, book.getBname());
				pstmt.setInt(3, book.getPrice());
				pstmt.setString(4, book.getPublish());
				pstmt.setString(5, book.getWriter());
				pstmt.setString(6, book.getDate());

				int result = pstmt.executeUpdate();

				if (result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}
		
		// book_code로 모든 정보 수정하기
		
		public static boolean updateBook(String bname, int price, String publish, String writer, String date, String code) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DBUtil.getConnection();

				pstmt = con.prepareStatement("update books set book_name=?, book_price=?, book_publish=?, book_writer=?, book_register=TO_DATE(?,'yyyy/mm/dd')  where book_code=?");
			
				pstmt.setString(1, bname);
				pstmt.setInt(2, price);
				pstmt.setString(3, publish);
				pstmt.setString(4, writer);
				pstmt.setString(5, date);
				pstmt.setString(6, code);

				int result = pstmt.executeUpdate();
				if (result == 1) {
					return true;
				}
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}
		
		// code로 모든 정보 삭제하기
		public static boolean deleteBook(String code) throws SQLException, NotExistException {
	
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
			
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("delete from books where book_code=?");
				pstmt.setString(1, code);

				pstmt.executeUpdate();
					
			} finally {
				DBUtil.close(con, pstmt);
			}
			return false;
		}
		// code로 해당정보 조회하기
		public static BookDTO getBook(String code) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			BookDTO book = null;

			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from books where book_code=?");
				pstmt.setString(1, code);
				rset = pstmt.executeQuery();
				if (rset.next()) {
					book = new BookDTO(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getString(4),
							rset.getString(5), rset.getString(6));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return book;
		}
		
		// code로 모든 정보 조회하기
		public static ArrayList<BookDTO> getAllBook() throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<BookDTO> books = null;
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select * from books");
				rset = pstmt.executeQuery();

				books = new ArrayList<BookDTO>();
				while (rset.next()) {
					books.add(new BookDTO(rset.getString(1), rset.getString(2), rset.getInt(3), rset.getString(4),
							rset.getString(5), rset.getString(6)));
				}
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return books;
		}

}
