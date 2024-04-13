package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class C관심 extends BaseFrame {
	
	
	public C관심() {
		super("관심 카테고리", 400, 400);
		main.add(setBounds(lb[0] = new JLabel(" 관심 카테고리"), 0, 0, 400, 35));
		main.add(setBounds(lb[1] = new JLabel("관심 카테고리 설정", 0), 0, 55, 385, 45));
		main.add(setBounds(pn[0] = new JPanel(new GridLayout(2, 3)), 60, 130, 300, 150));
		main.add(setBounds(btn[1] = actionbtn("선택", e -> dispose()), 105, 300, 180, 40));
		
		pn[0].add(ch[0] = new JCheckBox("상의"));
		pn[0].add(ch[1] = new JCheckBox("하의"));
		pn[0].add(ch[2] = new JCheckBox("아우터"));
		pn[0].add(ch[3] = new JCheckBox("속옷"));
		pn[0].add(ch[4] = new JCheckBox("신발"));
		pn[0].add(ch[5] = new JCheckBox("유아"));
		
		setComponent(main);
		setComponent(pn[0]);
		
		lb[0].setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
		lb[1].setFont(new Font("맑은 고딕", 1, 20));
	}
	
	public static void main(String[] args) {
		new C관심().setVisible(true);
	}
}
