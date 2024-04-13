package project;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Review extends BaseFrame {

	public static int p_no = 1;
	public static String p_name;
	JTextArea area = new JTextArea();

	public Review() {
		super("review", 600, 550);

		try {
			var rs = getResult("select * from product where p_no = ?", p_no);
			if (rs.next()) {
				p_name = rs.getString("p_name");
				main.add(setBounds(lb[0] = new JLabel(getIcon("datafiles/제품/" + p_no + ".PNG", 190, 260)), 15, 15, 190,
						260));
				main.add(setBounds(lb[1] = new JLabel(p_name), 220, 15, 355, 25));
			}

			main.add(setBounds(lb[2] = new JLabel("이름: " + userName + ", 성별: " + userGender + ", 나이: " + userAge), 220,
					80, 255, 20));

			main.add(setBounds(lb[3] = new JLabel("만족도"), 220, 130, 55, 15));

			main.add(setBounds(area, 15, 290, 550, 180));

			main.add(setBounds(btn[0] = new JButton("등록"), 450, 480, 110, 25));

			main.add(setBounds(lb[4] = new JLabel("향", JLabel.RIGHT), 220, 150, 40, 25));
			main.add(setBounds(lb[5] = new JLabel("맛", JLabel.RIGHT), 220, 175, 40, 25));
			main.add(setBounds(lb[6] = new JLabel("효과", JLabel.RIGHT), 220, 200, 40, 25));
			main.add(setBounds(lb[7] = new JLabel("가성비", JLabel.RIGHT), 220, 225, 40, 25));
			main.add(setBounds(lb[8] = new JLabel("목넘김", JLabel.RIGHT), 220, 250, 40, 25));

		} catch (Exception e) {
			e.printStackTrace();
		}

		btn[0].addActionListener(e -> {
			int yes = JOptionPane.showConfirmDialog(null, p_name + " 제품을 추천하시겠습니까?(yes/no)", "질문",
					JOptionPane.YES_NO_OPTION);
			if (yes == JOptionPane.YES_OPTION)
				changeFrame(new Mypage());
			else
				changeFrame(new Mypage());
		});

		setComponent(main);

		btn[0].setBackground(Color.green);
		area.setBorder(new LineBorder(Color.black));
		lb[1].setFont(new Font("맑은 고딕", 1, 15));
	}

	public static void main(String[] args) {
		new Review().setVisible(true);
	}
}
