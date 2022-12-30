package book.vo;

import java.util.ArrayList;

public class BookDAO {
	ArrayList<BookVO> bvo = new ArrayList<BookVO>();
	
	public void setBvo(BookVO bvo) {
		this.bvo.add(bvo);
	}
	
	public ArrayList<BookVO> getBvo() {
		return this.bvo;
	}
}
