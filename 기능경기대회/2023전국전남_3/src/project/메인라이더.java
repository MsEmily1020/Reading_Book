package project;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class 메인라이더 extends BaseFrame {
	public 메인라이더() {
		super("메인", 500, 600);
		
		main.add(setBounds(btn[0] = new JButton("콜받기"), 40, 500, 190, 35));
		main.add(setBounds(btn[1] = new JButton("일시정지"), 260, 500, 190, 35));

		main.add(setBounds(jp[0] = new JPanel(new GridLayout(0, 1)), 0, 0, 485, 485));

		main.setBackground(Color.black);
		
		btn[0].addActionListener(e -> {
			jp[0].removeAll();
			jp[0].revalidate();
			jp[0].repaint();
			
			btn[0].setBackground(Color.gray);
			btn[1].setBackground(Color.orange);
		});
		
		btn[1].addActionListener(e -> {
			jp[0].removeAll();
			jp[0].revalidate();
			jp[0].repaint();
			
			jp[0].add(setBounds(lb[0] = new JLabel("일시정지를 풀어주세요.", 0), 0, 0, 490, 500));
			lb[0].setForeground(Color.red);
			
			btn[0].setBackground(Color.orange);
			btn[1].setBackground(Color.gray);
		});

		jp[0].setBackground(Color.black);
		
		btn[0].setBackground(Color.gray);
		btn[1].setBackground(Color.orange);
		
		btn[0].setForeground(Color.white);
		btn[1].setForeground(Color.white);
	}
	
	public static void main(String[] args) {
		new 메인라이더().setVisible(true);
	}
}
