package project;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class 장바구니 extends BaseFrame {
	int sum = 0;
	
	public 장바구니() {
		super("장바구니", 500, 700);
		
		main.add(setBounds(lb[0] = new JLabel(), 215, 25, 75, 30));
		main.add(setBounds(btn[0] = new JButton("←"), 10, 10, 20, 25));
		main.add(setBounds(lb[1] = new JLabel("총 가격 : " + String.format("%,2d", sum) + "원"), 15, 570, 155, 25));
		main.add(setBounds(btn[1] = new JButton("주문하기"), 15, 600, 455, 50));
		main.add(setBounds(btn[2] = new JButton("+더 담으로 가기"), 175, 520, 145, 35));

		
		main.add(setBounds(jp[0] = new JPanel(), 0, 65, 485, 435));

		setComponent(main);
		
		btn[1].setForeground(Color.white);
		btn[1].setBackground(Color.orange);
	}
	
	public static void main(String[] args) {
		new 장바구니().setVisible(true);
	}
}
