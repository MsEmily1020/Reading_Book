package project;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Store extends BaseFrame {
	ArrayList<String> category = new ArrayList<>();
	
	public Store() {
		super("store", 800, 450);

		main.add(setBounds(pn[0] = new JPanel(), 0, 0, 800, 75));
		main.add(setBounds(pn[1] = new JPanel(null), 0, 75, 800, 375));

		category.add("전체");
		try {
			var rs = getResult("select * from category");
			while(rs.next()) {
				category.add(rs.getString("c_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < category.size(); i++) {
			pn[0].add(lb[i] = new JLabel(category.get(i), 0));
			if(i == 8) pn[0].add(btn[0] = new JButton("더보기"));
			lb[i].setPreferredSize(new Dimension(70, 30));
			if(i == 16) lb[i].setPreferredSize(new Dimension(100, 30));
		}
		
		setComponent(main);

		btn[0].setBackground(Color.green);
		pn[1].setBorder(new LineBorder(Color.black));
	}
	
	public static void main(String[] args) {
		new Store().setVisible(true);
	}
}