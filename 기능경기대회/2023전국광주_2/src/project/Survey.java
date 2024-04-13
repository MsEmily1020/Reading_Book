package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Survey extends BaseFrame {
	ArrayList<String> qlist = new ArrayList<>();
	int problem = 0;
	
	public Survey() {
		super("survey", 540, 520);
		
		try {
			main.add(setBounds(pn[0] = new JPanel(), 10, 10, 505, 415));
			
			main.add(setBounds(btn[0] = actionbtn("이전", e -> 문제(-1)), 10, 430, 90, 30));
			main.add(setBounds(btn[1] = actionbtn("다음", e -> 문제(1)), 425, 430, 90, 30));
			main.add(setBounds(lb[0] = new JLabel("1", 0), 125, 430, 295, 30));
			
			rs = getResult("select * from question");
			for (int i = 0; rs.next(); i++) {
				pn[1] = setBounds(new JPanel(new BorderLayout()), 505, 120);
				pn[2] = new JPanel((i == 0 || i > 2 ? new GridLayout(3, 2) : new FlowLayout(FlowLayout.LEFT)));
				if (i == 1 || i == 2) {
					pn[2].add(setBounds(new JTextField(i == 1? "cm" : "kg"), 140, 25));
				}
				for (Object item : qList.get(rs.getInt("q_no"))) {
					pn[2].add(ch[0] = new JCheckBox(item + ""));
					ch[0].setFont(new Font("맑은 고딕", 0, 11));
					ch[0].setBackground(Color.WHITE);
				}
				pn[1].add(lb[30] = new JLabel("문제 " + rs.getString("q_no") + ") " + rs.getString("q_detail"), 2), BorderLayout.NORTH);
				pn[1].add(pn[2], BorderLayout.CENTER);
				pn[0].add(pn[1]);
				pn[1].setVisible(i < 3);
				setComponent(pn[1]);
			}
			
			setComponent(main);
			setComponent(pn[0]);
			
			btn[0].setBackground(Color.green);
			btn[1].setBackground(Color.green);
			
			btn[0].setVisible(!lb[0].getText().equals("1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void 문제(int a) {
		lb[0].setText((Integer.parseInt(lb[0].getText()) + a) + "");
		btn[0].setVisible(!lb[0].getText().equals("1")); // 0일때는 이전버튼 안보이게
		btn[1].setVisible(!lb[0].getText().equals("8")); 
		for (Component comp : pn[0].getComponents()) {
			comp.setVisible(false);
		}
		pn[0].getComponent((Integer.parseInt(lb[0].getText()) - 1)  * 3).setVisible(true);
		pn[0].getComponent((Integer.parseInt(lb[0].getText()) - 1) * 3 + 1).setVisible(true);
		pn[0].getComponent((Integer.parseInt(lb[0].getText()) - 1) * 3 + 2).setVisible(true);
	}
	
	public static void main(String[] args) {
		new Survey().setVisible(true);
	}
}
