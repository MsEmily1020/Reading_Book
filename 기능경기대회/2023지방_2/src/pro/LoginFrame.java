package pro;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginFrame extends BaseFrame {
	int count = 0;
	
	public LoginFrame() {
		super("로그인", 350, 230);
		
		setLayout(null);
		
		var title = new JLabel("로그인", 0);
		title.setFont(new Font("맑은 고딕", 1, 24));
		add(setBounds(title, 0, 10, 340, 30));
		add(setBounds(new JLabel("아이디"), 40, 65, 40, 20));
		add(setBounds(new JLabel("비밀번호"), 40, 100, 60, 20));
		
		var tfId = new JTextField();
		var tfPw = new JTextField();
		
		add(setBounds(tfId, 100, 60, 220, 30));
		add(setBounds(tfPw, 100, 100, 220, 30));
		
		var bt = new JButton("로그인");
		add(setBounds(bt, 40, 140, 280, 30));
		
		bt.addActionListener(e -> {
			if(tfId.getText().length() == 0 || tfPw.getText().length() == 0) {
				showErr("빈칸이 있습니다.");
				doFail();
				return;
			}
			
			if(tfId.getText().equals("admin") && tfPw.getText().equals("1234")) {
				MainFrame.userId = -255;
				MainFrame.userName = "관리자";
				dispose();
				new MainFrame().setVisible(true);
				return;
			}
			
			var rs = getRs("SELECT * FROM user WHERE u_id = ? AND u_pw = ?", tfId.getText(), tfPw.getText());
			
			try {
				if(rs.next()) {
					MainFrame.userId = rs.getInt("u_no");
					MainFrame.userName = rs.getString("u_name");
					dispose();
					new MainFrame().setVisible(true);
					return;
				}
				
				else {
					showErr("아이디 또는 비밀번호를 확인하세요.");
					doFail();
					tfId.setText("");
					tfPw.setText("");
					tfId.grabFocus();
					return;
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
	}
	
	void doFail() {
		count++;
		
		if(count == 3) {
			showErr("3회 오류로 종료합니다.");
			dispose();
			new MainFrame().setVisible(true);
		}
	}
	public static void main(String[] args) {
		new LoginFrame().setVisible(true);
	}
}
