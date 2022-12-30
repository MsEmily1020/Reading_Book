package book.controller;

import java.util.Scanner;

import book.view.BookView;
import book.vo.BookDAO;
import book.vo.BookVO;

public class BookController {
	static BookDAO dao = new BookDAO();
	
	public void insert() {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		while(true) {
			BookVO bvo = new BookVO();
			System.out.print("도서번호 : ");
			bvo.setIsbn(sc2.nextInt());
			
			System.out.print("도서 이름 : ");
			bvo.setBookName(sc1.nextLine());
			
			System.out.print("출판사 : ");
			bvo.setPublish(sc1.nextLine());
			
			System.out.print("작가 : ");
			bvo.setAuthor(sc1.nextLine());
			
			System.out.print("가격 : ");
			bvo.setPrice(sc2.nextInt());
			
			System.out.print("카테고리 : ");
			bvo.setCategory(sc1.nextLine());
			
			dao.setBvo(bvo);
			System.out.println();
			System.out.print("계속 : 0, 종료 : 1 --> ");
			if(sc2.nextInt() == 1) break;
			System.out.println();
		}
		
		sc1.close();
		sc2.close();
	}
	
	public static void main(String[] args) {
		BookController controller = new BookController();
		controller.insert();
		BookView bookView = new BookView();
		bookView.view(dao.getBvo());
	}
}
