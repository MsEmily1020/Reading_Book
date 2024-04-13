package project;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class 회원가입1 extends BaseFrame {
	
	int check0,check1,check2,check3,check4,check5;
	
	
	public 회원가입1() {
		super("회원가입", 500, 650);
		main.add(setBounds(lb[0] = new JLabel("회원가입", 0), 147, 33, 176, 48));

		main.add(setBounds(lb[1] = new JLabel("약관에 동의해주세요.", 0), 153, 90, 164, 27));

		main.add(setBounds(lb[2] = new JLabel("전체 동의"), 80, 130, 94, 30));

		main.add(setBounds(lb[3] = new JLabel("<html>아래 모든 약관 및 프로모션 안내 수신(선택)<br>내용을 확인하고 동의합니다.</html>"), 38, 170,
				300, 60));
		main.add(setBounds(lb[4] = new JLabel(), 20, 245, getWidth() - 50, 3));

		main.add(setBounds(btn[0] = new JButton(getIcon("datafiles/체크전.png", 30, 30)), 40, 130, 30, 30));
		main.add(setBounds(btn[1] = new JButton(getIcon("datafiles/체크전.png", 30, 30)), 40, 252, 30, 30));
		main.add(setBounds(btn[2] = new JButton(getIcon("datafiles/체크전.png", 30, 30)), 40, 291, 30, 30));
		main.add(setBounds(btn[3] = new JButton(getIcon("datafiles/체크전.png", 30, 30)), 40, 333, 30, 30));
		main.add(setBounds(btn[4] = new JButton(getIcon("datafiles/체크전.png", 30, 30)), 40, 410, 30, 30));
		main.add(setBounds(btn[5] = new JButton(getIcon("datafiles/체크전.png", 30, 30)), 40, 460, 30, 30));
		
		btn[0].addActionListener(e -> {
			if (check0 == 0) { btn[0].setIcon(getIcon("datafiles/체크후.png", 30, 30)); check0 = 1; }
			else { btn[0].setIcon(getIcon("datafiles/체크전.png", 30, 30)); check0 = 0; }
		});
		
		btn[1].addActionListener(e -> {
			if (check1 == 0) { btn[1].setIcon(getIcon("datafiles/체크후.png", 30, 30)); check1 = 1; }
			else { btn[1].setIcon(getIcon("datafiles/체크전.png", 30, 30)); check1 = 0; }
		});
		
		btn[2].addActionListener(e -> {
			if (check2 == 0) { btn[2].setIcon(getIcon("datafiles/체크후.png", 30, 30)); check2 = 1; }
			else { btn[2].setIcon(getIcon("datafiles/체크전.png", 30, 30)); check2 = 0; }
		});
		
		btn[3].addActionListener(e -> {
			if (check3 == 0) { btn[3].setIcon(getIcon("datafiles/체크후.png", 30, 30)); check3 = 1; }
			else { btn[3].setIcon(getIcon("datafiles/체크전.png", 30, 30)); check3 = 0; }
		});
		
		btn[4].addActionListener(e -> {
			if (check4 == 0) { btn[4].setIcon(getIcon("datafiles/체크후.png", 30, 30)); check4 = 1; }
			else { btn[4].setIcon(getIcon("datafiles/체크전.png", 30, 30)); check4 = 0; }
		});
		
		btn[5].addActionListener(e -> {
			if (check5 == 0) { btn[5].setIcon(getIcon("datafiles/체크후.png", 30, 30)); check5 = 1; }
			else { btn[5].setIcon(getIcon("datafiles/체크전.png", 30, 30)); check5 = 0; }
		});

		main.add(setBounds(lb[12] = new JLabel(), 20, 285, getWidth() - 50, 3));

		main.add(setBounds(lb[5] = new JLabel("[필수]"), 80, 253, 62, 26));
		main.add(setBounds(lb[6] = new JLabel("[필수]"), 80, 291, 62, 26));
		main.add(setBounds(lb[7] = new JLabel("[필수]"), 80, 335, 62, 26));

		main.add(setBounds(lb[13] = new JLabel(), 20, 325, getWidth() - 50, 3));

		main.add(setBounds(lb[8] = new JLabel("에더랜드 이용약관"), 140, 258, 190, 20));
		main.add(setBounds(lb[9] = new JLabel("전자상거래 이용약관"), 140, 296, 190, 20));
		main.add(setBounds(lb[10] = new JLabel("개인정보 수집 및 활용 동의"), 140, 338, 190, 20));
		main.add(setBounds(lb[11] = new JLabel("프로모션 안내 수신 동의 (선택)"), 30, 375, 250, 25));
		main.add(setBounds(lb[14] = new JLabel("이메일 수신 동의"), 80, 415, 250, 25));
		main.add(setBounds(lb[15] = new JLabel("문자 수신 동의"), 80, 465, 250, 25));

		main.add(setBounds(lb[16] = new JLabel(), 20, 505, getWidth() - 50, 3));

		main.add(setBounds(btn[6] = new JButton("회원가입"), 17, 539, 452, 43));
		
		main.add(setBounds(btn[7] = new JButton("▷"), 433, 250, 30, 30));
		main.add(setBounds(btn[8] = new JButton("▷"), 433, 290, 30, 30));
		main.add(setBounds(btn[9] = new JButton("▷"), 433, 330, 30, 30));

		btn[6].addActionListener(e -> {
		});
		
		changeWhite(main);

		lb[0].setFont(new Font("HY헤드라인M", 1, 30));
		lb[1].setFont(new Font("HY헤드라인M", 1, 13));
		lb[2].setFont(new Font("HY헤드라인M", 1, 17));

		lb[1].setForeground(Color.lightGray);
		lb[3].setForeground(Color.lightGray);
		lb[5].setForeground(Color.red);
		lb[6].setForeground(Color.red);
		lb[7].setForeground(Color.red);
		lb[8].setForeground(Color.gray);
		lb[9].setForeground(Color.gray);
		lb[10].setForeground(Color.gray);
		lb[11].setForeground(Color.gray);

		lb[4].setBorder(new LineBorder(Color.gray));
		lb[12].setBorder(new LineBorder(Color.lightGray));
		lb[13].setBorder(new LineBorder(Color.lightGray));
		lb[16].setBorder(new LineBorder(Color.GRAY));
		
		btn[6].setBackground(Color.pink);
		btn[6].setForeground(Color.white);

	}

	public static void main(String[] args) {
		new 회원가입1().setVisible(true);
	}
}
