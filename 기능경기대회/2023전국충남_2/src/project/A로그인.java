package project;

import java.awt.Color;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class A로그인 extends BaseFrame {
	
	Calendar cal = Calendar.getInstance();
	
	public A로그인() {
		super("로그인", 300, 220);
		main.add(setBounds(lb[0] = new JLabel(" 로그인"), 0, 0, 1000, 30));
		main.add(setBounds(lb[1] = new JLabel("아이디 : "), 20, 50, 70, 20));
		main.add(setBounds(lb[2] = new JLabel("비밀번호 : "), 20, 80, 70, 20));
		main.add(setBounds(tf[0] = new JTextField(), 95, 45, 165, 25));
		main.add(setBounds(tf[1] = new JTextField(), 95, 80, 165, 25));
		main.add(setBounds(btn[0] = actionbtn("로그인", e -> 로그인()), 95, 115, 165, 30));
		main.add(setBounds(btn[1] = new JButton("회원이 아니신가요?"), 60, 155, 175, 20));

		setComponent(main);
		
		lb[0].setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		btn[1].setOpaque(true);
		btn[1].setBorder(new LineBorder(Color.WHITE));
		btn[1].setBackground(Color.WHITE);
		btn[1].setForeground(Color.BLUE);
		
		cal.add(Calendar.YEAR, -1);
	}
	
	private void 로그인() {
		ResultSet rs; 
		try {
			if (tf[0].getText().equals("admin") && tf[1].getText().equals("1234")) {
				u_no = 0;
				changeFrame(new B메인());
				return;
			}
			
			rs = getResult("SELECT * FROM user\r\n"
					+ "left join secession on secession.u_no = user.u_no\r\n"
					+ "left join account on account.u_no = user.u_no\r\n"
					+ "where u_id = ? and u_pw = ? order by account.a_no desc", tf[0].getText(), tf[1].getText());
			
			if (!rs.next()) {
				showErr("아이디 또는 비밀번호가 일치하지 않습니다."); return;
			}
			
			if (rs.getDate("u_logindate").before(cal.getTime())) {
				if (JOptionPane.showConfirmDialog(null, "휴면계정 복원을 신청하시겠습니까?", "휴면계정",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					update("insert into account values(null, ?, 0)", rs.getInt(1));
				}
				return;
			}
			if (rs.getString("s_no") != null) {
				if (JOptionPane.showConfirmDialog(null, "탈퇴계정 복원을 신청하시겠습니까?", "탈퇴계정",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					update("insert into account values(null, ?, 1)", rs.getInt(1));
				}
				return;
			}
			
			if (rs.getString("a_no") != null) { // null 임을 확인하기  위해 getString을 사용함.
				
				if (rs.getInt("restore") == 0) {
					showInfo("이미 복원신청을 하였습니다.");
					return;
				}
				if (rs.getInt("restore") == 1) {
					showInfo("이미 복원신청을 하였습니다.");
					return;
				}
				
				update("delete from secession where u_no = ?", rs.getString(1));
				update("delete from account where u_no = ?", rs.getString(1));
				
				showInfo((rs.getInt("restore") == 2? "휴면":"탈퇴") + "계정이 복원되었습니다.");
			}
			update("update user set u_logindate = ?", sdf.format(new Date()));
			
			u_no = rs.getInt(1);
			
			changeFrame(new B메인());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new A로그인().setVisible(true);
	}
}
