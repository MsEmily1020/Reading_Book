package book.vo;

import java.util.ArrayList;

public class BookDAO {
	ArrayList<BookVO> bvo = new ArrayList<BookVO>();
	
	public void insert(BookVO vo) {
		this.bvo.add(vo);
	}
	
	public ArrayList<BookVO> select() {
		return this.bvo;
	}
}
