package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class A메인123 extends BaseFrame {
	
	DefaultTableModel model;
    JTable table;
	
	public A메인123() {
		super("메인", 1000, 700);

		// D 구역
		main.add(setBounds(btn[0] = actbtn("<", e -> dispose()), 11, 14, 30, 30));
		main.add(setBounds(btn[1] = actbtn(">", e -> dispose()), 41, 14, 30, 30));

		// B 구역
		main.add(setBounds(btn[2] = new JButton(getIcon("datafiles/title.jpg", 100, 50)), 31, 50, 100, 50));
		main.add(setBounds(tf[0] = new JTextField("  상품명, 지역명, @상점명 입력"), 161, 59, 530, 35));
		main.add(setBounds(btn[3] = new JButton("판매하기", getIcon("datafiles/image/icon/sell.png", 20, 20)), 715, 69, 75,
				30));
		main.add(setBounds(btn[4] = new JButton("내상점", getIcon("datafiles/image/icon/store.png", 20, 20)), 805, 69, 75,
				30));
		main.add(setBounds(btn[5] = new JButton("차트", getIcon("datafiles/image/icon/chat.png", 20, 20)), 890, 70, 75,
				30));
		main.add(setBounds(btn[6] = new JButton("로그인/회원가입"), 751, 24, 120, 30));
		main.add(setBounds(btn[7] = new JButton("내상점"), 886, 23, 80, 30));

		// C 구역
		main.add(setBounds(lb[0] = new JLabel("찜한상품", 0), 886, 129, 50, 20));
		main.add(setBounds(lb[1] = new JLabel("♥ 0", 0), 883, 148, 55, 20));
		main.add(setBounds(lb[2] = new JLabel("최근본상품", 0), 881, 189, 60, 20));
		main.add(setBounds(jp[0] = new JPanel(), 871, 124, 80, 50));
		main.add(setBounds(jp[1] = new JPanel(), 871, 184, 80, 355));

		// B 구역 검색창
		main.add(setBounds(jp[2] = new JPanel(null), 161, 104, 530, 380));

		jp[2].add(setBounds(btn[8] = actbtn("최근검색어", e -> 검색어(btn[8])), 5, 5, 260, 40));
		jp[2].add(setBounds(btn[9] = actbtn("인기검색어", e -> 검색어(btn[9])), 265, 5, 260, 40));
		jp[2].add(setBounds(btn[10] = actbtn("검색어 전체삭제", e -> dispose()), 5, 345, 100, 30));
		jp[2].add(setBounds(btn[11] = actbtn("닫기", e -> jp[2].setVisible(false)), 470, 345, 50, 30));
		jp[2].add(setBounds(jp[3] = new JPanel(null), 5, 50, 520, 290));
		jp[2].add(setBounds(jp[4] = new JPanel(new GridLayout(2, 1)), 5, 50, 520, 290));
		jp[2].add(setBounds(jp[5] = new JPanel(), 1, 343, 527, 35));

		model = new DefaultTableModel("검색어,버튼".split(","), 0) {
			public boolean isCellEditable(int row, int column) { return false; };
	        public Class getColumnClass(int column) {
	            return column == 1 ? String.class : JButton.class;
	        }
		};
		
		table = new JTable(model);
		table.setBounds(5, 5, 510, 285);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setShowGrid(false);
		
		int[] width = {470, 30};
		for (int i = 0; i < width.length; i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(width[i]);
		}
		table.setRowHeight(30);

		createTable();
		jp[3].add(table);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseClicked(MouseEvent e) {
				model.removeRow(table.getSelectedRow());
				table.revalidate();
				table.repaint();
			}
		});

		tf[0].addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				jp[0].setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				jp[1].setVisible(true);
			}
		});

		setCompoent(main);
		setCompoent(jp[2]);
		setCompoent(jp[3]);
		setCompoent(jp[4]);

		createLB(btn[0], new Font("HY헤드라인M", 1, 12));
		createLB(btn[1], new Font("HY헤드라인M", 1, 12));
		createLB(lb[1], new Font("맑은 고딕", 1, 10));

		tf[0].setBorder(new LineBorder(Color.black));

		jp[0].setBorder(new LineBorder(Color.black));
		jp[1].setBorder(new LineBorder(Color.black));
		jp[2].setBorder(new LineBorder(Color.gray));
		jp[3].setBorder(new LineBorder(Color.black));
		jp[4].setBorder(new LineBorder(Color.red));
		jp[5].setBackground(getBackground());

		lb[1].setForeground(Color.gray);

		btn[8].setBorder(new MatteBorder(0, 0, 2, 0, Color.red));
		btn[9].setBorder(new MatteBorder(0, 0, 2, 0, Color.gray));
		btn[8].setForeground(Color.red);
		btn[9].setForeground(Color.gray);
		btn[10].setOpaque(false);
		btn[11].setOpaque(false);
	}

	public void 검색어(JButton b) {
		if (b.getForeground() == Color.red)
			return;
		btn[8].setBorder(new MatteBorder(0, 0, 2, 0, !jp[3].isShowing() ? Color.red : Color.gray));
		btn[9].setBorder(new MatteBorder(0, 0, 2, 0, jp[3].isShowing() ? Color.red : Color.gray));
		btn[8].setForeground(!jp[3].isShowing() ? Color.red : Color.gray);
		btn[9].setForeground(jp[3].isShowing() ? Color.red : Color.gray);
		jp[3].setVisible(!jp[3].isShowing());
	}
	
	public void createTable() {
		model.setRowCount(0);
		for(int i = 10; i >= 1; i--) {
			model.addRow(new Object[] {
					"검색" + i,
					"X"
			});
		}
	}

	public static void main(String[] args) {
		new A메인123().setVisible(true);
	}
}
