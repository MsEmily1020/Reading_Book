package book.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import book.vo.BookVO;

public class BookView2 extends JPanel {
	JTable table;
	DefaultTableModel model;
	ArrayList<BookVO> bookVoList;
	String[] header = "도서번호,도서명,출판사,저자명,도서가격,카테고리".split(",");
	String[] categoryName = "IT도서,소설,비소설,경제,사회".split(",");
	JPanel panS;
	JComboBox<String> categoryCb;
	JTextField[] tf = new JTextField[header.length - 1];
	JButton bt = new JButton("도서추가");
	
	public BookView2() {
		setLayout(new BorderLayout());
		
		categoryCb = new JComboBox<String>(categoryName);
		
		panS = new JPanel(new GridLayout(4, 4));
		for (int i = 0; i < header.length; i++) {
			panS.add(new JLabel(header[i]));
			if(i < header.length - 1) panS.add(tf[i] = new JTextField());
			else panS.add(categoryCb);
		}
		
		for(int i = 0; i < 3; i++) panS.add(new JLabel());
		panS.add(bt);
	}

	//JTable 관련 메소드
	public void initView() {
		model = new DefaultTableModel(header, bookVoList.size()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(model);
		int[] columnSize = {50, 200, 100, 100, 50, 50};
		for(int i = 0; i < columnSize.length; i++) table.getColumnModel().getColumn(i).setPreferredWidth(columnSize[i]);
		JScrollPane scroll = new JScrollPane(table);
		
		putResult();
		
		add("Center", scroll);
		add("South", panS);
	}
	
	public void putResult() {
		model.setRowCount(bookVoList.size());
		BookVO vo = null;
		for (int i = 0; i < bookVoList.size(); i++) {
			vo = bookVoList.get(i);
			
			model.setValueAt(vo.getIsbn(), i, 0);
			model.setValueAt(vo.getName(), i, 1);
			model.setValueAt(vo.getPublish(), i, 2);
			model.setValueAt(vo.getAuthor(), i, 3);
			model.setValueAt(vo.getPrice(), i, 4);
			model.setValueAt(vo.getCategory(), i, 5);
			
		}
	}
	
	public void setBookVoList(ArrayList<BookVO> bookVoList) {
		this.bookVoList = bookVoList;
	}
	
	public JButton getBtnAdd() {
		return bt;
	}
	
	public BookVO neededInsertData() {
		BookVO vo = new BookVO();
		vo.setIsbn(Integer.parseInt(tf[0].getText()));
		vo.setName(tf[1].getText());
		vo.setPublish(tf[2].getText());
		vo.setAuthor(tf[3].getText());
		vo.setPrice(Integer.parseInt(tf[4].getText()));
		vo.setCategory((String)categoryCb.getSelectedItem());
		
		return vo;
	}
	
	public void initInsertData() {
		for (int i = 0; i < tf.length; i++) tf[i].setText("");
		categoryCb.setSelectedIndex(0);
	}
}