package book.view;

import book.model.dto.BookDTO;
import book.model.dto.MemberDTO;
import book.service.BookController;

public class StartView {

	public static void main(String[] args) {

		System.out.println("--------------모든 주문정보 조회--------------");
		EndView.bookListView(BookController.getAllBookOrder());

		System.out.println("--------------모든 회원정보 조회--------------");
		EndView.allView(BookController.getAllMember());

		System.out.println("-------------- 모든 책 정보 조회--------------");
		EndView.allView(BookController.getAllBooks());
		
		System.out.println("회원 id 삭제 후 재검색");
		BookController.deleteMember("gybhb0021");
		
		EndView.allView(BookController.getAllMember());
		System.out.println("회원 입력 후 재검색");
		MemberDTO m1 = new MemberDTO("kohnbb12", "4456", "김우진", "010-1111-1211", "일산");
		BookController.addMember(m1);
		EndView.bookListView(BookController.getAllMember());
		
		System.out.println("---책 수정-----");
		BookController.updateBook("안녕", 15000, "웅진", "이진규", "1998.11.12", "12TCH45N");
		EndView.bookListView(BookController.getAllBooks());
		System.out.println("회원 id 삭제 후 재검색");
		
	}

}
