package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class J회원관리 extends BaseFrame {
	
	DefaultTableModel dtm = new DefaultTableModel("복원,이름,아이디,탈퇴이유".split(","), 0) {
		public boolean isCellEditable(int row, int column) { return false; };
        public Class getColumnClass(int column) {
            return column == 0 ? Boolean.class : Object.class;
        }
	};
	
	public J회원관리() {
		super("회원관리", 600, 620);
		main.add(setBounds(lb[0] = new JLabel(" 회원관리"), 0, 0, 600, 35));
		main.add(setBounds(lb[1] = new JLabel("탈퇴 복원 신청 목록"), 15, 50, 190, 25));
		main.add(setBounds(lb[2] = new JLabel("휴면 복원 신청 목록"), 15, 310, 190, 25));
		main.add(setBounds(btn[0] = actionbtn("확인", e -> dispose()), 465, 45, 105, 30));
		main.add(setBounds(btn[1] = actionbtn("확인", e -> dispose()), 465, 305, 105, 30));
		main.add(setBounds(pn[0] = new JPanel(new GridLayout(1, 1)), 10, 80, 570, 210));
		main.add(setBounds(pn[1] = new JPanel(new GridLayout(1, 1)), 10, 340, 570, 210));

		pn[0].add(new JScrollPane(table[0] = new JTable(dtm)));
		pn[1].add(new JScrollPane(table[1] = new JTable(dtm)));
		
		setComponent(main);
		
		lb[0].setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		lb[1].setFont(new Font("맑은 고딕", 1, 18));
		lb[2].setFont(new Font("맑은 고딕", 1, 18));
		
		table[0].getColumnModel().getColumn(0).setPreferredWidth(10);
		table[0].getColumnModel().getColumn(1).setPreferredWidth(30);
		table[0].getColumnModel().getColumn(2).setPreferredWidth(30);
		table[0].getColumnModel().getColumn(3).setPreferredWidth(200);
		table[1].getColumnModel().getColumn(0).setPreferredWidth(10);
		table[1].getColumnModel().getColumn(1).setPreferredWidth(30);
		table[1].getColumnModel().getColumn(2).setPreferredWidth(30);
		table[1].getColumnModel().getColumn(3).setPreferredWidth(200);
		
	}

	public static void main(String[] args) {
		new J회원관리().setVisible(true);
	}
}
