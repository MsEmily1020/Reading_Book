package pro;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SignUpFrame extends BaseFrame {
	public SignUpFrame() {
		super("회원가입", 400, 300);

		setLayout(null);
		var title = new JLabel("회원가입", 0);
		title.setFont(new Font("맑은 고딕", 1, 24));
		add(setBounds(title, 0, 10, 390, 30));

		add(setBounds(new JLabel("이름"), 40, 70, 50, 30));
		add(setBounds(new JLabel("아이디"), 40, 110, 50, 30));
		add(setBounds(new JLabel("비밀번호"), 40, 150, 50, 30));

		var tfName = new JTextField();
		var tfId = new JTextField();
		var tfPw = new JTextField();

		add(setBounds(tfName, 120, 70, 220, 30));
		add(setBounds(tfId, 120, 110, 220, 30));
		add(setBounds(tfPw, 120, 150, 220, 30));

		var bt = new JButton("회원가입");
		add(setBounds(bt, 40, 200, 300, 30));

		bt.addActionListener(e -> {
			if (tfName.getText().length() == 0 || tfId.getText().length() == 0 || tfPw.getText().length() == 0) {
				showErr("빈칸이 있습니다.");
				return;
			}

			if (tfName.getText().length() < 2 || !tfName.getText().matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣].*")) {
				showErr("이름은 한글로 2글자 이상만 가능합니다.");
				tfName.setText("");
				tfName.grabFocus();
				return;
			}

			var rs = getRs("SELECT * FROM user WHERE u_id = ?", tfId.getText());

			try {
				if (rs.next() || tfId.getText().equals("admin")) {
					showErr("이미 있는 아이디 입니다.");
					tfId.setText("");
					tfId.grabFocus();
					return;
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			if (tfId.getText().matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣].*")) {
				showErr("아이디에 한글은 사용이 불가능합니다.");
				tfId.setText("");
				tfId.grabFocus();
				return;
			}

			if (!tfPw.getText().matches(".*[a-zA-Z0-9!@#$].*") || tfPw.getText().length() < 6) {
				showErr("비밀번호 형식이 일치하지 않습니다.");
				tfPw.setText("");
				tfPw.grabFocus();
				return;
			}

			showInfo(tfName.getText() + "님 회원가입이 완료되었습니다.");

			update("INSERT INTO user (u_name, u_id, u_pw) " + "VALUES (?, ?, ?)", tfName.getText(), tfId.getText(),
					tfPw.getText());

			dispose();
			new MainFrame().setVisible(true);
		});
	}

	public static void main(String[] args) {
		new SignUpFrame().setVisible(true);
	}
}
