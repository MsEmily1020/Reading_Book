package project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class I배송조회 extends BaseFrame {
	
	public I배송조회() {
		super("배송조회", 500, 560);
		main.add(setBounds(lb[0] = new JLabel(" 배송조회"), 0, 0, 500, 35));
		main.add(setBounds(lb[1] = new JLabel("결제 완료", 4), 25, 55, 75, 20));
		main.add(setBounds(lb[2] = new JLabel("배송 중", 4), 190, 55, 55, 20));
		main.add(setBounds(lb[3] = new JLabel("배송 완료", 4), 340, 55, 75, 20));
		main.add(setBounds(tf[0] = new JTextField(), 105, 50, 40, 30));
		main.add(setBounds(tf[1] = new JTextField(), 250, 50, 40, 30));
		main.add(setBounds(tf[2] = new JTextField(), 420, 50, 40, 30));
		
		main.add(setBounds(pn[0] = new JPanel(new FlowLayout(0, 0, 10)), 10, 100, 440, 330));
		main.add(setBounds(jsb = new JScrollBar(), 450, 110, 20, 320));
		main.add(setBounds(btn[0] = actionbtn("구매취소", e -> dispose()), 180, 450, 130, 35));
		
		for (int i = 0; i < 10; i++) {
			pn[0].add(setBounds(btn[10] = actionbtn("", e -> ((JButton) e.getSource()).setBorder(new LineBorder(Color.RED))), 440, 100));
			btn[10].add(setBounds(lb[0] = new JLabel(getIcon("./datafiles/goods/1.jpg", 100, 85)), 10, 8, 100, 85));
			btn[10].add(setBounds(lb[1] = new JLabel("배송 완료"), 115, 5, 75, 20));
			btn[10].add(setBounds(lb[2] = new JLabel("공용 프리사이즈 팬츠"), 195, 5, 175, 20));
			btn[10].add(setBounds(lb[3] = new JLabel("수량 : 2개"), 195, 35, 175, 20));
			btn[10].add(setBounds(lb[4] = new JLabel("총 금액 : 70,020원"), 195, 65, 175, 20));
			btn[10].setBorder(new LineBorder(Color.BLACK));
			btn[10].setBackground(Color.WHITE);
			btn[10].setLayout(null);
			setComponent(btn[10]);
			lb[0].setBorder(new LineBorder(Color.BLACK));
			lb[1].setForeground(Color.LIGHT_GRAY);
		}
		
		setComponent(main);
		
		lb[0].setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		
		tf[0].setEnabled(false);
		tf[1].setEnabled(false);
		tf[2].setEnabled(false);
		
		tf[0].setHorizontalAlignment(0);
		tf[1].setHorizontalAlignment(0);
		tf[2].setHorizontalAlignment(0);
		
		pn[0].setBackground(Color.WHITE);
	}

	public static void main(String[] args) {
		new I배송조회().setVisible(true);
	}
}
