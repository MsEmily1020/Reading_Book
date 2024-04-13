package project;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class 메인 extends BaseFrame {
	public static int userNo;
	public static String userID;

	String str1, str2, str3, str4, path1, path2, path3, path4;

	public 메인() {
		super("메인", 1000, 800);

		// 로고
		main.add(setBounds(lb[0] = new JLabel(getIcon("datafiles/로고/로고2.jpg", 280, 40)), 350, 15, 290, 50));

		// 비회원일때
		str1 = "회원가입";
		str2 = "로그인";
		str3 = "즐길거리";
		str4 = "예약";
		path1 = "datafiles/로고/가입.png";
		path2 = "datafiles/로고/로그인.png";
		path3 = "datafiles/로고/즐길거리.png";
		path4 = "datafiles/로고/예매.png";

		// 회원일때
		if (userNo > 0) {
			str1 = "정보수정";
			str2 = "로그아웃";
			path1 = "datafiles/로고/수정.png";
			path2 = "datafiles/로고/로그아웃.png";
		}

		// 관리자일때
		else if (userNo == -255) {
			str1 = "";
			str2 = "로그아웃";
			str3 = "관리";
			str4 = "분석";
			path1 = "data";
			path2 = "datafiles/로고/로그아웃.png";
			path3 = "datafiles/로고/관리.png";
			path4 = "datafiles/로고/분석.png";
		}

		// 회원가입
		main.add(setBounds(btn[0] = new JButton(str1), 840, 20, 95, 35));
		main.add(setBounds(lb[7] = new JLabel(getIcon(path1, 30, 30)), 935, 20, 35, 35));

		btn[0].addActionListener(e -> {
			if (str1.equals("회원가입"))
				changeFrame(new 회원가입1());
		});
		// 라인
		main.add(setBounds(lb[1] = new JLabel(), 0, 90, 1000, 3));

		// 로그인 / 즐길거리 / 혜택
		main.add(setBounds(btn[1] = new JButton(str2), 90, 140, 80, 40));

		// 로그인 버튼 리스너
		btn[1].addActionListener(e -> {
			changeFrame(new 로그인());
		});

		main.add(setBounds(lb[8] = new JLabel(getIcon(path2, 30, 35)), 185, 140, 30, 35));

		main.add(setBounds(btn[2] = new JButton(str3), 255, 140, 80, 40));
		main.add(setBounds(lb[9] = new JLabel(getIcon(path3, 30, 35)), 345, 140, 35, 35));

		main.add(setBounds(btn[3] = new JButton(str4), 425, 140, 80, 40));
		main.add(setBounds(lb[10] = new JLabel(getIcon(path4, 30, 35)), 505, 140, 35, 35));

		// 더 신나게 에더랜드를 즐기는 법!!!
		main.add(setBounds(lb[2] = new JLabel("더 신나게 에더랜드를 즐기는 법!!!", 0), 655, 120, 275, 50));

		// B구역
		main.add(setBounds(lb[3] = new JLabel(), 600, 190, 175, 140));
		main.add(setBounds(lb[4] = new JLabel(), 790, 190, 175, 140));

		// C 구역
		main.add(setBounds(btn[4] = new JButton(), 780, 410, 105, 20));
		main.add(setBounds(lb[5] = new JLabel(), 600, 450, 360, 185));

		// A 구역
		String[] str = "화장실,의무실,식당,편의존,어트랙션".split(",");

		for (int i = 0; i < str.length; i++) {
			main.add(setBounds(btn[i + 5] = new JButton(str[i]), 10, 500 + i * 40, 85, 20));
		}

		for (int i = 1; i <= 5; i++) {
			main.add(setBounds(lb[i + 10] = new JLabel(getIcon("datafiles/로고/" + i + ".png", 30, 30)), 120,
					455 + i * 40, 30, 30));
		}

		main.add(setBounds(lb[6] = new JLabel(getIcon("datafiles/지도.jpg", 570, 500)), 2, 200, 570, 500));
		main.add(setBounds(lb[11] = new JLabel("Welcome to the fairyland."), 200, 730, 340, 15));

		changeWhite(main);

		for (Component comp : main.getComponents()) {
			((JComponent) comp).setBorder(null);
			comp.setBackground(Color.white);
		}

		lb[1].setBorder(new LineBorder(Color.pink));

		lb[3].setBorder(new LineBorder(Color.black));
		lb[4].setBorder(new LineBorder(Color.black));
		lb[5].setBorder(new LineBorder(Color.black));
		lb[6].setBorder(new LineBorder(Color.black));
	}

	public static void main(String[] args) {
		new 메인().setVisible(true);
	}
}
