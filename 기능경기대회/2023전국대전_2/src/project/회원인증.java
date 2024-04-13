package project;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class 회원인증 extends BaseFrame {
	public 회원인증() {
		super("회원인증", 500, 350);
		
		main.add(setBounds(lb[0] = new JLabel("회원인증", 0), 168, 17, 164, 40));
		
		main.add(setBounds(lb[1] = new JLabel("이메일", 0), 20, 69, 74, 16));
		main.add(setBounds(tf[0] = new JTextField(), 34, 102, 338, 24));
		main.add(setBounds(btn[0] = new JButton("인증하기"), 383, 102, 84, 24));
		
		main.add(setBounds(lb[2] = new JLabel("전화번호", 0), 25, 139, 74, 16));
		main.add(setBounds(tf[1] = new JTextField(), 34, 167, 90, 24));
		main.add(setBounds(lb[3] = new JLabel("-"), 134, 167, 30, 18));
		main.add(setBounds(tf[2] = new JTextField(), 148, 167, 100, 24));
		main.add(setBounds(lb[4] = new JLabel("-"), 260, 167, 30, 18));
		main.add(setBounds(tf[3] = new JTextField(), 278, 167, 100, 24));
		main.add(setBounds(btn[1] = new JButton("인증하기"), 383, 167, 84, 24));
		
		main.add(setBounds(lb[5] = new JLabel("이메일/전화번호 인증번호"), 32, 207, 190, 16));
		main.add(setBounds(tf[4] = new JTextField(), 34, 233, 338, 24));
		main.add(setBounds(btn[2] = new JButton("인증확인"), 383, 233, 84, 24));
		
		main.add(setBounds(btn[3] = new JButton("정보수정"), 34, 277, 434, 24));

		changeWhite(main);
		
		lb[0].setFont(new Font("HY헤드라인M", 1, 30));
		
		for(int i = 0; i < 4; i++) {
			btn[i].setForeground(Color.white);
			btn[i].setBackground(Color.pink);
		}
	}

	public static void main(String[] args) {
		new 회원인증().setVisible(true);
	}
}
