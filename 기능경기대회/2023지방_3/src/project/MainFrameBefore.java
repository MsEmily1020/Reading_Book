package project;

import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrameBefore extends BaseFrame {
	public static int userId;
	public static String userName;

	public MainFrameBefore() {
		super("메인", 700, 600);

		setLayout(null);

		var img = new ImageIcon("datafiles/구름.jpg");
		var image = img.getImage();
		var changeImg = image.getScaledInstance(700, 150, Image.SCALE_SMOOTH);
		add(setBounds(new JLabel(new ImageIcon(changeImg)), 0, 0, 700, 200));

		var title = new JLabel("SKY AIRLINE", 0);
		title.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		add(setBounds(title, 0, 100, 690, 200));

		var tfId = new JTextField();
		var tfPw = new JTextField();

		add(setBounds(tfId, 270, 380, 170, 20));
		add(setBounds(tfPw, 270, 430, 170, 20));

		add(setBounds(new JLabel("ID:"), 200, 380, 20, 10));
		add(setBounds(new JLabel("PW:"), 200, 430, 40, 10));

		String[] buttons = "로그인,회원가입,대륙별분석".split(",");
		
		for (int i = 0; i < buttons.length; i++) {
			var bt = new JButton(buttons[i]);
			
			bt.addActionListener(e -> {
				if(bt.getText().equals("로그인")) {
					if(tfId.getText().length() == 0 || tfPw.getText().length() == 0) {
						showErr("공백이 있습니다.");
						return;
					}
					
					var rs = getRs("SELECT * FROM user WHERE id = ? AND pw = ?", tfId.getText(), tfPw.getText());

					try {
						if(rs.next()) {
							showInfo(rs.getString("name1") + "님 환영합니다.");
							MainFrameAfter.userNo = rs.getInt("u_no");
							MainFrameAfter.userId = rs.getString("id");
							MainFrameAfter.userPw = rs.getString("pw");
							MainFrameAfter.userName1 = rs.getString("name1");
							MainFrameAfter.userName2 = rs.getString("name2");
							MainFrameAfter.birth = rs.getString("birth");
							
							dispose();
							new MainFrameAfter().setVisible(true);
						}
						
						else {
							showErr("ID 또는 PW를 확인하세요.");
							tfId.setText("");
							tfPw.setText("");
							tfId.grabFocus();
							return;
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				if(bt.getText().equals("회원가입")) {
					dispose();
					new SignUpFrame().setVisible(true);
				}
				
			});
			
			add(setBounds(bt, 150 + i * 130, 500, 120, 30));
		}
		
	}

	public static void main(String[] args) {
		new MainFrameBefore().setVisible(true);
	}
}
