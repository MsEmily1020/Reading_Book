package project;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class 메인 extends BaseFrame {
	public 메인() {
		super("메인", 600, 400);

		main.add(setBounds(lb[0] = new JLabel(userName + "님의 주소"), 30, 15, 150, 20));
		main.add(setBounds(cb[0] = new JComboBox("집,집과 회사".split(",")), 30, 45, 100, 30));
		main.add(setBounds(tf[0] = new JTextField(), 140, 45, 275, 30));
		main.add(setBounds(btn[0] = new JButton("검색"), 425, 45, 90, 30));
		main.add(setBounds(btn[1] = new JButton("MY"), 520, 10, 40, 30));
		
		for (int i = 2; i <= 6; i++) {
			main.add(setBounds(btn[i] = new JButton(menu[i - 2], getIcon("datafiles/메인이미지/" + menu[i - 2] + ".png", 80, 80)), (30 + (i - 2) * 110), 90, 90, 100));
			btn[i].setVerticalTextPosition(JButton.BOTTOM);
			btn[i].setHorizontalTextPosition(JButton.CENTER);
		}

		for (int i = 7; i <= 11; i++) { 
			main.add(setBounds(btn[i] = new JButton(menu[i - 2], getIcon("datafiles/메인이미지/" + menu[i - 2] + ".png", 80, 80)), (30 + (i - 7) * 110), 210, 90, 100));
			btn[i].setVerticalTextPosition(JButton.BOTTOM);
			btn[i].setHorizontalTextPosition(JButton.CENTER);
		}
		
		for(int i = 2; i <= 11; i++) {
			btn[i].addActionListener(e -> {
				for(int j = 2; j <= 11; j++ ) {
					if(e.getSource() == btn[j]) {
						selectMain = j + 1;
						System.out.println(selectMain);
						changeFrame(new 배달());
						return;
					}
				}
			});
		}
		
		btn[0].addActionListener(e -> {
			if (tf[0].getText().length() == 0) {
				showErr("빈칸이 있습니다.");
				return;
			}

			try {
				var rs = getResult("select * from menu where replace(m_menu, ' ', '') like ?",
						"%" + tf[0].getText().replaceAll(" ", "") + "%");
				if (rs.next()) {
					rs.beforeFirst();
					while (rs.next()) {
						store.add(rs.getInt("r_no"));
					}
					changeFrame(new 배달());
				}

				else {
					showErr("검색 결과가 없습니다.");
					tf[0].setText("");
					tf[0].grabFocus();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		btn[1].addActionListener(e -> changeFrame(new 마이페이지()));

		setComponent(main);

		tf[0].setBorder(new LineBorder(Color.black));
		btn[0].setForeground(Color.white);
		btn[0].setBackground(Color.orange);
	}

	public static void main(String[] args) {
		new 메인().setVisible(true);
	}
}
