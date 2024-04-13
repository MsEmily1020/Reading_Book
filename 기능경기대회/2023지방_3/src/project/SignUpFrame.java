package project;

import java.awt.Font;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SignUpFrame extends BaseFrame {
	int count = 0;
	public SignUpFrame() {
		super("회원가입", 420, 400);
		
		setLayout(null);
		var title = new JLabel("회원가입", 0);
		title.setFont(new Font("맑은 고딕", 1, 24));
		add(setBounds(title, 0, 20, 390, 30));
		
		add(setBounds(new JLabel("아이디"), 30, 70, 60, 30));
		add(setBounds(new JLabel("비밀번호"), 30, 120, 60, 30));
		add(setBounds(new JLabel("이름(한글)"), 30, 170, 60, 30));
		add(setBounds(new JLabel("이름(영문)"), 30, 220, 60, 30));
		add(setBounds(new JLabel("생년월일"), 30, 270, 60, 30));
		
		var tfId = new JTextField();
		var tfCheck = new JButton("중복확인");
		var tfPw = new JTextField();
		var tfKName = new JTextField();
		var tfEName = new JTextField();
		var birth = new JTextField();
		
		add(setBounds(tfId, 110, 70, 180, 30));
		add(setBounds(tfCheck, 310, 70, 90, 30));
		add(setBounds(tfPw, 110, 120, 180, 30));
		add(setBounds(tfKName, 110, 170, 180, 30));
		add(setBounds(tfEName, 110, 220, 180, 30));
		add(setBounds(birth, 110, 270, 180, 30));
		
		var bt = new JButton("회원가입");
		add(setBounds(bt, 150, 320, 100, 30));
		
		tfCheck.addActionListener(e -> {
			count++;
			
			if(tfId.getText().length() == 0) {
				showErr("아이디를 입력해주세요.");
				return;
			}
			
			var rs = getRs("SELECT * FROM user WHERE id = ?", tfId.getText());
			try {
				if(rs.next()) {
					showErr("중복된 아이디입니다.");
					tfId.setText("");
					tfId.grabFocus();
				}
				
				else {
					showInfo("사용 가능한 아이디 입니다.");
					return;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		bt.addActionListener(e -> {
			if(tfId.getText().length() == 0 || tfPw.getText().length() == 0 || tfKName.getText().length() == 0 || tfEName.getText().length() == 0 || birth.getText().length() == 0) {
				showErr("빈칸이 있습니다.");
				return;
			}
			
			if(count == 0) {
				showErr("중복확인을 해주세요.");
				return;
			}
			
			for (int i = 0; i < tfKName.getText().length(); i++) {
				String q = String.valueOf(tfKName.getText().charAt(i));
				if(!q.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣].*")) {
					showErr("한글 이름은 한글만 가능합니다.");
					tfKName.setText("");
					tfKName.grabFocus();
					return;
					
				}
			}

			int space = 0;
			
			for (int i = 0; i < tfEName.getText().length(); i++) {
				if(tfEName.getText().charAt(i) == ' ') space++;
				
				if(space == 0 && i == tfEName.getText().length() - 1) {
					showErr("영문 이름은 성과 이름을 구분해주세요.");
					tfEName.setText("");
					tfEName.grabFocus();
					return;
				}
			}

			for (int i = 0; i < tfEName.getText().length(); i++) {
				String q = String.valueOf(tfEName.getText().charAt(i));
				if(!q.matches(".*[A-Za-z A-Z].*")) {
					showErr("영문 이름은 영문만 가능합니다.");
					tfEName.setText("");
					tfEName.grabFocus();
					return;
				}
			}
			
			var date = new SimpleDateFormat("yyyy-MM-dd");
			date.setLenient(false);
			
			try {
				var d = date.parse(birth.getText());
				var now = new Date();
				
				if(d.compareTo(now) > 0) {
					showErr("생년월일을 확인해주세요.");
					birth.setText("");
					birth.grabFocus();
					return;
				}
			} catch (ParseException e1) {
				showErr("생년월일을 확인해주세요.");
				birth.setText("");
				birth.grabFocus();
				return;
			}
			
			showInfo("회원가입이 완료되었습니다.");
			update("INSERT INTO 2023지방_3.user (id, pw, name1, name2, birth, mileage) "
					+ "VALUES(?, ?, ?, ?, ?, ?)",
					tfId.getText(),
					tfPw.getText(),
					tfKName.getText(),
					tfEName.getText().toUpperCase(),
					birth.getText(),
					0
				);
			dispose();
			new MainFrameBefore().setVisible(true);
		});
	}

	public static void main(String[] args) {
		new SignUpFrame().setVisible(true);
	}
}
