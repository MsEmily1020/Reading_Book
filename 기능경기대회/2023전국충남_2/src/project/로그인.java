package project;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class 로그인 extends BaseFrame {
	public 로그인() {
		super("로그인", 350, 300);
		
		main.add(setBounds(lb[0] = new JLabel("로그인"), 15, 10, 55, 20));
		main.add(setBounds(lb[1] = new JLabel(), 0, 40, 385, 3));
		main.add(setBounds(lb[2] = new JLabel("아이디: "), 30, 70, 70, 25));
		main.add(setBounds(lb[3] = new JLabel("비밀번호 :"), 30, 105, 70, 25));
		main.add(setBounds(tf[0] = new JTextField(), 100, 65, 210, 30));
		main.add(setBounds(tf[1] = new JTextField(), 100, 110, 210, 30));
		main.add(setBounds(btn[0] = new JButton("로그인"), 100, 155, 210, 40));
		main.add(setBounds(btn[1] = new JButton("회원이 아니신가요?"), 70, 220, 180, 25));

		btn[0].addActionListener(e -> {
			
		});
		
		btn[1].addActionListener(e -> {
			changeFrame(new 회원가입());
		});
		
		setComponent(main);
		
		tf[0].setBorder(new LineBorder(Color.black));
		tf[1].setBorder(new LineBorder(Color.black));
		
		btn[1].setBackground(Color.white);
		btn[1].setBorder(null);
		btn[1].setForeground(Color.blue);
		lb[1].setBorder(new LineBorder(Color.black, 3));
		
	}
	
	public static void main(String[] args) {
		new 로그인().setVisible(true);
	}
}
