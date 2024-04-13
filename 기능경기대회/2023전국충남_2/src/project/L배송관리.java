package project;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class L배송관리 extends BaseFrame {
	
	DefaultTableModel dtm = new DefaultTableModel("상품명,회원명,수량,총금액,상태".split(","), 0) {
		public boolean isCellEditable(int row, int column) { return false; };
	};
	
	public L배송관리() {
		super("배송관리", 800, 520);
		main.add(setBounds(lb[0] = new JLabel(" 배송관리"), 0, 0, 800, 35));
		main.add(setBounds(lb[1] = new JLabel("상태"), 20, 55, 35, 20));
		main.add(setBounds(lb[2] = new JLabel("상품명"), 200, 55, 50, 20));
		main.add(setBounds(lb[3] = new JLabel("회원명"), 405, 55, 55, 20));
		main.add(setBounds(cb[0] = new JComboBox<String>("전체,결제완료,배송중".split(",")), 60, 50, 110, 30));
		main.add(setBounds(tf[0] = new JTextField(), 255, 50, 130, 30));
		main.add(setBounds(tf[1] = new JTextField(), 465, 50, 135, 30));
		main.add(setBounds(btn[0] = actionbtn("검색", e -> dispose()), 640, 50, 140, 30));
		main.add(setBounds(new JScrollPane(table[0] = new JTable(dtm)), 10, 90, 770, 355));
		
		setComponent(main);
		
		lb[0].setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
	}

	public static void main(String[] args) {
		new L배송관리().setVisible(true);
	}
}
