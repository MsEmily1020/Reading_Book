package project;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class 약국메인 extends BaseFrame {
	public 약국메인() {
		super("main", 600, 500);
		main.add(setBounds(lb[0] = new JLabel("VITAMIN", 0), 230, 10, 125, 35));
		main.add(setBounds(btn[0] = new JButton(getIcon("datafiles/아이콘/로그아웃.PNG", 30, 30)), 530, 50, 40, 40));

		main.add(setBounds(btn[1] = new JButton("나에게 맞는 성분은?"), 20, 105, 135, 25));

		main.add(setBounds(pn[0] = new JPanel(), 2, 90, 580, 170));
		main.add(setBounds(pn[1] = new JPanel(), 2, 260, 580, 200));

		main.add(setBounds(lb[1] = new JLabel(storeName + " " + storeAddress), 10, 60, 500, 25));
		btn[1].setText("이미지 바꾸기");
		btn[1].setLocation(425, 215);
		lb[1].setForeground(Color.gray);

		setComponent(main);

		pn[0].setBorder(new LineBorder(Color.black));
		pn[1].setBorder(new LineBorder(Color.black));
		lb[0].setFont(new Font("맑은 고딕", 1, 20));
		btn[1].setBackground(Color.green);

		btn[0].addActionListener(e -> {
			changeFrame(new 로그인());
		});

		btn[1].addActionListener(e -> {
		});
	}

	public static void main(String[] args) {
		new 약국메인().setVisible(true);
	}
}
