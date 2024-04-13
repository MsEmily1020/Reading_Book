package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class E결제 extends BaseFrame {
	
	public E결제(ArrayList<String> arr) {
		super("결제", 300, 500);
		try {
			main.add(setBounds(lb[0] = new JLabel(" 결제"), 0, 0, 300, 40));
			
			main.add(setBounds(jsp = new JScrollPane(setBounds(pn[0] = new JPanel(new FlowLayout(0, 0, 0)), 240, 2400)), 10, 50, 265, 120));
			
			main.add(setBounds(lb[4] = new JLabel("58,800원", 0), 150, 180, 90, 30));
			main.add(setBounds(lb[5] = new JLabel("2,392 P", 0), 150, 225, 90, 30));
			main.add(setBounds(tf[1] = new JTextField(), 150, 270, 90, 30));
			main.add(setBounds(lb[6] = new JLabel("1,392 P", 0), 150, 315, 90, 30));
			main.add(setBounds(lb[7] = new JLabel("5,880 P", 0), 150, 360, 90, 30));
			
			main.add(setBounds(new JLabel("결제 금액"), 15, 180, 90, 30));
			main.add(setBounds(new JLabel("보유 포인트"), 15, 225, 90, 30));
			main.add(setBounds(new JLabel("사용 포인트"), 15, 270, 90, 30));
			main.add(setBounds(new JLabel("잔여 포인트"), 15, 315, 90, 30));
			main.add(setBounds(new JLabel("적립 포인트"), 15, 360, 90, 30));
			
			main.add(setBounds(actionbtn("결제완료", e -> dispose()), 35, 405, 95, 30));
			main.add(setBounds(actionbtn("결제취소", e -> dispose()), 140, 405, 95, 30));
			
			setComponent(main);
			
			for (int i = 0; i < arr.size(); i++) {
				var rs = getResult("select * from goods where g_no = ?", arr.get(i));
				rs.next();
				pn[0].add(setBounds(pn[1] = new JPanel(null), 260, 120));
				pn[1].add(setBounds(lb[1] = new JLabel(getIcon("datafiles/goods/1.jpg", 80, 100)), 5, 5, 80, 100));
				pn[1].add(setBounds(lb[2] = new JLabel(rs.getString("g_name")), 95, 5, 140, 30));
				pn[1].add(setBounds(lb[3] = new JLabel("29,400원"), 95, 40, 140, 30));
				pn[1].add(setBounds(tf[0] = new JTextField("1", JLabel.RIGHT), 95, 80, 75, 25));
				pn[1].add(setBounds(jspin = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1)), 170, 80, 15, 25));
				jspin.addChangeListener(e -> tf[0].setText(jspin.getValue() + ""));
				lb[1].setBorder(new LineBorder(Color.BLACK));
				pn[1].setBorder(new LineBorder(Color.BLACK));
			}
			
			lb[0].setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
			lb[0].setFont(new Font("맑은 고딕", 1, 18));
			
			tf[0].setFont(null);
			tf[1].setFont(null);
			tf[0].setHorizontalAlignment(4);
			tf[1].setHorizontalAlignment(0);
			tf[1].setForeground(Color.GRAY);
			
			jsp.setBorder(null);
			jsp.setVerticalScrollBarPolicy(pn[0].getComponentCount() > 1 ? 20 : 21);
			
			pn[0].setPreferredSize(new Dimension(0, pn[0].getComponentCount() * 120));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new F마이페이지().setVisible(true);
	}
}
