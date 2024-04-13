package project;

import java.awt.Color;
import java.io.File;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class 메뉴 extends BaseFrame {
	ResultSet rs = null;
	int sum = 0;
	
	public 메뉴() {
		super("메뉴", 500, 600);

		try {
			rs = getResult("select * from menu where m_no = ?", selectMenu);
			if(rs.next()) {
				if(new File("datafiles/음식/" + rs.getString("m_menu") + ".png").exists())
					main.add(setBounds(lb[0] = new JLabel(getIcon("datafiles/음식/" + rs.getString("m_menu") + ".png", 500, 250)), 0, 0, 500, 250));
				else
					main.add(setBounds(lb[0] = new JLabel(getIcon("datafiles/음식/" + rs.getString("m_menu") + ".jpg", 500, 250)), 0, 0, 500, 250));

				main.add(setBounds(lb[1] = new JLabel(String.format("%,2d", rs.getInt("m_price")) + "원"), 25, 265, 80, 15));
				sum += rs.getInt("m_price");
			}

			JScrollPane scroll = new JScrollPane(jp[0]);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
			main.add(setBounds(scroll, 0, 290, 485, 190));
			
			main.add(setBounds(lb[2] = new JLabel("총 가격 : " +  String.format("%,2d", sum) + "원"), 15, 490, 100, 20));
			main.add(setBounds(btn[0] = new JButton("담기"), 10, 520, 460, 30));

			setComponent(main);
			
			btn[0].setBackground(Color.orange);
			btn[0].setForeground(Color.white);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new 메뉴().setVisible(true);
	}
}
