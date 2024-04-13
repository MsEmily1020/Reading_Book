package pro;

import java.awt.Font;

import javax.swing.JLabel;

public class BookViewFrame extends BaseFrame{
	public BookViewFrame() {
		super("도서목록", 800, 600);
		
		setLayout(null);
		var title = new JLabel("도서 목록", 0);
		title.setFont(new Font("맑은 고딕", 1, 24));
		add(setBounds(title, 0, 40, 790, 30));
		
		
	} 
	
	public static void main(String[] args) {
		new BookViewFrame().setVisible(true);
	}
}
