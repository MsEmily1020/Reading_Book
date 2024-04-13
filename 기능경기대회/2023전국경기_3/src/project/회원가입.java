package project;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class 회원가입 extends BaseFrame {

	public 회원가입() {
		super("회원가입", 550, 450);

		main.add(setBounds(lb[0] = new JLabel("회원가입", 0), 200, 10, 120, 35));
		main.add(setBounds(lb[1] = new JLabel("이름"), 20, 70, 55, 25));
		main.add(setBounds(lb[2] = new JLabel("아이디"), 20, 105, 65, 40));
		main.add(setBounds(lb[3] = new JLabel("비밀번호"), 20, 150, 90, 35));
		main.add(setBounds(lb[4] = new JLabel("생년월일"), 20, 195, 95, 30));
		main.add(setBounds(lb[5] = new JLabel("키"), 25, 255, 60, 20));
		main.add(setBounds(lb[6] = new JLabel("몸무게"), 25, 295, 55, 30));
		main.add(setBounds(tf[0] = new JTextField(), 130, 60, 385, 30));
		main.add(setBounds(tf[1] = new JTextField(), 130, 100, 385, 30));
		main.add(setBounds(tf[2] = new JTextField(), 130, 145, 385, 30));
		main.add(setBounds(tf[3] = new JTextField(), 130, 195, 385, 30));
		main.add(setBounds(tf[4] = new JTextField(), 130, 250, 140, 25));
		main.add(setBounds(tf[5] = new JTextField(), 130, 300, 140, 25));
		main.add(setBounds(lb[7] = new JLabel("cm"), 285, 245, 55, 30));
		main.add(setBounds(lb[8] = new JLabel("kg"), 285, 290, 55, 30));
		main.add(setBounds(btn[0] = new JButton("회원가입"), 20, 350, 505, 40));

		lb[0].setFont(new Font("HY헤드라인M", 1, 20));
		lb[1].setFont(new Font("HY헤드라인M", 1, 12));
		lb[2].setFont(new Font("HY헤드라인M", 1, 12));
		lb[3].setFont(new Font("HY헤드라인M", 1, 12));
		lb[4].setFont(new Font("HY헤드라인M", 1, 12));
		lb[5].setFont(new Font("HY헤드라인M", 1, 12));
		lb[6].setFont(new Font("HY헤드라인M", 1, 12));
		lb[7].setFont(new Font("HY헤드라인M", 1, 15));
		lb[8].setFont(new Font("HY헤드라인M", 1, 15));

		if (userId > 0) {
			try {
				var rs = getResult("select * from user where u_no = ?", userId);
				if (rs.next()) {
					lb[0].setText("정보수정");
					tf[0].setText(rs.getString("u_name"));
					tf[1].setText(rs.getString("id"));
					tf[1].setEnabled(false);
					tf[2].setText(rs.getString("pw"));
					tf[3].setText(rs.getString("birth"));
					tf[4].setText(rs.getInt("height") + "");
					tf[5].setText(rs.getInt("weight") + "");
					btn[0].setText("정보수정");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		btn[0].addActionListener(e -> {
			// 회원가입
			for (int i = 0; i < 6; i++)
				if (tf[i].getText().trim().length() == 0) {
					showErr("빈칸이 있습니다.");
					tf[i].grabFocus();
					return;
				}

			if (!tf[0].getText().matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣].*")) {
				showErr("이름은 한글만 가능합니다.");
				tf[0].grabFocus();
				tf[0].setText("");
				return;
			}

			try {
				var rs = getResult("select * from user where id = ?", tf[1].getText());
				if (rs.next() || tf[1].getText().equals("admin")) {
					showErr("아이디가 중복되었습니다.");
					tf[1].grabFocus();
					tf[1].setText("");
					return;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			if (!(tf[2].getText().matches(".*[a-zA-Z1-9!@#$].*") && tf[2].getText().length() >= 6)) {
				showErr("비밀번호 형식이 일치하지 않습니다.");
				tf[2].grabFocus();
				tf[2].setText("");
				return;
			}

			try {
				if (new SimpleDateFormat("yyyy-MM-dd").parse(tf[3].getText()).compareTo(new Date()) > 0) {
					showErr("생년월일을 확인하세요.");
					tf[3].setText("");
					tf[3].grabFocus();
				}
			} catch (ParseException e1) {
				showErr("생년월일을 확인하세요.");
				tf[3].setText("");
				tf[3].grabFocus();
				return;
			}

			if (!(Integer.parseInt(tf[4].getText()) >= 100 && Integer.parseInt(tf[4].getText()) <= 200)) {
				showErr("키는 100~200 사이의 숫자로 입력해주세요.");
				tf[4].setText("");
				tf[4].grabFocus();
				return;
			}

			if (!(Integer.parseInt(tf[5].getText()) >= 10 && Integer.parseInt(tf[5].getText()) <= 120)) {
				showErr("몸무게는 10~120 사이의 숫자로 입력해주세요.");
				tf[5].setText("");
				tf[5].grabFocus();
				return;
			}

			try {
				update("insert into user (u_name, id, pw, birth, height, weight) values (?, ?, ?, ?, ?, ?)",
						tf[0].getText(), tf[1].getText(), tf[2].getText(), tf[3].getText(),
						Integer.parseInt(tf[4].getText()), Integer.parseInt(tf[5].getText()));
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			if(userId == 0) { 
				showInfo(tf[0].getText() + "님 회원가입이 완료되었습니다.");
				changeFrame(new 메인());
			}
			else {
				showInfo(tf[0].getText() + "님 회원정보가 수정되었습니다.");
				changeFrame(new 마이페이지());
			}
		});

	}

	public static void main(String[] args) {
		new 회원가입().setVisible(true);
	}
}
