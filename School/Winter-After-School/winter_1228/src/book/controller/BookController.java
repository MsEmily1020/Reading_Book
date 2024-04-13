package book.controller;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import book.view.BookView;
import book.vo.BookDAO;
import book.vo.BookVO;

public class BookController extends JFrame {
	BookDAO dao = new BookDAO();
	ArrayList<BookVO> bvo = dao.select();
	BookView view = new BookView();
	
	public BookController() {
		JButton bt = view.addBt();
		bt.addActionListener(e -> {
			dao.insert(view.getData());
			bvo = dao.select();
			view.insert(bvo);
			view.setData();
			view.initInsetData();
		});
		
		add(view, "Center");
		setTitle("도서관리프로그램");
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(2);
		setResizable(false);
		
	}
	
	public static void main(String[] args) {
		new BookController().setVisible(true);
	}
}
