package project;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class 로그인 extends BaseFrame {
	public 로그인() {
		super("login", 300, 200);
		main.add(setBounds(tf[0] = new JTextField("ID"), 15, 15, 260, 35));
		main.add(setBounds(tf[1] = new JTextField("PW"), 15, 60, 260, 35));
		main.add(setBounds(btn[0] = new JButton("로그인", getIcon("datafiles/아이콘/알약.png", 30, 30)), 15, 110, 260, 35));
		
		setComponent(main);
		
		btn[0].setBackground(Color.green);
		tf[0].setBorder(new LineBorder(Color.gray));
		tf[1].setBorder(new LineBorder(Color.gray));
		
		btn[0].addActionListener(e -> {
			if(tf[0].getText().length() == 0 || tf[1].getText().length() == 0) {
				showErr("일치하지 않는 정보입니다.");
				return;
			}
			
			if(tf[0].getText().equals("admin") && tf[1].getText().equals("1234")) {
				showInfo("관리자로 로그인 하였습니다.");
				changeFrame(new 약국());
				return;
			}
			
			try {
				var rs1 = getResult("select * from user where u_id = ? and u_pw = ?", tf[0].getText(), tf[1].getText());
				var rs2 = getResult("select * from drugstore where d_id = ? and d_pw = ?", tf[0].getText(), tf[1].getText());
				
				if(rs1.next()) {
					BaseFrame.userId = rs1.getInt("u_no");
					BaseFrame.userName = rs1.getString("u_name");
					BaseFrame.userAge = rs1.getInt("u_age");
					BaseFrame.userGender = rs1.getInt("u_gender") == 1 || rs1.getInt("u_gender") == 3 ? "남성" : "여성"; 
					showInfo(userName + " 회원으로 로그인 하였습니다.");
					changeFrame(new 유저메인());
				}
				
				else if(rs2.next()) {
					BaseFrame.storeName = rs2.getString("d_name");
					BaseFrame.storeAddress = rs2.getString("d_address");
					showInfo(storeName + " 약국으로 로그인 하였습니다.");
					changeFrame(new 약국메인());
				}
				
				else {
					showErr("일치하지 않는 정보입니다.");
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
