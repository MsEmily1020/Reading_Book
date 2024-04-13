package project;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SignUpFrameFix extends BaseFrame {
	public SignUpFrameFix() {
		super("정보수정", 350, 400);

		setLayout(null);
		var title = new JLabel("정보수정", 0);
		title.setFont(new Font("맑은 고딕", 1, 24));
		add(setBounds(title, 0, 20, 340, 30));
		
		add(setBounds(new JLabel("아이디"), 30, 70, 60, 30));
		add(setBounds(new JLabel("비밀번호"), 30, 120, 60, 30));
		add(setBounds(new JLabel("이름(한글)"), 30, 170, 60, 30));
		add(setBounds(new JLabel("이름(영문)"), 30, 220, 60, 30));
		add(setBounds(new JLabel("생년월일"), 30, 270, 60, 30));
		
		var tfId = new JTextField();
		var tfPw = new JTextField();
		var tfKName = new JTextField();
		var tfEName = new JTextField();
		var birth = new JTextField();
		
		add(setBounds(tfId, 110, 70, 200, 30));
		add(setBounds(tfPw, 110, 120, 200, 30));
		add(setBounds(tfKName, 110, 170, 200, 30));
		add(setBounds(tfEName, 110, 220, 200, 30));
		add(setBounds(birth, 110, 270, 200, 30));
		
		tfId.setText(MainFrameAfter.userId);
		tfId.setEnabled(false);
		tfPw.setText(MainFrameAfter.userPw);
		tfKName.setText(MainFrameAfter.userName1);
		tfEName.setText(MainFrameAfter.userName2);
		birth.setText(MainFrameAfter.birth);
		
		var bt = new JButton("정보수정");
		add(setBounds(bt, 120, 320, 100, 30));
		
		bt.addActionListener(e -> {
			showInfo(MainFrameAfter.userName1 + "님 정보가 수정되었습니다.");
			MainFrameAfter.userPw = tfPw.getText();
			MainFrameAfter.userName1 = tfKName.getText();
			MainFrameAfter.userName2 = tfEName.getText();
			MainFrameAfter.birth = birth.getText();
			
			update("UPDATE user SET pw = ?, name1 = ?, name2 = ?, birth = ? WHERE u_no = ?", tfPw.getText(), tfKName.getText(), tfEName.getText(), birth.getText(), MainFrameAfter.userNo);
			
			dispose();
			new MainFrameAfter().setVisible(true);
		});
	}

	public static void main(String[] args) {
		new SignUpFrameFix().setVisible(true);
	}
}
