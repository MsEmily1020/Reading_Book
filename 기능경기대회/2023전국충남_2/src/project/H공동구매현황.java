package project;

import java.awt.Color;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class H공동구매현황 extends BaseFrame {
	
	
	public H공동구매현황() {
		super("마이페이지", 500, 600);
		main.add(setBounds(lb[0] = new JLabel("공동구매현황"), 0, 0, 600, 35));
		
		main.add(setBounds(pn[0] = new JPanel(), 5, 40, 475, 580));
		
		for (int i = 0; i < 3; i++) {
			pn[0].add(setBounds(pn[1] = new JPanel(null), 475, 160));
			pn[1].add(setBounds(lb[1] = new JLabel(), 5, 5, 130, 150));
			pn[1].add(setBounds(lb[2] = new JLabel("남성 초록 등산용 바람막이"), 150, 10, 205, 25));
			pn[1].add(setBounds(lb[3] = new JLabel("금액 : 34,700원"), 150, 45, 235, 30));
			pn[1].add(setBounds(lb[3] = new JLabel("금액 : 34,700원"), 150, 80, 235, 30));
			pn[1].add(setBounds(lb[3] = new JLabel("금액 : 34,700원"), 150, 115, 235, 30));
			pn[1].add(setBounds(btn[0] = actionbtn("취소하기", e -> dispose()), 355, 10, 110, 30));
			lb[1].setBorder(new LineBorder(Color.BLACK));
			pn[1].setBorder(new LineBorder(Color.BLACK));
		}
		
		setComponent(main);
		setComponent(pn[0]);
		
		lb[0].setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		
//		pn[0].setVisible(false);
	}

	public static void main(String[] args) {
		new H공동구매현황().setVisible(true);
	}
}
