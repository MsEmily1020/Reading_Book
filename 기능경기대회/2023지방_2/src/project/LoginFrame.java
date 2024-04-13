package project;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginFrame extends CommonFrame {
	
	static int cnt = 0;
	
	public LoginFrame() {
		super("로그인", 540, 300);
		
		setLayout(null);
		
		var lb = new JLabel("로그인", 0);
		lb.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		add(setBounds(lb, 210, 0, 100, 100));
		
		add(setBounds(new JLabel("아이디"), 50, 80, 50, 50));
		add(setBounds(new JLabel("비밀번호"), 50, 130, 50, 50));
		
		var tfId = new JTextField();
		var tfPw = new JTextField();
		
		add(setBounds(tfId, 130, 90, 330, 40));
		add(setBounds(tfPw, 130, 140, 330, 40));
		
		var bt = new JButton("로그인");
		add(setBounds(bt, 30, 200, 460, 50));
		bt.addActionListener(e -> {
			if(tfId.getText().length() == 0 || tfPw.getText().length() == 0) {
				showErr("빈칸이 있습니다.");
				doFail();
				return;
			}
			
			if(tfId.getText().equals("admin") && tfPw.getText().equals("1234")) {
				dispose();
				new Main().setVisible(true);
			}
			
			var rs = getRs("SELECT * FROM user WHERE u_id = ? AND u_pw = ?", tfId.getText(), tfPw.getText());
			try {
				if(rs.next()) {
					Main.userId = rs.getInt("u_no");
					Main.userName = rs.getString("u_name");
					dispose();
					new Main().setVisible(true);
				}
				else {
					showErr("아이디 또는 비밀번호를 확인하세요.");
					tfId.setText("");
					tfPw.setText("");
					tfId.grabFocus();
					doFail();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
	}
	
	void doFail() {
		cnt++;
		
		if(cnt == 3) {
			showErr("3회 오류로 종료합니다.");
			dispose();
		}
	}
	public static void main(String[] args) {
		new LoginFrame().setVisible(true);
	}
}
