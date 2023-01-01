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

public class BookView extends JPanel {
	JTable table;
	DefaultTableModel model;
	ArrayList<BookVO> bvo = new ArrayList<BookVO>();
	JPanel gnPn = new JPanel(new GridLayout(4,4));
	String[] header = "도서번호,도서이름,출판사,작가,가격,카테고리".split(",");
	String[] categoryName = "IT도서,소설,비소설,경제,사회".split(",");
	JTextField[] tf = new JTextField[header.length - 1];
	JComboBox<String> cb = new JComboBox<String>(categoryName);
	JButton bt = new JButton("추가");
	
	public BookView() {
		setLayout(new BorderLayout());
		
		for (int i = 0; i < header.length; i++) {
			gnPn.add(new JLabel(header[i]));
			if(i < tf.length) gnPn.add(tf[i] = new JTextField());
			else gnPn.add(cb);
		}
		
		for(int i = 0; i < 3; i++) gnPn.add(new JLabel());
		
		initTable();
		gnPn.add(bt);
	}
	
	public void initTable() {
		model = new DefaultTableModel(header, bvo.size()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(model);
		
		int[] columnSize = {50, 200, 100, 100, 50, 50};
		for (int i = 0; i < columnSize.length; i++) table.getColumnModel().getColumn(i).setPreferredWidth(columnSize[i]);
		
		JScrollPane scroll = new JScrollPane(table);
		
		add(scroll, "Center");
		add(gnPn, "South");
	}
	
	public void setData() {
		model.setRowCount(bvo.size());
		BookVO vo = null;
		for (int i = 0; i < bvo.size(); i++) {
			vo = bvo.get(i);
			
			model.setValueAt(vo.getIsbn(), i, 0);
			model.setValueAt(vo.getName(), i, 1);
			model.setValueAt(vo.getPublish(), i, 2);
			model.setValueAt(vo.getAuthor(), i, 3);
			model.setValueAt(vo.getPrice(), i, 4);
			model.setValueAt(vo.getCategory(), i, 5);
		}
	}
	
	public BookVO getData() {
		BookVO vo = new BookVO();
		
		vo.setIsbn(Integer.parseInt(tf[0].getText()));
		vo.setName(tf[1].getText());
		vo.setPublish(tf[2].getText());
		vo.setAuthor(tf[3].getText());
		vo.setPrice(Integer.parseInt(tf[4].getText()));
		vo.setCategory((String)cb.getSelectedItem());
		return vo;
	}
	
	public void insert(ArrayList<BookVO> bvo) {
		this.bvo = bvo;
	}
	
	public JButton addBt() {
		return bt;
	}
	
	public void initInsetData() {
		for (int i = 0; i < tf.length; i++) tf[i].setText("");
		cb.setSelectedIndex(0);
	}
}
