package project;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class 가게 extends BaseFrame {
	ResultSet rs;
	public 가게() {
		super("가게", 600, 500);
		
		try {
			rs = getResult("select * from restaurant where r_no = ?", selectStore);
			if(rs.next()) {	
				main.add(setBounds(lb[1] = new JLabel(rs.getString("r_name")), 175, 50, 60, 15));
				main.add(setBounds(lb[2] = new JLabel("<html><p>최소 주문 금액, " + String.format("%,2d", rs.getInt("r_mini")) + "<br>배달시간, " + rs.getString("r_take") + ""), 175, 100, 175, 35));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		main.add(setBounds(btn[0] = new JButton(getIcon("datafiles/아이콘/홈.png", 35, 35)), 485, 15, 40, 40));
		main.add(setBounds(btn[1] = new JButton(getIcon("datafiles/아이콘/장바구니.png", 35, 35)), 535, 15, 40, 40));
		
		main.add(setBounds(btn[3] = new JButton("←"), 10, 15, 20, 20));
		main.add(setBounds(lb[0] = new JLabel(getIcon("datafiles/가게/" + selectStore + ".PNG", 70, 70)), 50, 55, 70, 70));

		main.add(setBounds(btn[4] = new JButton("메뉴명"), 0, 140, 200, 35));
		main.add(setBounds(btn[5] = new JButton("정보"), 200, 140, 200, 35));
		main.add(setBounds(btn[6] = new JButton("리뷰"), 400, 140, 200, 35));

		btn[0].addActionListener(e -> {
			changeFrame(new 메인());
		});
		
		btn[1].addActionListener(e -> {
			try {
				var rs = getResult("select * from cart where c_no = ?", userNo);
				if(rs.next()) changeFrame(new 장바구니());
				else showErr("장바구니가 비었습니다.");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		btn[3].addActionListener(e -> {
			changeFrame(new 배달());
		});
		
		main.add(setBounds(jp[0] = new JPanel(null), 0, 175, 600, 300));
		setComponent(main);
		setComponent(jp[0]);
		
		for(int i = 4; i <= 6; i++) {
			btn[i].addActionListener(e -> {
				for(int j = 4; j <= 6; j++) {
					if(e.getSource() == btn[j]) {
						btn[j].setBorder(new MatteBorder(0, 0, 2, 0, Color.orange));
					}
					
					else {
						btn[j].setBorder(new MatteBorder(0, 0, 2, 0, Color.gray));
					}
				}
				
				// 메뉴명
				if(e.getSource() == btn[4]) {
					jp[0].removeAll();
				}
				
				// 정보
				else if(e.getSource() == btn[5]) {
					jp[0].removeAll();
					
					jp[0].add(setBounds(lb[2] = new JLabel("상호명"), 55, 50, 60, 15));
					jp[0].add(setBounds(lb[3] = new JLabel("운영시간"), 55, 100, 60, 15));
					jp[0].add(setBounds(lb[4] = new JLabel("휴무일"), 55, 150, 60, 15));
					jp[0].add(setBounds(lb[5] = new JLabel("전화번호"), 55, 200, 60, 15));

					try {
						jp[0].add(setBounds(lb[6] = new JLabel(rs.getString("r_name")), 175, 50, 100, 15));
						jp[0].add(setBounds(lb[7] = new JLabel(rs.getString("r_info").split(",")[0]), 175, 100, 100, 15));
						jp[0].add(setBounds(lb[8] = new JLabel(rs.getString("r_info").split(",")[1]), 175, 150, 100, 15));
						jp[0].add(setBounds(lb[9] = new JLabel(rs.getString("r_info").split(",")[2]), 175, 200, 100, 15));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				// 리뷰
				else if(e.getSource() == btn[6]) {
					jp[0].removeAll();
				}

				jp[0].revalidate();
				jp[0].repaint();
			});
		}
		btn[4].setBorder(new MatteBorder(0, 0, 2, 0, Color.orange));
		btn[5].setBorder(new MatteBorder(0, 0, 2, 0, Color.gray));
		btn[6].setBorder(new MatteBorder(0, 0, 2, 0, Color.gray));
	}
	
	public static void main(String[] args) {
		new 가게().setVisible(true);
	}
}
