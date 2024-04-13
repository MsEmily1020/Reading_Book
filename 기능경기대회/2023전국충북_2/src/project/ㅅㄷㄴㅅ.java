package project;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ㅅㄷㄴㅅ extends BaseFrame {
	public ㅅㄷㄴㅅ() {
		super("메인", 500, 500);
		
		main.add(setBounds(lb[0] = new JLabel(), 55, 55, 150, 120));
		main.add(setBounds(btn[0] = new JButton(), 230, 120, 130, 115));

	}
	
	public static void main(String[] args) {
		new ㅅㄷㄴㅅ().setVisible(true);
	}
}
