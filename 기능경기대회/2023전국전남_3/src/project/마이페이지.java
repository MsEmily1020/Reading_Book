package project;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class 마이페이지 extends BaseFrame {
	
	int num = 0;
	
	public 마이페이지() {
		super("마이페이지", 700, 700);

		main.add(setBounds(lb[0] = new JLabel(userName + " 고객님", 0), 255, 10, 195, 30));
		main.add(setBounds(lb[1] = new JLabel(), 0, 55, 685, 2));
		main.add(setBounds(btn[0] = new JButton("찜"), 70, 75, 125, 50));
		main.add(setBounds(btn[1] = new JButton("쿠폰"), 210, 75, 125, 50));
		main.add(setBounds(btn[2] = new JButton("주문내역"), 350, 75, 125, 50));
		main.add(setBounds(btn[3] = new JButton("리뷰관리"), 485, 75, 125, 50));
		main.add(setBounds(lb[2] = new JLabel(num + "개"), 70, 170, 60, 20));

		main.add(setBounds(jp[0] = new JPanel(null), 65, 210, 570, 405));

		setComponent(main);
		
		lb[1].setBorder(new LineBorder(Color.black));
		lb[1].setBackground(Color.black);
		lb[1].setOpaque(true);
		
		for(int i = 0; i < 4; i++) {
			btn[i].addActionListener(e -> {
				for(int j = 0; j < 4; j++) {
					if(e.getSource() == btn[j]) {
						btn[j].setBackground(Color.orange);
					}
					
					else btn[j].setBackground(Color.gray);
				}
			});
			
			if(i == 0) btn[i].setBackground(Color.orange);
			else btn[i].setBackground(Color.gray);
		}
	}
	
	public static void main(String[] args) {
		new 마이페이지().setVisible(true);
	}
}
