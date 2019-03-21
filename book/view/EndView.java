package book.view;

import java.util.ArrayList;

import book.model.dto.BookOrderDTO;



public class EndView {
	
	// 모든 주문 리스트 출력
	public static void bookListView(ArrayList allbooklist) {
		
		int length = allbooklist.size();
		if (length != 0) {
			for (int index = 0; index < length; index++) {
				System.out.println("조회 " + (index + 1) + " - " + allbooklist.get(index));
			}
		}
	}
	
	// 특정 주문 조회 출력
	public static void OrderView(BookOrderDTO bookorder) {
		System.out.println(bookorder);
	}
	
	// 모든 DTO 정보 출력하는 메소드
	public static void allView(Object object) {
		System.out.println(object);
	}

	// 예외 상황 출력
	public static void showError(String msg) {
		System.out.println(msg);

	}
}
