package project;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class 회원가입2 extends BaseFrame {
	public 회원가입2() {
		super("회원가입", 500, 700);
		main.add(setBounds(lb[0] = new JLabel("회원가입", 0), 150, 20, 174, 35));
		main.add(setBounds(lb[1] = new JLabel("아이디"), 15, 83, 130, 38));
		main.add(setBounds(lb[2] = new JLabel("비밀번호"), 15, 140, 130, 31));
		main.add(setBounds(lb[3] = new JLabel("이름"), 15, 210, 130, 13));
		main.add(setBounds(lb[4] = new JLabel("키/몸무게"), 15, 250, 130, 20));
		main.add(setBounds(lb[5] = new JLabel("생년월일"), 15, 290, 130, 27));
		main.add(setBounds(lb[6] = new JLabel("이메일"), 15, 340, 130, 24));
		main.add(setBounds(lb[7] = new JLabel("이메일 인증번호"), 15, 395, 130, 34));
		main.add(setBounds(lb[8] = new JLabel("전화번호"), 15, 445, 130, 32));
		main.add(setBounds(lb[9] = new JLabel("전화번호 인증번호"), 15, 498, 130, 35));
		
		main.add(setBounds(btn[0] = new JButton("회원가입"), 38, 593, 428, 40));
		
		// 아이디
		main.add(setBounds(tf[0] = new JTextField(), 134, 89, 245, 27));
		
		main.add(setBounds(lb[10] = new JLabel("영문 소문자, 숫자 6~16자"), 132, 118, 176, 21));
		
		// 비밀번호
		main.add(setBounds(tf[1] = new JTextField(), 134, 147, 245, 27));
		main.add(setBounds(lb[11] = new JLabel("영문 대/소문자, 숫자, 특수문자(!@#$%)포함 7글자 이상"), 137, 178, 300, 21));
		
		// 이름
		main.add(setBounds(tf[2] = new JTextField(), 134, 207, 245, 27));
		
		// 키/몸무게
		main.add(setBounds(tf[3] = new JTextField(), 134, 245, 90, 27));
		main.add(setBounds(lb[12] = new JLabel("(cm)"), 238, 250, 48, 20));
		
		main.add(setBounds(tf[4] = new JTextField(), 278, 245, 90, 27));
		main.add(setBounds(lb[13] = new JLabel("(kg)"), 370, 250, 48, 20));
		
		// 생년월일
		main.add(setBounds(tf[5] = new JTextField(), 134, 287, 65, 27));
		main.add(setBounds(lb[14] = new JLabel("년"), 201, 290, 23, 21));
		main.add(setBounds(tf[6] = new JTextField(), 234, 287, 45, 27));
		main.add(setBounds(lb[15] = new JLabel("월"), 285, 290, 23, 21));
		main.add(setBounds(tf[7] = new JTextField(), 304, 287, 45, 27));
		main.add(setBounds(lb[16] = new JLabel("일"), 364, 290, 23, 21));
		
		// 이메일
		main.add(setBounds(tf[9] = new JTextField(), 134, 340, 245, 27));
		
		// 이메일 인증번호
		main.add(setBounds(tf[10] = new JTextField(), 134, 396, 245, 27));
		
		// 전화번호
		main.add(setBounds(tf[11] = new JTextField(), 134, 445, 49, 27));
		main.add(setBounds(lb[17] = new JLabel("-"), 190, 445, 32, 20));
		main.add(setBounds(tf[12] = new JTextField(), 206, 445, 70, 27));
		main.add(setBounds(lb[18] = new JLabel("-"), 290, 445, 32, 20));
		main.add(setBounds(tf[13] = new JTextField(), 310, 445, 70, 27));
		
		// 전화번호 인증번호
		main.add(setBounds(tf[14] = new JTextField(), 134, 502, 245, 27));
		
		// 전화번호 인증확인
		main.add(setBounds(btn[1] = new JButton("인증확인"), 395, 502, 85, 27));
	
		// 전화번호 인증하기
		main.add(setBounds(btn[2] = new JButton("인증하기"), 395, 445, 85, 27));
		
		// 이메일 인증 확인
		main.add(setBounds(btn[3] = new JButton("인증확인"), 395, 396, 85, 27));
		
		// 이메일 인증하기
		main.add(setBounds(btn[4] = new JButton("인증하기"), 395, 340, 85, 27));
		
		// 아이디 중복 확인
		main.add(setBounds(btn[5] = new JButton("중복확인"), 395, 89, 85, 27));

		changeWhite(main);
		
		for(int i = 0; i < 6; i++) {
			btn[i].setBackground(Color.pink);
			btn[i].setForeground(Color.white);
		}
		
		lb[0].setFont(new Font("HY헤드라인M", 1, 30));
		lb[10].setFont(new Font("HY헤드라인M", 1, 10));
		lb[11].setFont(new Font("HY헤드라인M", 1, 10));
		lb[10].setForeground(Color.LIGHT_GRAY);
		lb[11].setForeground(Color.LIGHT_GRAY);
		
	}

	public static void main(String[] args) {
		new 회원가입2().setVisible(true);
	}
}
