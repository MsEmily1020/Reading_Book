package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class D구매 extends BaseFrame {
	
	DefaultTableModel dtm = new DefaultTableModel("참여자이름".split(","), 0) {
		public boolean isCellEditable(int row, int column) { return false; };
	};
	
	public D구매() {
		super("구매", 400, 530);
		main.add(setBounds(lb[0] = new JLabel(" 결제"), 10, 0, 365, 35));
		main.add(setBounds(lb[1] = new JLabel("2인 공동구매 상품", 0), 75, 40, 240, 220));
		main.add(setBounds(lb[2] = new JLabel("정가 : 35,400원"), 15, 270, 160, 35));
		main.add(setBounds(lb[3] = new JLabel("타임세일가 : 20,020원"), 180, 270, 190, 35));
		main.add(setBounds(lb[4] = new JLabel("남성 검은 반팔 티"), 15, 310, 355, 30));
		main.add(setBounds(btn[0] = actionbtn("주문하기", e -> dispose()), 25, 440, 165, 35));
		main.add(setBounds(btn[1] = actionbtn("참여하기", e -> dispose()), 200, 440, 165, 35));
		
		main.add(setBounds(new JScrollPane(table[0] = new JTable(dtm)), 15, 345, 355, 90));
		
		setComponent(main);
		
		lb[0].setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		lb[1].setBorder(new LineBorder(Color.BLACK));
		lb[1].setFont(new Font("맑은 고딕", 1, 16));
		lb[2].setFont(new Font("맑은 고딕", 1, 18));
		lb[3].setFont(new Font("맑은 고딕", 1, 18));
		lb[4].setFont(new Font("맑은 고딕", 1, 18));
		
		lb[3].setForeground(Color.RED);

		table[0].setBackground(Color.WHITE);
		
	}
	
	public static void main(String[] args) {
		new D구매().setVisible(true);
	}
}
