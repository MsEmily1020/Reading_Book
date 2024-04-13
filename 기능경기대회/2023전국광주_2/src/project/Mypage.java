package project;

import javax.swing.JLabel;

public class Mypage extends BaseFrame {
	public Mypage() {
		super("mypage", 600, 550);
		
		main.add(setBounds(lb[0] = new JLabel(getIcon("datafiles/아이콘/마이페이지.PNG", 70, 70)), 20, 15, 85, 70));
		main.add(setBounds(lb[1] = new JLabel(userName), 110, 15, 60, 25));
		main.add(setBounds(lb[2] = new JLabel("나이: " + userAge), 180, 15, 70, 20));
		main.add(setBounds(lb[3] = new JLabel("성별: " + userGender), 175, 45, 80, 20));

	}
	
	public static void main(String[] args) {
		new Mypage().setVisible(true);
	}
}
