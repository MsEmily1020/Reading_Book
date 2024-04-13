package project;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class K공동구매 extends BaseFrame {
	
	DefaultTableModel dtm = new DefaultTableModel("상품사진,상품명,공동구매 회원명,승인금액".split(","), 0) {
		public boolean isCellEditable(int row, int column) { return false; };
        public Class getColumnClass(int column) {
            return column == 0 ? JLabel.class : Object.class;
        }
	};
	
	public K공동구매() {
		super("공동구매 승인", 700, 580);
		main.add(setBounds(lb[0] = new JLabel(" 공동구매 승인"), 0, 0, 700, 35));
		main.add(setBounds(lb[1] = new JLabel("상품번호"), 20, 55, 80, 25));
		main.add(setBounds(tf[0] = new JTextField(), 105, 50, 205, 35));
		main.add(setBounds(btn[0] = actionbtn("검색", e -> dispose()), 315, 50, 85, 35));
		main.add(setBounds(btn[1] = actionbtn("전체승인", e -> dispose()), 585, 50, 95, 35));
		main.add(setBounds(new JScrollPane(table[0] = new JTable(dtm)), 5, 95, 675, 410));
		
		setComponent(main);
		
		lb[0].setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		
		table[0].getColumnModel().getColumn(0).setPreferredWidth(80);
		table[0].getColumnModel().getColumn(1).setPreferredWidth(120);
		table[0].getColumnModel().getColumn(2).setPreferredWidth(120);
		table[0].getColumnModel().getColumn(3).setPreferredWidth(120);
		
	}

	public static void main(String[] args) {
		new K공동구매().setVisible(true);
	}
}
