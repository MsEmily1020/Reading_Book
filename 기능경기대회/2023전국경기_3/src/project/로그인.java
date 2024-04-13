package project;

import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class 로그인 extends BaseFrame {
	public 로그인() {
		super("로그인", 400, 250);
		
		main.add(setBounds(lb[0] = new JLabel("로그인", 0), 135, 10, 115, 35));
		main.add(setBounds(lb[1] = new JLabel("아이디"), 20, 55, 80, 35));
		main.add(setBounds(lb[2] = new JLabel("비밀번호"), 20, 100, 80, 35));
		main.add(setBounds(tf[0] = new JTextField(), 115, 50, 250, 40));
		main.add(setBounds(tf[1] = new JTextField(), 115, 100, 250, 35));
		main.add(setBounds(btn[0] = new JButton("로그인"), 20, 155, 345, 35));

		lb[0].setFont(new Font("HY헤드라인M", 1, 20));
		lb[1].setFont(new Font("HY헤드라인M", 1, 12));
		lb[2].setFont(new Font("HY헤드라인M", 1, 12));
		
		btn[0].addActionListener(e -> {
			if(tf[0].getText().trim().length() == 0 || tf[1].getText().trim().length() == 0) {
				showErr("빈칸이 있습니다.");
				return;
			}
			
			if(tf[0].getText().equals("admin") && tf[1].getText().equals("1234")) {
				showInfo("관리자님 환영합니다.");
				return;
			}
			
			try {
				var rs = getResult("select * from user where lower(id) = ? and lower(pw) = ?", tf[0].getText().toLowerCase(), tf[1].getText().toLowerCase());
				if(rs.next()) {
					changeFrame(new 메인());
				}
				else { 
					showErr("아이디 또는 비밀번호를 확인하세요.");
					tf[0].setText("");
					tf[1].setText("");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}
	
	public static void main(String[] args) {
		new 로그인().setVisible(true);
	}
}
