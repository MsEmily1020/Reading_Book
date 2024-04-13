package project;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

public class 배달 extends BaseFrame {
	public 배달() {
		super("배달", 700, 500);

		main.add(setBounds(btn[0] = new JButton(getIcon("datafiles/아이콘/홈.png", 40, 40)), 585, 15, 40, 40));
		main.add(setBounds(btn[1] = new JButton(getIcon("datafiles/아이콘/장바구니.png", 40, 35)), 635, 15, 40, 40));

		btn[0].addActionListener(e -> {
			changeFrame(new 메인());
		});
		
		btn[1].addActionListener(e -> {
			try {
				var rs = getResult("select * from cart where c_no = ?", userNo);
				if(rs.next()) changeFrame(new 장바구니());
				else showErr("장바구니가 비었습니다.");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		JScrollPane jsp1 = new JScrollPane(jp[0] = new JPanel());
		main.add(setBounds(jsp1, 0, 60, 685, 50));
		jsp1.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));
		main.add(setBounds(new JScrollPane(jp[1] = new JPanel(null), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), 0, 105, 685, 360));

		jp[1].add(setBounds(cb[0] = new JComboBox("기본순,별 점순,찜 많은 순,주문 많은 순,가까운 순".split(",")), 560, 15, 95, 30));

		for (int i = 2; i <= 12; i++) {
			if (i == 2)
				jp[0].add(btn[i] = new JButton("전체"));
			else
				jp[0].add(btn[i] = new JButton(menu[i - 3]));

			btn[i].setPreferredSize(new Dimension(110, 40));

			btn[i].addActionListener(e -> {
				for (int j = 2; j <= 12; j++) {
					if (e.getSource() == btn[j])
						btn[j].setBorder(new MatteBorder(0, 0, 2, 0, Color.orange));
					else
						btn[j].setBorder(new MatteBorder(0, 0, 2, 0, Color.gray));
					createStore(j - 2);
				}
			});
		}

		setComponent(main);
		setComponent(jp[0]);
		jp[0].setBackground(Color.white);
		jp[1].setBackground(Color.white);

		for (int i = 2; i <= 12; i++) {
			if (i == selectMain)
				btn[selectMain].setBorder(new MatteBorder(0, 0, 2, 0, Color.orange));
			else
				btn[i].setBorder(new MatteBorder(0, 0, 2, 0, Color.gray));
		}
		createStore(0);
	}

	public static void createStore(int db) {

	}

	public static void main(String[] args) {
		new 배달().setVisible(true);
	}
}
