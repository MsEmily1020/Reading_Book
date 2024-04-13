package project;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class 로그인 extends BaseFrame {
	public 로그인() {
		super("로그인", 400, 350);

		main.add(setBounds(lb[0] = new JLabel("로그인", 0), 136, 20, 120, 55));
		lb[0].setForeground(Color.pink);

		// 아이디
		main.add(setBounds(tf[0] = new JTextField(), 30, 105, 330, 40));

		// 비밀번호
		main.add(setBounds(tf[1] = new JTextField(), 30, 150, 330, 40));

		// 자동 로그인
		main.add(setBounds(btn[0] = new JButton(), 30, 210, 20, 20));

		main.add(setBounds(lb[1] = new JLabel("자동 로그인"), 75, 205, 125, 35));

		// 로그인 버튼
		main.add(setBounds(btn[1] = new RoundButton("로그인", null), 30, 255, 330, 30));
		btn[1].addActionListener(e -> {
			try {
				if(tf[0].getText().trim().length() == 0 || tf[1].getText().trim().length() == 0) {
					showErr("빈칸이 있습니다.");
					return;
				}

				if(tf[0].getText().equals("admin") && tf[1].getText().equals("1234")) {
					메인.userNo = -255;
					changeFrame(new 메인());
					return;
				}

				var rs = resultSet("select * from 에더랜드.user where id = ? and pw = ?", tf[0].getText(), tf[1].getText());

				if(!rs.next()) {
					tf[0].setText("");
					tf[1].setText("");
					showErr("아이디 또는 비밀번호를 확인해주세요.");
					return;
				}

				메인.userNo = rs.getInt("UNO");
				메인.userID = rs.getString("id");
				changeFrame(new 메인());

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		changeWhite(main);

		lb[0].setBorder(null);
		lb[0].setFont(new Font("HY헤드라인M", 1, 30));
		lb[1].setBorder(null);
		btn[1].setBorder(null);
		btn[1].setBackground(Color.pink);
	}

	public static void main(String[] args) {
		new 로그인().setVisible(true);
	}
}
