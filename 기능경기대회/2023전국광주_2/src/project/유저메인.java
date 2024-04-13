package project;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class 유저메인 extends BaseFrame {

	public 유저메인() {
		super("main", 600, 500);
		main.add(setBounds(lb[0] = new JLabel("VITAMIN", 0), 230, 10, 125, 35));
		main.add(setBounds(btn[0] = new JButton(getIcon("datafiles/아이콘/로그아웃.PNG", 30, 30)), 530, 50, 40, 40));

		main.add(setBounds(btn[1] = new JButton("나에게 맞는 성분은?"), 20, 105, 135, 25));

		main.add(setBounds(pn[0] = new JPanel(), 2, 90, 580, 170));
		main.add(setBounds(pn[1] = new JPanel(), 2, 260, 580, 200));

		// 회원으로 로그인
		main.add(setBounds(btn[2] = actionbtn("Store", e -> changeFrame(new Store())), 10, 60, 65, 25));
		main.add(setBounds(btn[3] = actionbtn("Chart", e -> changeFrame(new Chart())), 80, 60, 60, 25));
		main.add(setBounds(lb[1] = new JLabel(userName + "님"), 450, 60, 50, 30));
		main.add(setBounds(btn[4] = new JButton(getIcon("datafiles/아이콘/마이페이지.PNG", 30, 30)), 500, 55, 30, 30));

		setComponent(main);

		pn[0].setBorder(new LineBorder(Color.black));
		pn[1].setBorder(new LineBorder(Color.black));
		lb[0].setFont(new Font("맑은 고딕", 1, 20));
		btn[1].setBackground(Color.green);

		btn[0].addActionListener(e -> {
			changeFrame(new 로그인());
		});

		btn[1].addActionListener(e -> {
			try {
				var rs = getResult("select * from result where u_no = ?", userId);
				if (rs.next()) {
					int yes = JOptionPane.showConfirmDialog(null, "기존 결과를 초기화 하고 다시 하시겠습니까?(yes/no)", "질문",
							JOptionPane.YES_NO_OPTION);
					if (yes == JOptionPane.YES_OPTION) {
						changeFrame(new Survey());
					}
				}

				else {
					changeFrame(new Survey());
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		btn[4].addActionListener(e -> {changeFrame(new Mypage()); });
	}

	public static void main(String[] args) {
		new 약국메인().setVisible(true);
	}
}
