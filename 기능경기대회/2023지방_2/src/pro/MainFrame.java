package pro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MainFrame extends BaseFrame {
	public static int userId;
	public static String userName;
	
	public MainFrame() {
		super("메인", 800, 600);
		
		var north = new JPanel(new BorderLayout());
		String welcomeText = "로그인 후 이용해주세요.";
		if(userId > 0) {
			welcomeText = userName + "님 환영합니다.";
		}
		else if(userId == -255) {
			welcomeText = "관리자님 환영합니다.";
		}
		
		var lb = new JLabel(welcomeText, 0);
		lb.setFont(new Font("맑은 고딕", 1, 24));
		north.add(lb);
		north.setOpaque(true);
		
		north.setPreferredSize(new Dimension(0, 300));
		
		var center = new JPanel(null);
		center.setBorder(new TitledBorder(new LineBorder(Color.black),
				"인기 도서",
				0,
				0,
				new Font("맑은 고딕", 1, 16)));
		
		var centerList = new JPanel(new GridLayout(1, 5));
		
		var cb = new JComboBox<>();
		cb.addItem("전체");
		
		var rs = getRs("SELECT * FROM division");
		try {
			while(rs.next()) {
				cb.addItem(rs.getString("d_name"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		cb.addActionListener(e -> {
			String division = cb.getSelectedIndex() == 0 ? "" : cb.getSelectedItem().toString();
			var rs2 = getRs("SELECT *, (SELECT COUNT(1) FROM rental r WHERE r.b_no = b.b_no) rCnt\r\n"
					+ "FROM book b\r\n"
					+ "INNER JOIN division d ON b.d_no = d.d_no\r\n"
					+ "WHERE d_name LIKE ?\r\n"
					+ "ORDER BY rCnt DESC\r\n"
					+ "LIMIT 5", "%" + division + "%");
			
			try {
				while(rs2.next()) {
					for(int i = 1; i <= 100; i++) {
						if(rs2.getInt("b_no") == i) {
							var img = new ImageIcon("datafiles/book/" + i + ".jpg");
							var image = img.getImage();
							var changeImg = image.getScaledInstance(110, 120, Image.SCALE_SMOOTH);
							centerList.add(new JLabel(new ImageIcon(changeImg)));
						}
					}
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			centerList.revalidate();
			centerList.repaint();
		});
		
		cb.getActionListeners()[0].actionPerformed(null);
		
		
		center.add(setBounds(cb, 5, 25, 80, 24));
		center.add(setBounds(centerList, 5, 50, 770, 160));
		var south = new JPanel();
		
		String[] buttons = "로그인,회원가입,도서 목록,마이페이지,책 읽기,종료".split(",");
		
		if(userId > 0) buttons[0] = "로그아웃";
		else if(userId == -255) buttons = "로그아웃,도서관리,도서등록,대출통계,종료".split(",");
		
		for (int i = 0; i < buttons.length; i++) {
			var bt = new JButton(buttons[i]);
			if(userId <= 0 && i >= 2 && i <= 4) {
				bt.setEnabled(false);
			}
			south.add(bt);
			
			bt.addActionListener(e -> {
				if(bt.getText().equals("로그인") || bt.getText().equals("로그아웃")) {
					dispose();
					new LoginFrame().setVisible(true);
				}
				
				if(bt.getText().equals("회원가입")) {
					dispose();
					new SignUpFrame().setVisible(true);
				}
				
				if(bt.getText().equals("종료")) {
					dispose();
				}
			});
		}
		
		add(north, "North");
		add(center);
		add(south, "South");
	}
	
	public static void main(String[] args) {
		new MainFrame().setVisible(true);
	}
}
