package book.controller;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import book.view.BookView2;
import book.vo.BookDAO;
import book.vo.BookVO;

public class BookController2 extends JFrame {
	BookDAO dao = new BookDAO();
	ArrayList<BookVO> bookVOList = dao.getBvo();
	BookView2 view = new BookView2();
	
	public BookController2() {
		view.setBookVoList(bookVOList);
		view.initView();
		JButton bt = view.getBtnAdd();
		bt.addActionListener(e -> {
			//neededInsertData() : panS에 있는 JTextField에 입력된 값들과 JCombobox의 값
			//BookVO 필드값들을 초기화하여 BookVO 객체 참조값을 반환하는 메소드
			BookVO vo = view.neededInsertData();
			dao.setBvo(vo);
			bookVOList = dao.getBvo();
			view.setBookVoList(bookVOList);
			view.putResult();
			view.initInsertData();
		});
		
		add(view, "Center");
		setTitle("도서관리시스템");
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);
		setSize(600, 500);
	}
	
	public static void main(String[] args) {
		new BookController2().setVisible(true);
	}
	
}
