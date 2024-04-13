package project;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class 어트랙션검색 extends BaseFrame {
	public 어트랙션검색() {
		super("어트랙션 검색", 650, 700);
		
		main.add(setBounds(lb[0] = new JLabel("키", 0), 16, 33, 83, 32));
		main.add(setBounds(lb[1] = new JLabel("몸무게", 0), 24, 86, 78, 23));
		main.add(setBounds(lb[2] = new JLabel("어트랙션", 0), 28, 133, 81, 18));
		
		main.add(setBounds(tf[0] = new JTextField(), 146, 126, 340, 27));
	
		main.add(setBounds(lb[3] = new JLabel("100125150175200"), 146, 20, 340, 17));
		main.add(setBounds(lb[4] = new JLabel(), 146, 45, 340, 17));
		main.add(setBounds(lb[5] = new JLabel(), 146, 71, 340, 16));
		main.add(setBounds(lb[6] = new JLabel(), 146, 95, 340, 16));
		
		main.add(setBounds(lb[7] = new JLabel(), 506, 21, 110, 31));
		main.add(setBounds(lb[8] = new JLabel(), 506, 77, 110, 31));
		
		main.add(setBounds(btn[0] = new JButton("검색"), 506, 127, 110, 25));
	
		changeWhite(main);
		
		lb[3].setBorder(new LineBorder(Color.black));
		lb[4].setBorder(new LineBorder(Color.black));
		lb[5].setBorder(new LineBorder(Color.black));
		lb[6].setBorder(new LineBorder(Color.black));
		lb[7].setBorder(new LineBorder(Color.LIGHT_GRAY));
		lb[8].setBorder(new LineBorder(Color.LIGHT_GRAY));
		btn[0].setBackground(Color.pink);
	}
	
	public static void main(String[] args) {
		new 어트랙션검색().setVisible(true);
	}
}
