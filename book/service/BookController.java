package book.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import book.model.BookDAO;
import book.model.BookOrderDAO;
import book.model.MemberDAO;
import book.model.dto.BookDTO;
import book.model.dto.BookOrderDTO;
import book.model.dto.MemberDTO;
import book.view.EndView;
import book.exception.NotExistException;

public class BookController {

	// 새로운 회원 저장 로직
	public static void addMember(MemberDTO member) {
		try {
			EndView.allView(MemberDAO.addMember(member));
		} catch (SQLException s) {
			EndView.showError(s.getMessage());
		}
	}

	// 새로운 책 등록 로직
	public static void addBook(BookDTO book) {
		try {
			EndView.allView(BookDAO.addBook(book));
		} catch (SQLException s) {
			EndView.showError(s.getMessage());
		}
	}

	// 새로운 주문 저장 로직
	public static void addBookOrder(BookOrderDTO order) {
		try {
			EndView.allView(BookOrderDAO.addOrder(order));
		} catch (SQLException s) {
			EndView.showError(s.getMessage());
		}
	}

	// 모든 주문 조회 로직
	public static void getAllBookOrder() {
		try {
			EndView.allView(BookOrderDAO.getAllBookOrder());
		} catch (SQLException s) {
			EndView.showError(s.getMessage());
		}
	}

	// 모든 회원 검색 로직
	public static void getAllMember() {
		try {
			EndView.allView(MemberDAO.getAllMembers());
		} catch (SQLException s) {
			EndView.showError(s.getMessage());
		}
	}

	// 모든 책 정보 조회 로직
	public static void getAllBook() {
		try {
			EndView.allView(BookDAO.getAllBook());
		} catch (SQLException s) {
			EndView.showError(s.getMessage());
		}
	}

	// 책코드로 책 정보 수정하기
	public static boolean updateBook(String bname, int price, String publish, String writer, String date, String code) {
		boolean result = false;
		try {
			result = BookDAO.updateBook(bname, price, publish, writer, date, code);
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("책변경 오류");
		}
		return result;
	}

	public static void deleteMember(String memberid) {
		try {
			MemberDAO.deleteMember(memberid);
		} catch (SQLException s) {
			EndView.showError("현재 도서 배송중");
		} catch (NotExistException n) {
			EndView.showError(n.getMessage());
		}
	}
}
